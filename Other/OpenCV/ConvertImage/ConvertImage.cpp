#include "cv.h"
#include "highgui.h"
#include <math.h>

//#define COMP_OR
#define COMP_AND
//#define COMP_XOR
//#define COMP_ADD
//#define COMP_SUB
//#define COMP_MUL
//#define COMP_DIV


int main( int argc, char** argv )
{
    char* filename = argc == 2 ? argv[1] : (char*)"C:\\Users\\Jim\\SourceCode\\CPP\\OpenCV\\ConvertImage\\ConvertImage.bmp";

    IplImage* OriginalImage;
    OriginalImage = cvLoadImage( filename, 1);
    cvSaveImage("Anoutput.bmp",OriginalImage);
    IplImage* YellowImage = cvCreateImage( cvSize(OriginalImage->width,OriginalImage->height), 8, 1 );
    IplImage* VioletImage = cvCreateImage( cvSize(OriginalImage->width,OriginalImage->height), 8, 1 );
    IplImage* CyanImage   = cvCreateImage( cvSize(OriginalImage->width,OriginalImage->height), 8, 1 );
    IplImage* RedImage    = cvCreateImage( cvSize(OriginalImage->width,OriginalImage->height), 8, 1 );
    IplImage* GreenImage  = cvCreateImage( cvSize(OriginalImage->width,OriginalImage->height), 8, 1 );
    IplImage* BlueImage   = cvCreateImage( cvSize(OriginalImage->width,OriginalImage->height), 8, 1 );
    cvNamedWindow( "image", 1 );

    cvSplit(OriginalImage, YellowImage, VioletImage, CyanImage, NULL);

#ifdef COMP_OR
    cvOr(YellowImage, VioletImage, RedImage);
    cvOr(YellowImage, CyanImage,   GreenImage);
    cvOr(CyanImage,   VioletImage, BlueImage);
#endif

#ifdef COMP_AND
    cvAnd(YellowImage, VioletImage, RedImage);
    cvAnd(YellowImage, CyanImage,   GreenImage);
    cvAnd(CyanImage,   VioletImage, BlueImage);
#endif

#ifdef COMP_XOR
    cvXor(YellowImage, VioletImage, RedImage);
    cvXor(YellowImage, CyanImage,   GreenImage);
    cvXor(CyanImage,   VioletImage, BlueImage);
#endif

#ifdef COMP_ADD
    cvAdd(YellowImage, VioletImage, RedImage);
    cvAdd(YellowImage, CyanImage,   GreenImage);
    cvAdd(CyanImage,   VioletImage, BlueImage);
#endif

#ifdef COMP_SUB
    cvSub(YellowImage, VioletImage, RedImage);
    cvSub(YellowImage, CyanImage,   GreenImage);
    cvSub(CyanImage,   VioletImage, BlueImage);
#endif

#ifdef COMP_MUL
    cvMul(YellowImage, VioletImage, RedImage);
    cvMul(YellowImage, CyanImage,   GreenImage);
    cvMul(CyanImage,   VioletImage, BlueImage);
#endif

#ifdef COMP_DIV
    cvDiv(YellowImage, VioletImage, RedImage);
    cvDiv(YellowImage, CyanImage,   GreenImage);
    cvDiv(CyanImage,   VioletImage, BlueImage);
#endif

    cvShowImage( "image", OriginalImage );
    cvWaitKey(0);

    cvShowImage( "image", YellowImage );
    cvWaitKey(0);

    cvShowImage( "image", VioletImage );
    cvWaitKey(0);

    cvShowImage( "image", CyanImage );
    cvWaitKey(0);
    
    cvShowImage( "image", RedImage );
    cvWaitKey(0);
    
    cvShowImage( "image", GreenImage );
    cvWaitKey(0);
    
    cvShowImage( "image", BlueImage );
    cvWaitKey(0);
    
    cvReleaseImage( &OriginalImage );
    cvReleaseImage( &YellowImage );
    cvReleaseImage( &VioletImage );
    cvReleaseImage( &CyanImage );
    cvReleaseImage( &RedImage );
    cvReleaseImage( &GreenImage );
    cvReleaseImage( &BlueImage );

    return 0;
}
