#include "cv.h"
#include "cv.hpp"
#include "highgui.h"
#include <conio.h>
#include <math.h>
#include <stdio.h>

#if 0
int main(int argc, char* argv[])
{
  
    CvCapture *capture = cvCaptureFromCAM(0);


}
#endif

int main( int argc, char** argv ) 
{
    IplImage* TheImageFromTheCamera;
//    IplImage* img = cvLoadImage( argv[1] );
    CvCapture *capture = cvCreateCameraCapture(0);

    cvNamedWindow( "Example1", CV_WINDOW_AUTOSIZE );
  
    IplImage* frame;
    while(1) {
        frame = cvQueryFrame( capture );
        if( !frame ) break;
        cvShowImage( "Example1", frame );
        char c = cvWaitKey(33);
        if( c == 27 ) break;
        printf("In loop\n");
    }
    printf("Out of loop a\n");
    cvReleaseCapture( &capture );
    printf("Out of loop b\n");
    cvDestroyWindow( "Example1" );
    printf("Out of loop c\n");
}

#if 0
int main( int argc, char** argv ) 
{
    IplImage* img = cvLoadImage( argv[1] );
    cvNamedWindow( "Example1", CV_WINDOW_AUTOSIZE );
    cvShowImage( "Example1", img );
    cvWaitKey(0);
//    cvReleaseImage( &img );
    cvDestroyWindow( "Example1" );
}
#endif