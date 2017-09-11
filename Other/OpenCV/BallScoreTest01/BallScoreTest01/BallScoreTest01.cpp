#include "cv.h"
#include "cv.hpp"
#include "highgui.h"
#include <conio.h>
#include <stdio.h>

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

int hueValue=0;
int hueRange=0;

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
  IplImage* theMaskRed;
  IplImage* theMaskBlue;
  IplImage* theMaskGreen;
  IplImage* theMaskYellow;
  IplImage* theRed;
  IplImage* theBlue;
  IplImage* theGreen;
  IplImage* theYellow;
  IplImage* theMask;
  IplImage* theWhiteMask;
  CvMemStorage *storage;
  int header_size, count,length, width;
  CvSeq *contour;
  CvBox2D * myBox;
  CvPoint* PointArray;
  CvPoint2D32f *PointArray32f;
  CvPoint myCenter;
  int MaxCount;
  int MaxWidth;
  int MaxHeight;
  int MaxX=0;
  int MaxY=0;
  int i;

  /*
  ** Init things for the contour finding
  */
  header_size = sizeof(CvContour);
  storage = cvCreateMemStorage (1000); // For FindContours.
  myBox= (CvBox2D *) malloc(sizeof(CvBox2D));


  /*
  ** Start up the camera and open a window for output.
  */
  capture = cvCaptureFromCAM(0);
  cvNamedWindow( "Source", 1 );
//  cvNamedWindow( "Mask", 1 );

//  cvNamedWindow( "Hue", 1 );
//  cvNamedWindow( "Lum", 1 );
//  cvNamedWindow( "WhiteMask", 1 );

//  cvNamedWindow( "Working1", 1 );
//  cvNamedWindow( "Working2", 1 );
//  cvNamedWindow( "Working3", 1 );

  cvNamedWindow( "Red", 1 );
  cvNamedWindow( "Blue", 1 );
  cvNamedWindow( "Green", 1 );
  cvNamedWindow( "Yellow", 1 );

  cvCreateTrackbar("hueValue","Source",&hueValue,255,switchValueCallback);
  cvCreateTrackbar("hueRange","Source",&hueRange,255,switchRangeCallback);

  cvGrabFrame(capture );
  theImageFromTheCamera = cvRetrieveFrame( capture );
  hSVImage       = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 3 );
  theSature      = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theLum         = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theHue         = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theWorkingMask1= cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theWorkingMask2= cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theWorkingMask3= cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theMaskRed     = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theMaskBlue    = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theMaskGreen   = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theMaskYellow  = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theBlue        = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theRed         = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theGreen       = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
  theYellow      = cvCreateImage( cvSize(theImageFromTheCamera->width,theImageFromTheCamera->height), 8, 1 );
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
    cvSplit( hSVImage, theHue, theLum, theSature, NULL);
//White
    getMaskInv(190, 30, theLum, theWhiteMask);
//Red
    getMask(176, 4, theHue, theMask);
    cvErode(theMask,theRed,0,2);
//    RemoveNoise( theRed);

//Green
    getMask(64, 3, theHue, theMask);
    cvErode(theMask,theGreen,0,2);
//    RemoveNoise( theGreen);

//Yellow
    getMask(23, 3, theHue, theMask);
    cvErode(theMask,theYellow,0,2);
//    RemoveNoise( theYellow);

//Blue
    getMask(117, 6, theHue, theMaskBlue);
    cvErode(theMaskBlue,theMask,0,2);
//    RemoveNoise( theMask);
    cvNot(theWhiteMask,theWorkingMask3);
    cvAnd(theMask, theWorkingMask3, theBlue);

    cvCopy(theRed,theWorkingMask1);
    cvFindContours (theWorkingMask1, storage, &contour,  header_size, CV_RETR_LIST, CV_CHAIN_APPROX_SIMPLE);
//    cvFindContours (theWorkingMask1, storage, &contour,  header_size, CV_RETR_LIST, CV_CHAIN_APPROX_NONE);
//    cvFindContours (theWorkingMask1, storage, &contour,  header_size, CV_RETR_LIST, CV_LINK_RUNS );
//    cvFindContours (theWorkingMask1, storage, &contour,  header_size, CV_RETR_LIST, CV_CHAIN_CODE);
    
    MaxHeight = theBlue->height;
  	MaxWidth  = theBlue->width;

    int mycount=1;
    while(contour!=NULL)
    {
      if(CV_IS_SEQ_CURVE(contour))
      {
        // HOW MANY POITS HAS THE CONTOUR ??
        count = contour->total;

        //ALLOC MEM
        PointArray = (CvPoint *)malloc(count * sizeof(CvPoint));

        //COPY THE POINTS TO A ARRAY
        cvCvtSeqToArray(contour, PointArray, CV_WHOLE_SEQ);

        // ALLOC MEM
        PointArray32f = (CvPoint2D32f *)
        malloc((count + 1) * sizeof(CvPoint2D32f));

        //CONVERT THE ARRAY TO A 2ND (32FLOAT)
        // THIS WE NEED FOR cvFitELLIPSE

        MaxCount = 0;

        for (i=0; i<count-1; i++)
        {                              
          PointArray32f[i].x = (float)(PointArray[i].x);
          PointArray32f[i].y = (float)(PointArray[i].y);
        }
        PointArray32f[i].x = (float)(PointArray[0].x);
        PointArray32f[i].y = (float)(PointArray[0].y);        

        if (count>=40)
        {
          //FIND THE BEST FITTING ELLIPSE INTHIS CONTOUR
          cvFitEllipse(PointArray32f, count,myBox);

          //ECTRACT THE RESULTS FROM "myBox"
          //CENTER
          myCenter.x = (int) myBox->center.x;
          myCenter.y = (int) myBox->center.y;

          //HEIGHT AND WITH (THE 2 AXES OF THE ELLIPSE)
          length  =(int)myBox->size.height;
          width = (int)myBox->size.width;

          //AND THE ANGLE
          float myAngle= myBox->angle;

          // IS THE ELLIPSE INSIDE THE IMAGE ??
          if ((myCenter.x > 0) && (myCenter.y >0))
          {      
            //DRAW A CIRCLE
            cvCircle(hSVImage,myCenter,(int)length/2, CV_RGB(0,0,255));
//            cvCircle(theRed,myCenter,(int)length/2, CV_RGB(0,0,255));
            if((int)length > MaxCount)
            {
              MaxCount = (int)length;
              MaxX = myCenter.x;
              MaxY = myCenter.y;
            }
          }
        }

        free(PointArray32f );
        free(PointArray );
        if(MaxCount>2)
        {
          int locx;
          int locy;

          locx = (int)(20.0*((float)MaxX/(float)MaxWidth)-10.0);
          locy = (int)(10.0*((float)MaxY/(float)MaxHeight)-5);
          printf("(%3d,%3d) (%3d,%3d) %5d\n",(int)myCenter.x,(int)myCenter.y,(int)myCenter.x,(int)myCenter.y,MaxCount);
        }
      }

      // GOT TO THE NEXT CONTOUR (IF ANY)
      contour = contour->h_next;
      mycount++;
    }

    cvLine(hSVImage,cvPoint(204,428),cvPoint(533,167),CV_RGB(255,255,255),3);
    cvLine(hSVImage,cvPoint(480,396),cvPoint(329,325),CV_RGB(255,255,255),3);

    cvShowImage( "Source", hSVImage );
//    cvShowImage( "Mask", theMask );

    cvShowImage( "Red",    theRed );
    cvShowImage( "Blue",   theBlue );
    cvShowImage( "Green",  theGreen );
    cvShowImage( "Yellow", theYellow );

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


