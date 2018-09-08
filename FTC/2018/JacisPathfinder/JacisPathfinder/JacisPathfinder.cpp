//----------------------------------------------------------------------------
//
//  $Workfile: JacisPathfinder.cpp$
//
//  $Revision: X$
//
//  Project:    JacisPathfinders
//
//                            Copyright (c) 2018
//                               Cedarcrest High School
//                            All Rights Reserved
//
//  Modification History:
//  $Log:
//  $
//
//----------------------------------------------------------------------------
#include "pathfinder.h"
#include <stdio.h>
#include <string.h>
#include <sstream>
#include <string>
#include <fstream>
#include <iostream>
#include <vector>

using namespace std;

//----------------------------------------------------------------------------
//  Defines
//----------------------------------------------------------------------------
#define MAX_LINE 200

//----------------------------------------------------------------------------
//  Constants
//----------------------------------------------------------------------------
const double TIME_SLICE =    0.02;
const double MAX_VEL    =   6.0;
const double MAX_ACCEL  =  10.0;
const double MAX_JERK   = 100.0;
const double WHEEL_BASE_WIDTH = 8;

//----------------------------------------------------------------------------
//  Local Functions
//----------------------------------------------------------------------------
void createPaths(vector<string> fields);

std::ifstream csvFile("paths.csv");

//----------------------------------------------------------------------------
//  Purpose:
//      Main, read things in put things out
//
//  Notes:
//      None
//
//----------------------------------------------------------------------------
int main()
{
  std::string line;
  std::getline(csvFile, line);
  while (std::getline(csvFile, line))
  {
    if (line.length() > 0)
    {
      cout << "[" << line << "]" << endl;
      std::istringstream iss(line);
      std::string delimiter = ",";
      size_t pos = 0;
      vector<string> lineParts;

      while ((pos = line.find(delimiter)) != std::string::npos)
      {
        std::string token = line.substr(0, pos);
        lineParts.push_back(token);
        line.erase(0, pos + delimiter.length());
      }
      lineParts.push_back(line);

      createPaths(lineParts);
    }
  }
  return 0;
}


//----------------------------------------------------------------------------
//  Purpose:
//      Make the path file
//
//  Notes:
//      None
//
//----------------------------------------------------------------------------
void createPaths(vector<string> fields)
{
  string classname = fields[0] + "Path" + to_string((int)MAX_VEL) + "InPerSec";
  string filename = classname + ".java";

  ofstream outputFile;
  outputFile.open(filename,ofstream::trunc);

  int pointLength =  stoi(fields[2]);

  Waypoint *points = (Waypoint*)malloc(sizeof(Waypoint) * pointLength);

  for (int i = 0; i < pointLength; i++)
  {
    points[i].x = stof(fields[3 + (i * 3)]);
    points[i].y = stof(fields[3 + (i * 3)+1]);
    points[i].angle = d2r(stof(fields[3 + (i * 3)+2]));
  }

  TrajectoryCandidate candidate;
  pathfinder_prepare(points, 
    pointLength, 
    FIT_HERMITE_CUBIC, 
    PATHFINDER_SAMPLES_HIGH, 
    TIME_SLICE,
    MAX_VEL,
    MAX_ACCEL,
    MAX_JERK,
    &candidate);

  int length = candidate.length;
  Segment *trajectory =(Segment *)malloc(length * sizeof(Segment));

  pathfinder_generate(&candidate, trajectory);

  Segment *leftTrajectory = (Segment*)malloc(sizeof(Segment) * length);
  Segment *rightTrajectory = (Segment*)malloc(sizeof(Segment) * length);

  pathfinder_modify_tank(trajectory, length, 
    leftTrajectory, rightTrajectory, WHEEL_BASE_WIDTH);

  outputFile << "//----------------------------------------------------------------------------" << endl;
  outputFile << "//" << endl;
  outputFile << "//  $Workfile: " + filename << endl;
  outputFile << "//" << endl;
  outputFile << "//  $Revision: X$" << endl;
  outputFile << "//" << endl;
  outputFile << "//  Project:    Paths" << endl;
  outputFile << "//" << endl;
  outputFile << "//                            Copyright (c) 2018" << endl;
  outputFile << "//                               Cedarcrest High School" << endl;
  outputFile << "//                            All Rights Reserved\n" << endl;
  outputFile << "//" << endl;
  outputFile << "//  Modification History:" << endl;
  outputFile << "//  $Log:" << endl;
  outputFile << "//  $" << endl;
  outputFile << "//" << endl;
  outputFile << "//----------------------------------------------------------------------------" << endl;
  outputFile << "//" << endl;
  outputFile << "//" << endl;
  outputFile << "//----------------------------------------------------------------------------" << endl;
  outputFile << "//    Parameters Used" << endl;
  outputFile << "//----------------------------------------------------------------------------" << endl;
  outputFile << "//   Time Slice= " << to_string(TIME_SLICE) << endl;
  outputFile << "//   Max Vel   = " << to_string(MAX_VEL) << endl;
  outputFile << "//   Max Accel = " << to_string(MAX_ACCEL) << endl;
  outputFile << "//   Max Jerk  =  " << to_string(MAX_JERK) << endl;

  outputFile << "package org.usfirst.frc4089.Stealth2018.MPPaths;" << endl;
  outputFile << endl;
  outputFile << "public class " << classname << " extends Path {" << endl;
  outputFile << "    public " << classname << "() {"<<endl;
  outputFile << "       kSpeed = " << to_string(MAX_VEL/10.0) << ";" << endl;
  outputFile << "       kNumPoints = " << to_string(length) << ";" << endl;
  outputFile << "       kPoints = new double[][]{" << endl;

  for (int i = 0; i < length; i++)
  {
    outputFile << "  {" <<
      to_string(leftTrajectory[i].velocity) << ", " <<
      to_string(rightTrajectory[i].velocity) << ", "  <<
      to_string(r2d(leftTrajectory[i].heading)) << ", " <<
      to_string(leftTrajectory[i].x) << ", " <<
      to_string(leftTrajectory[i].y) << ", " <<
      to_string(rightTrajectory[i].x) << ", " <<
      to_string(rightTrajectory[i].y) << "}";

    if (i + 1 == length)
    {
      outputFile << "};" << endl;
    }
    else
    {
      outputFile << "," << endl;
    }
  }
  outputFile << "}}" << endl;

  outputFile.close();
  free(trajectory);
}
