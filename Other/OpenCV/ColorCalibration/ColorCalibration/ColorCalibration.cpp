#include "cv.h"
#include "cv.hpp"
#include "highgui.h"
#include <conio.h>

IplImage* theWorkingMask1;
IplImage* theWorkingMask2;
IplImage* theWorkingMask3;

#define HUE_RANGE 5

void getMaskInv(int hue, int range, IplImage* originalHue, IplImage* destMask)
{
  int maxHue;
  int minHue;

  maxHue = hue + range;
  minHue = hue - range;
  if(maxHue > 255)
  {
    maxHue = 255;
  }
  
  if(minHue < 0)
  {
    minHue = 0;
  }

//  cvAdaptiveThreshold(originalHue,theWorkingMask1,255,CV_ADAPTIVE_THRESH_MEAN_C,CV_THRESH_BINARY,3,maxHue);
  cvThreshold(originalHue,theWorkingMask1,maxHue,255,CV_THRESH_BINARY);
//  cvAdaptiveThreshold(originalHue,theWorkingMask2,255,CV_ADAPTIVE_THRESH_MEAN_C,CV_THRESH_BINARY,3,minHue);
  cvThreshold(originalHue,theWorkingMask2,minHue,255,CV_THRESH_BINARY);

  cvNot(theWorkingMask1,theWorkingMask3);
  cvAnd(theWorkingMask2, theWorkingMask3, destMask);
}

void getMask(int hue, int range, IplImage* originalHue, IplImage* destMask)
{
  int maxHue;
  int minHue;

  maxHue = hue + range;
  minHue = hue - range;
  if(maxHue > 255)
  {
    maxHue = 255;
  }
  
  if(minHue < 0)
  {
    minHue = 0;
  }

//  cvAdaptiveThreshold(originalHue,theWorkingMask1,255,CV_ADAPTIVE_THRESH_GAUSSIAN_C,CV_THRESH_BINARY,3,maxHue);
  cvThreshold(originalHue,theWorkingMask1,maxHue,255,CV_THRESH_BINARY);
//  cvAdaptiveThreshold(originalHue,theWorkingMask2,255,CV_ADAPTIVE_THRESH_GAUSSIAN_C,CV_THRESH_BINARY,3,minHue);
  cvThreshold(originalHue,theWorkingMask2,minHue,255,CV_THRESH_BINARY);

  cvNot(theWorkingMask1,theWorkingMask3);
  cvAnd(theWorkingMask2, theWorkingMask3, destMask);
}

/*
void getMaskInv(int hue, int range, IplImage* originalHue, IplImage* destMask)
{
  int maxHue;
  int minHue;

  maxHue = hue + range;
  minHue = hue - range;
  if(maxHue > 255)
  {
    maxHue = 255;
  }
  
  if(minHue < 0)
  {
    minHue = 0;
  }

  cvThreshold(originalHue,theWorkingMask1,maxHue,255,CV_THRESH_BINARY);
  cvThreshold(originalHue,theWorkingMask2,minHue,255,CV_THRESH_BINARY);

  cvNot(theWorkingMask1,theWorkingMask3);
  cvAnd(theWorkingMask2, theWorkingMask3, destMask);
}

void getMask(int hue, int range, IplImage* originalHue, IplImage* destMask)
{
  int maxHue;
  int minHue;

  maxHue = hue + range;
  minHue = hue - range;
  if(maxHue > 255)
  {
    maxHue = 255;
  }
  
  if(minHue < 0)
  {
    minHue = 0;
  }

  cvThreshold(originalHue,theWorkingMask1,maxHue,255,CV_THRESH_BINARY);
  cvThreshold(originalHue,theWorkingMask2,minHue,255,CV_THRESH_BINARY);

  cvNot(theWorkingMask1,theWorkingMask3);
  cvAnd(theWorkingMask2, theWorkingMask3, destMask);
}
*/

void RemoveNoise(IplImage * src)
{
  //get the size of input_image (src)
  CvSize size = cvSize( src->width & -2, src->height & -2 ); 

  //create  temp-image
  IplImage* pyr = cvCreateImage( cvSize(size.width/2, size.height/2), src->depth, src->nChannels ); 

  cvPyrDown( src, pyr, CV_GAUSSIAN_5x5 );			//pyr DOWN
  cvPyrUp( pyr, src, CV_GAUSSIAN_5x5 );				//and UP
  cvReleaseImage(&pyr);               //release temp
}

int hueValue=27;
int hueRange=2;

void switchValueCallback( int position ) 
{
  hueValue = position;
}

void switchRangeCallback( int position ) 
{
  hueRange = position;
}



int main(int argc, char* argv[])
{
  IplImage *theImageFromTheCamera;
  CvCapture* capture;
  IplImage* theHue;
  IplImage* theSature;
  IplImage* theLum;
  IplImage* hSVImage;
  IplImage* theMask;
  IplImage* theWhiteMask;

  /*
  ** Start up the camera and open a window for output.
  */
  capture = cvCaptureFromCAM(0);
  cvNamedWindow( "Source", 1 );
  cvNamedWindow( "Mask", 1 );

//  cvNamedWindow( "Hue", 1 );
//  cvNamedWindow( "Lum", 1 );
  cvNamedWindow( "WhiteMask", 1 );

  cvNamedWindow( "Working1", 1 );
  cvNamedWindow( "Working2", 1 );
//  cvNamedWindow( "Working3", 1 );


  cvCreateTrackbar("hueValue","Source",&hueValue,255,switchValueCallback);
  cvCreateTrackbar("hueRange","Source",&hueRange,25,switchRangeCallback);

  cvGrabFrame(capture );
  theImageFromTheCamera = cvRetrieveFrame( capture );
  hSVImage       = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 3 );
  theSature      = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theLum         = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theHue         = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theWorkingMask1= cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theWorkingMask2= cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theWorkingMask3= cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theMask        = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theWhiteMask   = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );

  while(!kbhit())
  {
    /*
    ** Get a frame from the camera
    */
    cvGrabFrame(capture );
    theImageFromTheCamera = cvRetrieveFrame( capture );
    cvCvtColor( theImageFromTheCamera, hSVImage, CV_BGR2HLS);
// 	  cvCvtColor( theImageFromTheCamera, hSVImage, CV_BGR2HSV);
//    cvCvtColor( theImageFromTheCamera, hSVImage, CV_BGR2YCrCb);
//    cvSplit( theImageFromTheCamera, theHue, theSature, theLum, NULL);
    cvSplit( hSVImage, theHue, theLum, theSature, NULL);
//White
    getMaskInv(190, 30, theLum, theWhiteMask);

//Blue
    getMask(hueValue, hueRange, theHue, theMask);
//    RemoveNoise( theMask);
//    cvSmooth(theMask,theWorkingMask2,CV_MEDIAN);
    cvErode(theMask,theWorkingMask2,0,2);
    cvNot(theWhiteMask,theWorkingMask3);
    cvAnd(theMask, theWorkingMask3, theWorkingMask1);

    cvShowImage( "Source", hSVImage );
    cvShowImage( "Mask", theMask );
    cvShowImage( "WhiteMask", theWhiteMask );
    cvShowImage( "Working1", theWorkingMask1 );
    cvShowImage( "Working2", theWorkingMask2 );

    char c = cvWaitKey(33);
    if( c == 27 ) break;
    /*
    ** Don't clogg the CPU!
    */
    Sleep(25);
  }

  cvReleaseCapture(&capture);

  return 0;
}


