
#if !defined ROBOT_STRUCT_COMMON
#define ROBOT_STRUCT_COMMON

#include "RobotCommonTypes.h"

#define MOTOR_PACKET 110
#define CAMERA_PACKET 140

#define BEGIN_PACKET  2
#define END_PACKET    3
#define CHANGE_NUM    4
#define CHANGE_AMT   10

struct common_struct
{
  uint8  command;
  sint16 data1;
  sint16 data2;
  sint16 data3;
  sint16 data4;
  sint16 data5;
  sint16 data6;
};
typedef common_struct common;


#endif
