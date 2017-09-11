#include "cv.h"
#include "cv.hpp"
#include "highgui.h"
#include "BackPlane.h"

CBackPlane::CBackPlane()
{
    int i;
    
    memset( m_color_planes, 0, sizeof(m_color_planes));
    m_threshold = 0;

    for( i = 0; i < CV_MAX_DIM; i++ )
    {
        m_min_ch_val[i] = 0;
        m_max_ch_val[i] = 255;
        m_hist_ranges[i] = m_hist_ranges_data[i];
        m_hist_ranges[i][0] = 0.f;
        m_hist_ranges[i][1] = 256.f;
    }

    m_hist = 0;
    m_back_project = 0;
    m_temp = 0;
    m_mask = 0;
}


CBackPlane::~CBackPlane()
{
    int i;
    
    cvReleaseHist( &m_hist );
    for( i = 0; i < CV_MAX_DIM; i++ )
        cvReleaseImage( &m_color_planes[i] );
    cvReleaseImage( &m_back_project );
    cvReleaseImage( &m_temp );
    cvReleaseImage( &m_mask );
}


void
CBackPlane::color_transform( const IplImage* image )
{
    CvSize size = cvGetSize(image);
    uchar* color_data = 0, *mask = 0;
    uchar* planes[CV_MAX_DIM];
    int x, color_step = 0, plane_step = 0, mask_step;
    int dims[CV_MAX_DIM];
    int i, n = get_hist_dims(dims);

    assert( image->nChannels == 3 && m_hist != 0 );
    
    if( !m_temp || !m_mask || !m_color_planes[0] || !m_color_planes[n-1] || !m_back_project ||
        m_temp->width != size.width || m_temp->height != size.height ||
        m_temp->nChannels != 3 )
    {
        cvReleaseImage( &m_temp );
        m_temp = cvCreateImage( size, IPL_DEPTH_8U, 3 );
        cvReleaseImage( &m_mask );
        m_mask = cvCreateImage( size, IPL_DEPTH_8U, 1 );
        cvReleaseImage( &m_back_project );
        m_back_project = cvCreateImage( size, IPL_DEPTH_8U, 1 );
        for( i = 0; i < CV_MAX_DIM; i++ )
        {
            cvReleaseImage( &m_color_planes[i] );
            if( i < n )
                m_color_planes[i] = cvCreateImage( size, IPL_DEPTH_8U, 1 );
        }
    }

    cvCvtColor( image, m_temp, CV_BGR2HSV );
    cvGetRawData( m_temp, &color_data, &color_step, &size );
    cvGetRawData( m_mask, &mask, &mask_step, &size );
    
    for( i = 0; i < n; i++ )
        cvGetRawData( m_color_planes[i], &planes[i], &plane_step, &size );

    for( ; size.height--; color_data += color_step, mask += mask_step )
    {
        for( x = 0; x < size.width; x++ )
        {
            int val0 = color_data[x*3];
            int val1 = color_data[x*3+1];
            int val2 = color_data[x*3+2];
            if( m_min_ch_val[0] <= val0 && val0 <= m_max_ch_val[0] &&
                m_min_ch_val[1] <= val1 && val1 <= m_max_ch_val[1] &&
                m_min_ch_val[2] <= val2 && val2 <= m_max_ch_val[2] )
            {
                // hue is written to the 0-th plane, saturation - to the 1-st one,
                // so 1d histogram will automagically correspond to hue-based tracking,
                // 2d histogram - to saturation-based tracking.
                planes[0][x] = (uchar)val0;
                if( n > 1 )
                    planes[1][x] = (uchar)val1;
                if( n > 2 )
                    planes[2][x] = (uchar)val2;

                mask[x] = (uchar)255;
            }
            else
            {
                planes[0][x] = 0;
                if( n > 1 )
                    planes[1][x] = 0;
                if( n > 2 )
                    planes[2][x] = 0;
                mask[x] = 0;
            }
        }
        for( i = 0; i < n; i++ )
            planes[i] += plane_step;
    }
}


bool
CBackPlane::update_histogram( const IplImage* cur_frame )
{
    float max_val = 0;
    int i, dims;

    if( m_comp.rect.width == 0 || m_comp.rect.height == 0 ||
        m_hist == 0 )
    {
        assert(0);
        return false;
    }

    color_transform(cur_frame);

    dims = cvGetDims( m_hist->bins );
    for( i = 0; i < dims; i++ )
        cvSetImageROI( m_color_planes[i], m_comp.rect );
    cvSetImageROI( m_mask, m_comp.rect );

    cvSetHistBinRanges( m_hist, m_hist_ranges, 1 );
    cvCalcHist( m_color_planes, m_hist, 0, m_mask );

    for( i = 0; i < dims; i++ )
        cvSetImageROI( m_color_planes[i], m_comp.rect );

    for( i = 0; i < dims; i++ )
        cvResetImageROI( m_color_planes[i] );
    cvResetImageROI( m_mask );

    cvGetMinMaxHistValue( m_hist, 0, &max_val );
    cvScale( m_hist->bins, m_hist->bins, max_val ? 255. / max_val : 0. );

    return max_val != 0;
}


void
CBackPlane::reset_histogram()
{
    if( m_hist )
        cvClearHist( m_hist );
}

bool
CBackPlane::set_hist_dims( int c_dims, int *dims )
{
    if( (unsigned)(c_dims-1) >= (unsigned)CV_MAX_DIM || dims == 0 )
        return false;

    if( m_hist )
    {
        int dims2[CV_MAX_DIM];
        int c_dims2 = cvGetDims( m_hist->bins, dims2 );

        if( c_dims2 == c_dims && memcmp( dims, dims2, c_dims*sizeof(dims[0])) == 0 )
            return true;

        cvReleaseHist( &m_hist );
    }

    m_hist = cvCreateHist( c_dims, dims, CV_HIST_ARRAY, 0, 0 );

    return true;
}


bool
CBackPlane::set_hist_bin_range( int channel, int min_val, int max_val )
{
    if( (unsigned)channel >= (unsigned)CV_MAX_DIM ||
        min_val >= max_val || min_val < 0 || max_val > 256 )
    {
        assert(0);
        return false;
    }

    m_hist_ranges[channel][0] = (float)min_val;
    m_hist_ranges[channel][1] = (float)max_val;

    return true;
}

IplImage* CBackPlane::get_back_project( const IplImage* cur_frame )
{
  if( m_hist == 0 )
  {
      return false;
  }
  
  color_transform( cur_frame );
  cvCalcBackProject( m_color_planes, m_back_project, m_hist );
  cvAnd( m_back_project, m_mask, m_back_project );

  return m_back_project;
}

