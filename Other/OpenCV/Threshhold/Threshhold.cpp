#pragma package <opencv>

#include "cv.h"
#include "highgui.h"
#include <math.h>

#define COMP_OR
//#define COMP_AND
//#define COMP_XOR
//#define COMP_ADD
//#define COMP_SUB
//#define COMP_MUL
//#define COMP_DIV


int main( int argc, char** argv )
{
    char* filename = (char*)"C:\\Users\\Jim\\SourceCode\\CPP\\OpenCV\\Threshhold\\GreenBitmap.bmp";
    char* filename2 = (char*)"C:\\Users\\Jim\\SourceCode\\CPP\\OpenCV\\Threshhold\\SRSMask.bmp";

    IplImage* OriginalImage;
    OriginalImage = cvLoadImage( filename, 1);
    cvSaveImage("Anoutput.bmp",OriginalImage);
    IplImage* GreyImage   = cvCreateImage( cvSize(OriginalImage->width,OriginalImage->height), 8, 1 );
    IplImage* ThreshImage = cvCreateImage( cvSize(OriginalImage->width,OriginalImage->height), 8, 1 );
    IplImage* NewImage    = cvCreateImage( cvSize(OriginalImage->width,OriginalImage->height), 8, 3 );
    IplImage* MaskImage   = cvLoadImage( filename2, 1);
    IplImage* MaskImage2  = cvCreateImage( cvSize(OriginalImage->width,OriginalImage->height), 8, 1 );
    IplImage* NewImage2   = cvCreateImage( cvSize(OriginalImage->width,OriginalImage->height), 8, 3 );

    cvNamedWindow( "image", 1 );

    cvCvtColor(OriginalImage,GreyImage,CV_RGB2GRAY);
    cvCvtColor(MaskImage,MaskImage2,CV_RGB2GRAY);
    cvThreshold(GreyImage,ThreshImage,50,255,CV_THRESH_BINARY);

    cvSet(NewImage,CV_RGB(255,0,0));
    cvCopy(OriginalImage, NewImage, ThreshImage);

    cvSet(NewImage2,CV_RGB(0,0,255));
    cvCopy(OriginalImage, NewImage2, MaskImage2);

    cvShowImage( "image", OriginalImage );
    cvWaitKey(0);

    cvShowImage( "image", GreyImage );
    cvWaitKey(0);

    cvShowImage( "image", ThreshImage );
    cvWaitKey(0);

    cvShowImage( "image", NewImage );
    cvWaitKey(0);

    cvShowImage( "image", MaskImage );
    cvWaitKey(0);

    cvShowImage( "image", NewImage2 );
    cvWaitKey(0);

    cvReleaseImage( &OriginalImage );
    cvReleaseImage( &GreyImage );
    cvReleaseImage( &ThreshImage );

    return 0;
}
