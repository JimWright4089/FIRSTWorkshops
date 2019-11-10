#include "opencv2/core.hpp"
#include "opencv2/imgproc.hpp"
#include "opencv2/highgui.hpp"
#include <iostream>
#include <winsock2.h>
#include <Ws2tcpip.h>
#include <string.h>

using namespace cv;

static Scalar randomColor(RNG& rng)
{
    int icolor = (unsigned)rng;
    return Scalar(icolor & 255, (icolor >> 8) & 255, (icolor >> 16) & 255);
}

int main()
{
    WSADATA WSAData;
    WSAStartup(MAKEWORD(2, 0), &WSAData);

    char wndname[] = "Drawing Demo";
    const int NUMBER = 100;
    const int DELAY = 5;
    int lineType = LINE_AA; // change it to LINE_8 to see non-antialiased graphics
    int i, width = 640, height = 480;
    int x1 = -width / 2, x2 = width * 3 / 2, y1 = -height / 2, y2 = height * 3 / 2;
    RNG rng(0x0);
    int things = CV_8UC3;


//    Mat image = Mat::zeros(height, width, CV_8UC3);
    Mat image = Mat::zeros(height, width, CV_8UC3);
    imshow(wndname, image);
    waitKey(DELAY);
    #define DEFAULT_PORT "4242"

    SOCKET ListenSocket = INVALID_SOCKET;
    SOCKET ClientSocket = INVALID_SOCKET;

    struct addrinfo *result = NULL;
    struct addrinfo hints;
    int iResult;

    ZeroMemory(&hints, sizeof(hints));
    hints.ai_family = AF_INET;
    hints.ai_socktype = SOCK_STREAM;
    hints.ai_protocol = IPPROTO_TCP;
    hints.ai_flags = AI_PASSIVE;

    // Resolve the server address and port
    iResult = getaddrinfo(NULL, DEFAULT_PORT, &hints, &result);
    if (iResult != 0) {
        printf("getaddrinfo failed with error: %d\n", iResult);
        WSACleanup();
        return 1;
    }

    // Create a SOCKET for connecting to server
    ListenSocket = socket(result->ai_family, result->ai_socktype, result->ai_protocol);
    if (ListenSocket == INVALID_SOCKET) {
        printf("socket failed with error: %ld\n", WSAGetLastError());
        freeaddrinfo(result);
        WSACleanup();
        return 1;
    }

    // Setup the TCP listening socket
    iResult = bind(ListenSocket, result->ai_addr, (int)result->ai_addrlen);
    if (iResult == SOCKET_ERROR) {
        printf("bind failed with error: %d\n", WSAGetLastError());
        freeaddrinfo(result);
        closesocket(ListenSocket);
        WSACleanup();
        return 1;
    }

    freeaddrinfo(result);

    iResult = listen(ListenSocket, SOMAXCONN);
    if (iResult == SOCKET_ERROR) {
        printf("listen failed with error: %d\n", WSAGetLastError());
        closesocket(ListenSocket);
        WSACleanup();
        return 1;
    }

    while (true)
    {
        std::cerr << "start" << std::endl;

        // Accept a client socket
        ClientSocket = accept(ListenSocket, NULL, NULL);
        if (ClientSocket == INVALID_SOCKET) {
            printf("accept failed with error: %d\n", WSAGetLastError());
            closesocket(ListenSocket);
            WSACleanup();
            return 1;
        }
        else
        {
            int bytes=0;
            int imgSize = sizeof(image.rows);
            if ((bytes = send(ClientSocket, (char*)&image.rows, imgSize, 0)) < 0) {
                std::cerr << "bytes = " << bytes << std::endl;
                break;
            }
            imgSize = sizeof(image.cols);
            if ((bytes = send(ClientSocket, (char*)&image.cols, imgSize, 0)) < 0) {
                std::cerr << "bytes = " << bytes << std::endl;
                break;
            }

            while (true)
            {
                bool exitIt= false;
                for (i = 0; i < NUMBER * 2; i++)
                {
                    Point pt1, pt2;
                    pt1.x = rng.uniform(x1, x2);
                    pt1.y = rng.uniform(y1, y2);
                    pt2.x = rng.uniform(x1, x2);
                    pt2.y = rng.uniform(y1, y2);

                    int arrowed = rng.uniform(0, 6);

                    if (arrowed < 3)
                        line(image, pt1, pt2, randomColor(rng), rng.uniform(1, 10), lineType);
                    else
                        arrowedLine(image, pt1, pt2, randomColor(rng), rng.uniform(1, 10), lineType);

                    imshow(wndname, image);

                    //send processed image
                    int bytes;
                    int imgSize = image.total() * image.elemSize();
                    if ((bytes = send(ClientSocket, (char*)image.data, imgSize, 0)) < 0) {
                        std::cerr << "bytes = " << bytes << std::endl;
                        exitIt = true;
                        break;
                    }

                    if (waitKey(DELAY) >= 0)
                        return 0;
                }
                if (true == exitIt)
                {
                    break;
                }
            }
        }
    }

    waitKey();
    return 0;
}
