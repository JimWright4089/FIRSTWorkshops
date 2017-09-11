#include "cv.h"
#include "highgui.h"
#include "cvcam.h"
#include <math.h>
#include <conio.h>
#include <stdio.h>

void callback(IplImage* image)
{

}


int ShowCamVideo(HWND hwnd, int width, int height)
{
    VidFormat vidFmt={ width, height, 30.0};

    int ncams = cvcamGetCamerasCount( );
    cvcamSetProperty(0, CVCAM_PROP_ENABLE, CVCAMTRUE);
    cvcamSetProperty(0, CVCAM_PROP_CALLBACK,callback);
    cvcamSetProperty(0, CVCAM_PROP_WINDOW, &hwnd);   

    //Set Video Format Property
    cvcamSetProperty( 0, CVCAM_PROP_SETFORMAT, &vidFmt);

    if( !cvcamInit() )
        return 0;
    cvcamStart();
    return 1;
}

int main( int argc, char** argv )
{
    cvNamedWindow("cvcam window", CV_WINDOW_AUTOSIZE);
    if( ShowCamVideo((HWND)cvGetWindowHandle("cvcam window"), 640, 480) )
    {
        cvWaitKey(0);
        cvcamStop();
    }
    cvcamExit();
    return 0;
}
