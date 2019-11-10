/**
 * OpenCV video streaming over TCP/IP
 * Client: Receives video from server and display it
 * by Steve Tuenkam
 */

#include "opencv2/opencv.hpp"
#include <winsock2.h>
#include <Ws2tcpip.h>

using namespace cv;


int main(int argc, char** argv)
{
    WSADATA WSAData;
    WSAStartup(MAKEWORD(2, 0), &WSAData);

    //--------------------------------------------------------
    //networking stuff: socket , connect
    //--------------------------------------------------------
    int         sokt;
    char*       serverIP;
    int         serverPort;

    if (argc < 3) {
        std::cerr << "Usage: cv_video_cli <serverIP> <serverPort> " << std::endl;
    }

    serverIP = argv[1];
    serverPort = atoi(argv[2]);

    struct  sockaddr_in serverAddr;
    int           addrLen = sizeof(struct sockaddr_in);

    if ((sokt = socket(PF_INET, SOCK_STREAM, 0)) < 0) {
        std::cerr << "socket() failed" << std::endl;
    }

    serverAddr.sin_family = PF_INET;
//    serverAddr.sin_addr.s_addr = inet_addr(serverIP);
    inet_pton(AF_INET, serverIP, &serverAddr.sin_addr.s_addr);

    serverAddr.sin_port = htons(serverPort);

    if (connect(sokt, (sockaddr*)&serverAddr, addrLen) < 0) {
        std::cerr << "connect() failed!" << std::endl;
    }

    //----------------------------------------------------------
    //OpenCV Code
    //----------------------------------------------------------

    Mat img;
    int i, width = 100, height = 70;
    int flags = 0;
    img = Mat::zeros(height, width, CV_8UC3);
    int bytes = 0;
    int key=0;

    //make img continuos
    if (!img.isContinuous()) {
        img = img.clone();
    }

    namedWindow("CV Video Client",1);

    if ((bytes = recv(sokt, (char*)&(height), sizeof(img.rows), MSG_WAITALL)) == -1) {
        std::cerr << "recv failed, received bytes = " << bytes << std::endl;
    }
    if ((bytes = recv(sokt, (char*)&(width), sizeof(img.cols), MSG_WAITALL)) == -1) {
        std::cerr << "recv failed, received bytes = " << bytes << std::endl;
    }
    img = Mat::zeros(height, width, CV_8UC3);
    //img.flags = flags;
    int imgSize = img.total() * img.elemSize();
    std::cout << "Image Size:" << imgSize << std::endl;
    char *iptr = (char*)img.data;

    while (key != 'q') {

        if ((bytes = recv(sokt, iptr, imgSize, MSG_WAITALL)) == -1) {
            std::cerr << "recv failed, received bytes = " << bytes << std::endl;
        }

        cv::imshow("CV Video Client", img);

        if (key = cv::waitKey(10) >= 0) break;
    }

    closesocket(sokt);

    return 0;
}