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

int startX=27;
int startY=27;
int endX=27;
int endY=27;

void switchStartXCallback( int position ) 
{
  startX = position;
}

void switchStartYCallback( int position ) 
{
  startY = position;
}

void switchEndXCallback( int position ) 
{
  endX = position;
}

void switchEndYCallback( int position ) 
{
  endY = position;
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

  cvCreateTrackbar("StartX","Source",&startX,640,switchStartXCallback);
  cvCreateTrackbar("StartY","Source",&startY,480,switchStartYCallback);
  cvCreateTrackbar("EndX","Source",&endX,640,switchEndXCallback);
  cvCreateTrackbar("EndY","Source",&endY,480,switchEndYCallback);

  cvGrabFrame(capture );
  theImageFromTheCamera = cvRetrieveFrame( capture );
  hSVImage       = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 3 );

  while(!kbhit())
  {
    /*
    ** Get a frame from the camera
    */
    cvGrabFrame(capture );
    theImageFromTheCamera = cvRetrieveFrame( capture );

    cvLine(theImageFromTheCamera,cvPoint(startX,startY),cvPoint(endX,endY),CV_RGB(255,255,255),3);

    cvShowImage( "Source", theImageFromTheCamera );

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


