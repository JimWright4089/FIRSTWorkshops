#ifdef _CH_
#pragma package <opencv>
#endif

#ifndef _EiC
#include "cv.h"
#include "highgui.h"
#include <math.h>
#include <tesseract/baseapi.h>
//#include "imgs.h"
//#include "tessdll.h"
#endif

#define w 500
int levels = 3;
CvSeq* contours = 0;
IplImage* img1;
tesseract::TessBaseAPI *api = new tesseract::TessBaseAPI();


void ConvertToTessImage(unsigned char* buff_in, unsigned char* buff_out, int length)
{
  int i;
  unsigned char new_byte;
  unsigned char* buff_ptr;
  unsigned char* new_buff_loc;
  
  buff_ptr     = buff_in;
  new_buff_loc = buff_out;
  
  if(*buff_ptr > 128)
  {
    new_byte = 1;
  }
  else
  {
    new_byte = 0;
  }
  buff_ptr++;  
  
  for(i=1;i<length;i++)
  {
    if((i%8)==0)
    {
      *new_buff_loc = new_byte;
      new_buff_loc++;
    
      new_byte = 0;
    }
    
    new_byte = new_byte<<1;
    if(*buff_ptr > 128)
    {
      new_byte += 1;
    }
    buff_ptr++;  
  }

  *new_buff_loc = new_byte;
  new_buff_loc++;

  new_byte = 0;
}

void ConvertToText(IplImage* text_image, char* text)
{
  unsigned char* buffer;
  int text_loc=0;
  int out_size=(text_image->imageSize/8);

  buffer = (unsigned char*)malloc(out_size+100);
  ConvertToTessImage((unsigned char*)text_image->imageData, buffer, text_image->imageSize);

  api->SetImage((const Pix*)buffer);
//  api->BeginPageUpright(text_image->width, text_image->height, buffer);

  char*outText = api->GetUTF8Text();
  printf("%s\n");

  api->End();


/*
  ETEXT_DESC* output = api.Recognize_all_Words();

  for (int i = 0; i < output->count; ++i) 
  {
    const EANYCODE_CHAR* ch = &output->text[i];
    for (int b = 0; b < ch->blanks; ++b)
    {
      text[text_loc] = ' ';
      text_loc++;
    }

    text[text_loc] = (char)ch->char_code;
    text_loc++;
    if (ch->formatting & 64)
    {
      text[text_loc] = '\n';
      text_loc++;
    } 
    if (ch->formatting & 128)
    {
      text[text_loc] = '\n';
      text_loc++;
    }
  }
*/
  text[text_loc] = 0x00;
  free(buffer);
}

int main( int argc, char** argv )
{
    CvSeq* contours;
    CvMemStorage* storage = cvCreateMemStorage(0);
//    char* filename = argc == 2 ? argv[1] : (char*)"C:\\Robots\\Code\\OpenCV\\SerialNumberFinder\\1191Label.bmp";
    char* filename = argc == 2 ? argv[1] : (char*)"G:\\Class\\OpenCV\\SerialNumberFinder\\MazeSign02.bmp";

    img1 = cvLoadImage( filename, 1);
    cvSaveImage("Anoutput.bmp",img1);
    IplImage* img2 = cvCreateImage( cvSize(img1->width,img1->height), 8, 1 );
    IplImage* img3 = cvCreateImage( cvSize(img1->width,img1->height), 8, 1 );
    IplImage* img = cvCreateImage( cvSize(img1->width,img1->height), 8, 1 );
    cvCvtColor(img1,img,CV_RGB2GRAY);
    cvThreshold(img,img2,250,255,CV_THRESH_BINARY);
    cvZero(img3);
    cvCopy(img2,img3);
    
    cvNamedWindow( "image", 1 );

    cvFindContours( img3, storage, &contours, sizeof(CvContour), CV_RETR_LIST, CV_CHAIN_APPROX_SIMPLE, cvPoint(0,0) );

    int num=0;
    while( contours )
    {
      char text[200];
#if 1
      if((contours->total == 4)&&(fabs(cvContourArea(contours,CV_WHOLE_SEQ)) > 1000))
      {
        IplImage* img4;
        CvPoint2D32f center;
        
        CvPoint* p0 = (CvPoint*)cvGetSeqElem( contours, 0 );
        CvPoint* p2 = (CvPoint*)cvGetSeqElem( contours, 2 );
        CvPoint  pt0,pt1;
        int      height,width;
      
        pt0.x = p0->x;
        pt0.y = p0->y; 
        pt1.x = p2->x;
        pt1.y = p2->y;
        
        width  = abs(pt0.x - pt1.x);
        height = abs(pt0.y - pt1.y);
        width   = width/8;
        width   = width*8;
        height  = height/8;
        height  = height*8;
        
        img4 = cvCreateImage( cvSize(width,height), 8, 1);

        center.x = (pt0.x+pt1.x)/2.0f;
        center.y = (pt0.y+pt1.y)/2.0f;
        cvGetRectSubPix(img2, img4, center);

        ConvertToText(img4, text);
        FILE* fp = fopen("test_out.txt","a");
        if(fp != NULL)
        {
          fseek(fp,0,SEEK_END);
          fprintf(fp,text);
          fprintf(fp,"\n\n");
          fclose(fp);
        }
        
        cvShowImage( "image", img4 );
        cvWaitKey(0);
        cvReleaseImage( &img4 );
      }
#endif      
      // take the next contour
      contours = contours->h_next;
    }                    

    cvShowImage( "image", img2 );
    cvWaitKey(0);
/*
    cvShowImage( "image", img2 );
    cvWaitKey(0);

    cvShowImage( "image", img );
    cvWaitKey(0);
*/

    // comment this out if you do not want approximation
//    on_trackbar(0);
    cvReleaseMemStorage( &storage );
    cvReleaseImage( &img3 );
    cvReleaseImage( &img2 );

    return 0;
}

#ifdef _EiC
main(1,"");
#endif
