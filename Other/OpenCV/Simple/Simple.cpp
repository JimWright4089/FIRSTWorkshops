#include "cv.h"
#include "highgui.h"
#include <math.h>

int main( int argc, char** argv )
{
    char* filename = argc == 2 ? argv[1] : (char*)"C:\\Users\\Jim\\SourceCode\\CPP\\OpenCV\\ConvertImage\\ConvertImage.bmp";

    IplImage* OriginalImage;
    OriginalImage = cvLoadImage( filename, 1);
    cvSaveImage("Anoutput.bmp",OriginalImage);
    cvNamedWindow( "image", 1 );

    cvShowImage( "image", OriginalImage );
    cvWaitKey(0);

    cvReleaseImage( &OriginalImage );
    return 0;
}
