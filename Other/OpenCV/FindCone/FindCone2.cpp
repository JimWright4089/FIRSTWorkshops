/*
** Find the Cone
**
** Finds an orange cone in a picture, well ok it does not need to be a cone
** but in needs to be orange.
**
** Copyright 2004 Jim Wright, Jim Culbertson
*/

#include "stdafx.h"
#include "cv.h"
#include "cv.hpp"
#include "highgui.h"
#include <conio.h>
#include <math.h>
#include <stdio.h>
#include <windows.h>
#include <assert.h>
#include <commctrl.h>
#include <stdlib.h>
#include <process.h>
#include <stddef.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>
#include <time.h>
#include "BackPlane.h"
#include "..\Common\RobotCommonStruct.h"

typedef void (*SETCOMMON)(common our_common);

#define DEBUGROBOT 1

const int MINWIDTH         =  20;
const int MINLENGTH        =  20;
const int PICMOVELEFT      = 110;
const int PICMOVESMALLLEFT = 100;
const int PICCENTER        =  80;
const int PICMOVESMALLRIGHT = 70;

/*
**  The Saturation value, just change the min value
*/
const int MINS             = 128;
const int MAXS             = 255;

/*
** The V values are from the Cam Shift Demo twiddleing.
*/
const int MINV             = 128;
const int MAXV             = 255;


#define uchar unsigned char

#define START_BYTE  0x02
#define END_BYTE    0x03
#define CONV_BYTE   0x04
#define CONV_AMOUNT 0x10
#define STRINGPAD           2
#define MAXPORTSIZE        10
#define GOOD                0
#define FAIL               -1

void RemoveNoise(IplImage * src)
{

  //get the size of input_image (src)
  CvSize size = cvSize( src->width & -2, src->height & -2 ); 

  //create  temp-image
  IplImage* pyr = cvCreateImage( cvSize(size.width/2, size.height/2), 
  src->depth, src->nChannels ); 

  cvPyrDown( src, pyr, CV_GAUSSIAN_5x5 );			//pyr DOWN
  cvPyrUp( pyr, src, CV_GAUSSIAN_5x5 );				//and UP
  cvReleaseImage(&pyr);               //release temp
}

int main(int argc, char* argv[])
{
  HINSTANCE hinstLib; 
  SETCOMMON  psetCommon;
  common camera_common;

  CBackPlane myTracker;
  IplImage *TheImageFromTheCamera;
  IplImage *TheBackImageForDebugging;
  CRect window;
  bool rc;
  int i;
  CvMemStorage *storage;
  int header_size, count,length, width;
  CvSeq *contour;
  CvBox2D * myBox;
  CvPoint *PointArray;
  CvPoint2D32f *PointArray32f;
  CvPoint myCenter;
  int loopcount=0;
  int MaxWidth;
  int MaxHeight;
  int MaxX=0;
  int MaxY=0;
  int MaxCount;

  /*
  ** Set up shared DLL
  */
  hinstLib = LoadLibrary("SharedDLLTest.DLL");  

  if(NULL == hinstLib)
  {
    printf("Can't find shared Camera Library\n");
    return -1;
  }
  
  psetCommon = (SETCOMMON)GetProcAddress(hinstLib,"setCommon");
  
  if(NULL == psetCommon)
  {
    printf("Can't find get common in the shared camera library\n");
    return -1;
  }


  /*
  ** Init things for the contour finding
  */
  header_size = sizeof(CvContour);
  storage = cvCreateMemStorage (1000); // For FindContours.
  myBox= (CvBox2D *) malloc(sizeof(CvBox2D));


  /*
  ** Load the image that we want to generate our histogram from
  */
  IplImage *SolidOrange = cvLoadImage("Orange.bmp");   // <-- CHANGE IT TO YOUR NEEDS
  if (!SolidOrange) 
  {
    printf("NO INPUT IMAGE !\n");
    return 0;
  }

  /*
  ** Start up the camera and open a window for output.
  */
  CvCapture *capture = cvCaptureFromCAM(0);
  cvNamedWindow( "Source", 1 );

  /*
  ** Set the bounding box, since we are using an Orange Bitmap then it can be very small
  */
  window.top    = 0;
  window.left   = 0;
  window.bottom = SolidOrange->height;
  window.right  = SolidOrange->width;

  /*
  ** Not sure why 20 bins why not.  For these values run the CamShiftDemo and twiddle with those
  ** controls to get an idea of what to do
  */
  int dims[] = { 20 };
  myTracker.set_hist_dims( 1, dims );
  myTracker.set_hist_bin_range( 0, 0, 255 );
  myTracker.set_threshold( 0 );

  /*
  **  The Saturation value, just change the min value
  */
  myTracker.set_min_ch_val( 1, MINS );   // S MIN
  myTracker.set_max_ch_val( 1, MAXS );  // S MAX

  /*
  ** The V values are from the Cam Shift Demo twiddleing.
  */
  myTracker.set_min_ch_val( 2, MINV );   // V MIN
  myTracker.set_max_ch_val( 2, MAXV );  // V MAX

  /*
  ** Clear out any junk in the histogram to load in our values
  */
  myTracker.reset_histogram();

  /*
  ** Draw a box on the image.  This is important!  You just can't se the Window.
  ** Set the window and get a histogram.
  */
//  cvRectangle(SolidOrange, cvPoint(window.left,window.top), cvPoint(window.right,window.bottom), 0xffffff, 1);
  rc = myTracker.set_window(RectToCvRect( window ));
//  rc = myTracker.update_histogram( static_cast<CvImage *>(SolidOrange) );

  if(0 == rc)
  {
    printf("Problems in setting up the histogram!\n");
    return(0);
  }

  /*
  ** On the production robot use the while 1, when debugging use the kbhit to get out.
  */
//  while(1)
  while(!kbhit())
  {
    /*
    ** Get a frame from the camera
    */
    cvGrabFrame(capture );
    TheImageFromTheCamera = cvRetrieveFrame( capture );
 
    MaxHeight = TheImageFromTheCamera->height;
	MaxWidth  = TheImageFromTheCamera->width;

    /*
    ** The moment we all came here for....
    */
    TheBackImageForDebugging = myTracker.get_back_project(TheImageFromTheCamera);

    RemoveNoise(TheBackImageForDebugging);

    cvFindContours (TheBackImageForDebugging, storage, &contour,  header_size, CV_RETR_LIST,  CV_CHAIN_APPROX_SIMPLE);

    int mycount=1;
    while(contour!=NULL)
    {
      if(CV_IS_SEQ_CURVE(contour))
      {
        // HOW MANY POITS HAS THE CONTOUR ??
        count = contour ->total;

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

        if (count>=10)
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
//            cvCircle(TheImageFromTheCamera,myCenter,(int)length/2 ,RGB(0,255,255));
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
		  printf("(%3d,%3d) %5d\n",locx,locy,MaxCount);

          memset(&camera_common,0,13);

		  camera_common.command = CAMERA_PACKET;
		  camera_common.data1   = locx;
		  camera_common.data2   = locy;
		  camera_common.data3   = MaxCount;

          uint8* ptr;

		  ptr = (uint8*) &camera_common;

		  ptr[1]  = ptr[2];
		  ptr[2]  = ptr[3];
		  ptr[3]  = ptr[4];
		  ptr[4]  = ptr[5];
		  ptr[5]  = ptr[6];
		  ptr[6]  = ptr[7];
		  ptr[7]  = ptr[8];
		  ptr[8]  = ptr[9];
		  ptr[9]  = ptr[10];
		  ptr[10] = ptr[11];
		  ptr[11] = ptr[12];
		  ptr[12] = ptr[13];

          psetCommon(camera_common);
		}
      }
        
      // GOT TO THE NEXT CONTOUR (IF ANY)
      contour = contour->h_next;
      mycount++;
    }

  //  cvShowImage( "Source", TheBackImageForDebugging );
    cvShowImage( "Source", TheImageFromTheCamera );

    if(loopcount>4)
    {
      cvSaveImage("Back.bmp",TheBackImageForDebugging);
      cvSaveImage("Current.bmp",TheImageFromTheCamera);
      loopcount=0;
    }
    loopcount++;

    /*
    ** Don't clogg the CPU!
    */
    Sleep(25);
  }

  cvReleaseCapture(&capture);

  return 0;
}

