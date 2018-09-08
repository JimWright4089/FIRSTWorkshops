//----------------------------------------------------------------------------
//
//  $Workfile: Move2Path6InPerSec.java
//
//  $Revision: X$
//
//  Project:    Paths
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
//
//
//----------------------------------------------------------------------------
//    Parameters Used
//----------------------------------------------------------------------------
//   Time Slice= 0.020000
//   Max Vel   = 6.000000
//   Max Accel = 10.000000
//   Max Jerk  =  100.000000
package org.usfirst.frc4089.Stealth2018.MPPaths;

public class Move2Path6InPerSec extends Path {
    public Move2Path6InPerSec() {
       kSpeed = 0.600000;
       kNumPoints = 236;
       kPoints = new double[][]{
  {0.040000, 0.040000, 0.000000, 0.000160, 7.000000, 0.000160, -7.000000},
  {0.080000, 0.080000, 0.000000, 0.001760, 7.000000, 0.001760, -7.000000},
  {0.180000, 0.180000, 0.000000, 0.005360, 7.000000, 0.005360, -7.000000},
  {0.320000, 0.320000, 0.000000, 0.011760, 7.000000, 0.011760, -7.000000},
  {0.500000, 0.500000, 0.000000, 0.021760, 7.000000, 0.021760, -7.000000},
  {0.700000, 0.700000, 0.000000, 0.035760, 7.000000, 0.035760, -7.000000},
  {0.900000, 0.900000, 0.000000, 0.053760, 7.000000, 0.053760, -7.000000},
  {1.100000, 1.100000, 0.000000, 0.075760, 7.000000, 0.075760, -7.000000},
  {1.300000, 1.300000, 0.000000, 0.101760, 7.000000, 0.101760, -7.000000},
  {1.500000, 1.500000, 0.000000, 0.131760, 7.000000, 0.131760, -7.000000},
  {1.700000, 1.700000, 0.000000, 0.165760, 7.000000, 0.165760, -7.000000},
  {1.900000, 1.900000, 0.000000, 0.203760, 7.000000, 0.203760, -7.000000},
  {2.100000, 2.100000, 0.000000, 0.245760, 7.000000, 0.245760, -7.000000},
  {2.300000, 2.300000, 0.000000, 0.291760, 7.000000, 0.291760, -7.000000},
  {2.500000, 2.500000, 0.000000, 0.341760, 7.000000, 0.341760, -7.000000},
  {2.700000, 2.700000, 0.000000, 0.395760, 7.000000, 0.395760, -7.000000},
  {2.900000, 2.900000, 0.000000, 0.453760, 7.000000, 0.453760, -7.000000},
  {3.100000, 3.100000, 0.000000, 0.515760, 7.000000, 0.515760, -7.000000},
  {3.300000, 3.300000, 0.000000, 0.581760, 7.000000, 0.581760, -7.000000},
  {3.500000, 3.500000, 0.000000, 0.651760, 7.000000, 0.651760, -7.000000},
  {3.700000, 3.700000, 0.000000, 0.725760, 7.000000, 0.725760, -7.000000},
  {3.900000, 3.900000, 0.000000, 0.803760, 7.000000, 0.803760, -7.000000},
  {4.100000, 4.100000, 0.000000, 0.885760, 7.000000, 0.885760, -7.000000},
  {4.300000, 4.300000, 0.000000, 0.971760, 7.000000, 0.971760, -7.000000},
  {4.500000, 4.500000, 0.000000, 1.061760, 7.000000, 1.061760, -7.000000},
  {4.700000, 4.700000, 0.000000, 1.155760, 7.000000, 1.155760, -7.000000},
  {4.900000, 4.900000, 0.000000, 1.253760, 7.000000, 1.253760, -7.000000},
  {5.100000, 5.100000, 0.000000, 1.355760, 7.000000, 1.355760, -7.000000},
  {5.300000, 5.300000, 0.000000, 1.461760, 7.000000, 1.461760, -7.000000},
  {5.500000, 5.500000, 0.000000, 1.571760, 7.000000, 1.571760, -7.000000},
  {5.680000, 5.680000, 0.000000, 1.685360, 7.000000, 1.685360, -7.000000},
  {5.820000, 5.820000, 0.000000, 1.801760, 7.000000, 1.801760, -7.000000},
  {5.920000, 5.920000, 0.000000, 1.920160, 7.000000, 1.920160, -7.000000},
  {5.980000, 5.980000, 0.000000, 2.039760, 7.000000, 2.039760, -7.000000},
  {6.000000, 6.000000, 0.000000, 2.159760, 7.000000, 2.159760, -7.000000},
  {6.000000, 6.000000, 0.000000, 2.279760, 7.000000, 2.279760, -7.000000},
  {6.000000, 6.000000, 0.000000, 2.399760, 7.000000, 2.399760, -7.000000},
  {6.000000, 6.000000, 0.000000, 2.519760, 7.000000, 2.519760, -7.000000},
  {6.000000, 6.000000, 0.000000, 2.639760, 7.000000, 2.639760, -7.000000},
  {6.000000, 6.000000, 0.000000, 2.759760, 7.000000, 2.759760, -7.000000},
  {6.000000, 6.000000, 0.000000, 2.879760, 7.000000, 2.879760, -7.000000},
  {6.000000, 6.000000, 0.000000, 2.999760, 7.000000, 2.999760, -7.000000},
  {6.000000, 6.000000, 0.000000, 3.119760, 7.000000, 3.119760, -7.000000},
  {6.000000, 6.000000, 0.000000, 3.239760, 7.000000, 3.239760, -7.000000},
  {6.000000, 6.000000, 0.000000, 3.359760, 7.000000, 3.359760, -7.000000},
  {6.000000, 6.000000, 0.000000, 3.479760, 7.000000, 3.479760, -7.000000},
  {6.000000, 6.000000, 0.000000, 3.599760, 7.000000, 3.599760, -7.000000},
  {6.000000, 6.000000, 0.000000, 3.719760, 7.000000, 3.719760, -7.000000},
  {6.000000, 6.000000, 0.000000, 3.839760, 7.000000, 3.839760, -7.000000},
  {6.000000, 6.000000, 0.000000, 3.959760, 7.000000, 3.959760, -7.000000},
  {6.000000, 6.000000, 0.000000, 4.079760, 7.000000, 4.079760, -7.000000},
  {6.000000, 6.000000, 0.000000, 4.199760, 7.000000, 4.199760, -7.000000},
  {6.000000, 6.000000, 0.000000, 4.319760, 7.000000, 4.319760, -7.000000},
  {6.000000, 6.000000, 0.000000, 4.439760, 7.000000, 4.439760, -7.000000},
  {6.000000, 6.000000, 0.000000, 4.559760, 7.000000, 4.559760, -7.000000},
  {6.000000, 6.000000, 0.000000, 4.679760, 7.000000, 4.679760, -7.000000},
  {6.000000, 6.000000, 0.000000, 4.799760, 7.000000, 4.799760, -7.000000},
  {6.000000, 6.000000, 0.000000, 4.919760, 7.000000, 4.919760, -7.000000},
  {6.000000, 6.000000, 0.000000, 5.039760, 7.000000, 5.039760, -7.000000},
  {6.000000, 6.000000, 0.000000, 5.159760, 7.000000, 5.159760, -7.000000},
  {6.000000, 6.000000, 0.000000, 5.279760, 7.000000, 5.279760, -7.000000},
  {6.000000, 6.000000, 0.000000, 5.399760, 7.000000, 5.399760, -7.000000},
  {6.000000, 6.000000, 0.000000, 5.519760, 7.000000, 5.519760, -7.000000},
  {6.000000, 6.000000, 0.000000, 5.639760, 7.000000, 5.639760, -7.000000},
  {6.000000, 6.000000, 0.000000, 5.759760, 7.000000, 5.759760, -7.000000},
  {6.000000, 6.000000, 0.000000, 5.879760, 7.000000, 5.879760, -7.000000},
  {6.000000, 6.000000, 0.000000, 5.999760, 7.000000, 5.999760, -7.000000},
  {6.000000, 6.000000, 0.000000, 6.119760, 7.000000, 6.119760, -7.000000},
  {6.000000, 6.000000, 0.000000, 6.239760, 7.000000, 6.239760, -7.000000},
  {6.000000, 6.000000, 0.000000, 6.359760, 7.000000, 6.359760, -7.000000},
  {6.000000, 6.000000, 0.000000, 6.479760, 7.000000, 6.479760, -7.000000},
  {6.000000, 6.000000, 0.000000, 6.599760, 7.000000, 6.599760, -7.000000},
  {6.000000, 6.000000, 0.000000, 6.719760, 7.000000, 6.719760, -7.000000},
  {6.000000, 6.000000, 0.000000, 6.839760, 7.000000, 6.839760, -7.000000},
  {6.000000, 6.000000, 0.000000, 6.959760, 7.000000, 6.959760, -7.000000},
  {6.000000, 6.000000, 0.000000, 7.079760, 7.000000, 7.079760, -7.000000},
  {6.000000, 6.000000, 0.000000, 7.199760, 7.000000, 7.199760, -7.000000},
  {6.000000, 6.000000, 0.000000, 7.319760, 7.000000, 7.319760, -7.000000},
  {6.000000, 6.000000, 0.000000, 7.439760, 7.000000, 7.439760, -7.000000},
  {6.000000, 6.000000, 0.000000, 7.559760, 7.000000, 7.559760, -7.000000},
  {6.000000, 6.000000, 0.000000, 7.679760, 7.000000, 7.679760, -7.000000},
  {6.000000, 6.000000, 0.000000, 7.799760, 7.000000, 7.799760, -7.000000},
  {6.000000, 6.000000, 0.000000, 7.919760, 7.000000, 7.919760, -7.000000},
  {6.000000, 6.000000, 0.000000, 8.039760, 7.000000, 8.039760, -7.000000},
  {6.000000, 6.000000, 0.000000, 8.159760, 7.000000, 8.159760, -7.000000},
  {6.000000, 6.000000, 0.000000, 8.279760, 7.000000, 8.279760, -7.000000},
  {6.000000, 6.000000, 0.000000, 8.399760, 7.000000, 8.399760, -7.000000},
  {6.000000, 6.000000, 0.000000, 8.519760, 7.000000, 8.519760, -7.000000},
  {6.000000, 6.000000, 0.000000, 8.639760, 7.000000, 8.639760, -7.000000},
  {6.000000, 6.000000, 0.000000, 8.759760, 7.000000, 8.759760, -7.000000},
  {6.000000, 6.000000, 0.000000, 8.879760, 7.000000, 8.879760, -7.000000},
  {6.000000, 6.000000, 0.000000, 8.999760, 7.000000, 8.999760, -7.000000},
  {6.000000, 6.000000, 0.000000, 9.119760, 7.000000, 9.119760, -7.000000},
  {6.000000, 6.000000, 0.000000, 9.239760, 7.000000, 9.239760, -7.000000},
  {6.000000, 6.000000, 0.000000, 9.359760, 7.000000, 9.359760, -7.000000},
  {6.000000, 6.000000, 0.000000, 9.479760, 7.000000, 9.479760, -7.000000},
  {6.000000, 6.000000, 0.000000, 9.599760, 7.000000, 9.599760, -7.000000},
  {6.000000, 6.000000, 0.000000, 9.719760, 7.000000, 9.719760, -7.000000},
  {6.000000, 6.000000, 0.000000, 9.839760, 7.000000, 9.839760, -7.000000},
  {6.000000, 6.000000, 0.000000, 9.959760, 7.000000, 9.959760, -7.000000},
  {6.000000, 6.000000, 0.000000, 10.079760, 7.000000, 10.079760, -7.000000},
  {6.000000, 6.000000, 0.000000, 10.199760, 7.000000, 10.199760, -7.000000},
  {6.000000, 6.000000, 0.000000, 10.319760, 7.000000, 10.319760, -7.000000},
  {6.000000, 6.000000, 0.000000, 10.439760, 7.000000, 10.439760, -7.000000},
  {6.000000, 6.000000, 0.000000, 10.559760, 7.000000, 10.559760, -7.000000},
  {6.000000, 6.000000, 0.000000, 10.679760, 7.000000, 10.679760, -7.000000},
  {6.000000, 6.000000, 0.000000, 10.799760, 7.000000, 10.799760, -7.000000},
  {6.000000, 6.000000, 0.000000, 10.919760, 7.000000, 10.919760, -7.000000},
  {6.000000, 6.000000, 0.000000, 11.039760, 7.000000, 11.039760, -7.000000},
  {6.000000, 6.000000, 0.000000, 11.159760, 7.000000, 11.159760, -7.000000},
  {6.000000, 6.000000, 0.000000, 11.279760, 7.000000, 11.279760, -7.000000},
  {6.000000, 6.000000, 0.000000, 11.399760, 7.000000, 11.399760, -7.000000},
  {6.000000, 6.000000, 0.000000, 11.519760, 7.000000, 11.519760, -7.000000},
  {6.000000, 6.000000, 0.000000, 11.639760, 7.000000, 11.639760, -7.000000},
  {6.000000, 6.000000, 0.000000, 11.759760, 7.000000, 11.759760, -7.000000},
  {6.000000, 6.000000, 0.000000, 11.879760, 7.000000, 11.879760, -7.000000},
  {6.000000, 6.000000, 0.000000, 11.999760, 7.000000, 11.999760, -7.000000},
  {6.000000, 6.000000, 0.000000, 12.119760, 7.000000, 12.119760, -7.000000},
  {6.000000, 6.000000, 0.000000, 12.239760, 7.000000, 12.239760, -7.000000},
  {6.000000, 6.000000, 0.000000, 12.359760, 7.000000, 12.359760, -7.000000},
  {6.000000, 6.000000, 0.000000, 12.479760, 7.000000, 12.479760, -7.000000},
  {6.000000, 6.000000, 0.000000, 12.599760, 7.000000, 12.599760, -7.000000},
  {6.000000, 6.000000, 0.000000, 12.719760, 7.000000, 12.719760, -7.000000},
  {6.000000, 6.000000, 0.000000, 12.839760, 7.000000, 12.839760, -7.000000},
  {6.000000, 6.000000, 0.000000, 12.959760, 7.000000, 12.959760, -7.000000},
  {6.000000, 6.000000, 0.000000, 13.079760, 7.000000, 13.079760, -7.000000},
  {6.000000, 6.000000, 0.000000, 13.199760, 7.000000, 13.199760, -7.000000},
  {6.000000, 6.000000, 0.000000, 13.319760, 7.000000, 13.319760, -7.000000},
  {6.000000, 6.000000, 0.000000, 13.439760, 7.000000, 13.439760, -7.000000},
  {6.000000, 6.000000, 0.000000, 13.559760, 7.000000, 13.559760, -7.000000},
  {6.000000, 6.000000, 0.000000, 13.679760, 7.000000, 13.679760, -7.000000},
  {6.000000, 6.000000, 0.000000, 13.799760, 7.000000, 13.799760, -7.000000},
  {6.000000, 6.000000, 0.000000, 13.919760, 7.000000, 13.919760, -7.000000},
  {6.000000, 6.000000, 0.000000, 14.039760, 7.000000, 14.039760, -7.000000},
  {6.000000, 6.000000, 0.000000, 14.159760, 7.000000, 14.159760, -7.000000},
  {6.000000, 6.000000, 0.000000, 14.279760, 7.000000, 14.279760, -7.000000},
  {6.000000, 6.000000, 0.000000, 14.399760, 7.000000, 14.399760, -7.000000},
  {6.000000, 6.000000, 0.000000, 14.519760, 7.000000, 14.519760, -7.000000},
  {6.000000, 6.000000, 0.000000, 14.639760, 7.000000, 14.639760, -7.000000},
  {6.000000, 6.000000, 0.000000, 14.759760, 7.000000, 14.759760, -7.000000},
  {6.000000, 6.000000, 0.000000, 14.879760, 7.000000, 14.879760, -7.000000},
  {6.000000, 6.000000, 0.000000, 14.999760, 7.000000, 14.999760, -7.000000},
  {6.000000, 6.000000, 0.000000, 15.119760, 7.000000, 15.119760, -7.000000},
  {6.000000, 6.000000, 0.000000, 15.239760, 7.000000, 15.239760, -7.000000},
  {6.000000, 6.000000, 0.000000, 15.359760, 7.000000, 15.359760, -7.000000},
  {6.000000, 6.000000, 0.000000, 15.479760, 7.000000, 15.479760, -7.000000},
  {6.000000, 6.000000, 0.000000, 15.599760, 7.000000, 15.599760, -7.000000},
  {6.000000, 6.000000, 0.000000, 15.719760, 7.000000, 15.719760, -7.000000},
  {6.000000, 6.000000, 0.000000, 15.839760, 7.000000, 15.839760, -7.000000},
  {6.000000, 6.000000, 0.000000, 15.959760, 7.000000, 15.959760, -7.000000},
  {6.000000, 6.000000, 0.000000, 16.079760, 7.000000, 16.079760, -7.000000},
  {6.000000, 6.000000, 0.000000, 16.199760, 7.000000, 16.199760, -7.000000},
  {6.000000, 6.000000, 0.000000, 16.319760, 7.000000, 16.319760, -7.000000},
  {6.000000, 6.000000, 0.000000, 16.439760, 7.000000, 16.439760, -7.000000},
  {6.000000, 6.000000, 0.000000, 16.559760, 7.000000, 16.559760, -7.000000},
  {6.000000, 6.000000, 0.000000, 16.679760, 7.000000, 16.679760, -7.000000},
  {6.000000, 6.000000, 0.000000, 16.799760, 7.000000, 16.799760, -7.000000},
  {6.000000, 6.000000, 0.000000, 16.919760, 7.000000, 16.919760, -7.000000},
  {6.000000, 6.000000, 0.000000, 17.039760, 7.000000, 17.039760, -7.000000},
  {6.000000, 6.000000, 0.000000, 17.159760, 7.000000, 17.159760, -7.000000},
  {6.000000, 6.000000, 0.000000, 17.279760, 7.000000, 17.279760, -7.000000},
  {6.000000, 6.000000, 0.000000, 17.399760, 7.000000, 17.399760, -7.000000},
  {6.000000, 6.000000, 0.000000, 17.519760, 7.000000, 17.519760, -7.000000},
  {6.000000, 6.000000, 0.000000, 17.639760, 7.000000, 17.639760, -7.000000},
  {6.000000, 6.000000, 0.000000, 17.759760, 7.000000, 17.759760, -7.000000},
  {6.000000, 6.000000, 0.000000, 17.879760, 7.000000, 17.879760, -7.000000},
  {6.000000, 6.000000, 0.000000, 17.999760, 7.000000, 17.999760, -7.000000},
  {6.000000, 6.000000, 0.000000, 18.119760, 7.000000, 18.119760, -7.000000},
  {6.000000, 6.000000, 0.000000, 18.239760, 7.000000, 18.239760, -7.000000},
  {6.000000, 6.000000, 0.000000, 18.359760, 7.000000, 18.359760, -7.000000},
  {6.000000, 6.000000, 0.000000, 18.479760, 7.000000, 18.479760, -7.000000},
  {6.000000, 6.000000, 0.000000, 18.599760, 7.000000, 18.599760, -7.000000},
  {6.000000, 6.000000, 0.000000, 18.719760, 7.000000, 18.719760, -7.000000},
  {6.000000, 6.000000, 0.000000, 18.839760, 7.000000, 18.839760, -7.000000},
  {6.000000, 6.000000, 0.000000, 18.959760, 7.000000, 18.959760, -7.000000},
  {6.000000, 6.000000, 0.000000, 19.079760, 7.000000, 19.079760, -7.000000},
  {6.000000, 6.000000, 0.000000, 19.199760, 7.000000, 19.199760, -7.000000},
  {6.000000, 6.000000, 0.000000, 19.319760, 7.000000, 19.319760, -7.000000},
  {6.000000, 6.000000, 0.000000, 19.439760, 7.000000, 19.439760, -7.000000},
  {6.000000, 6.000000, 0.000000, 19.559760, 7.000000, 19.559760, -7.000000},
  {6.000000, 6.000000, 0.000000, 19.679760, 7.000000, 19.679760, -7.000000},
  {6.000000, 6.000000, 0.000000, 19.799760, 7.000000, 19.799760, -7.000000},
  {6.000000, 6.000000, 0.000000, 19.919760, 7.000000, 19.919760, -7.000000},
  {6.000000, 6.000000, 0.000000, 20.039760, 7.000000, 20.039760, -7.000000},
  {6.000000, 6.000000, 0.000000, 20.159760, 7.000000, 20.159760, -7.000000},
  {6.000000, 6.000000, 0.000000, 20.279760, 7.000000, 20.279760, -7.000000},
  {6.000000, 6.000000, 0.000000, 20.399760, 7.000000, 20.399760, -7.000000},
  {6.000000, 6.000000, 0.000000, 20.519760, 7.000000, 20.519760, -7.000000},
  {6.000000, 6.000000, 0.000000, 20.639760, 7.000000, 20.639760, -7.000000},
  {6.000000, 6.000000, 0.000000, 20.759760, 7.000000, 20.759760, -7.000000},
  {6.000000, 6.000000, 0.000000, 20.879760, 7.000000, 20.879760, -7.000000},
  {6.000000, 6.000000, 0.000000, 20.999760, 7.000000, 20.999760, -7.000000},
  {6.000000, 6.000000, 0.000000, 21.119760, 7.000000, 21.119760, -7.000000},
  {6.000000, 6.000000, 0.000000, 21.239760, 7.000000, 21.239760, -7.000000},
  {6.000000, 6.000000, 0.000000, 21.359760, 7.000000, 21.359760, -7.000000},
  {6.000000, 6.000000, 0.000000, 21.479760, 7.000000, 21.479760, -7.000000},
  {6.000000, 6.000000, 0.000000, 21.599760, 7.000000, 21.599760, -7.000000},
  {6.000000, 6.000000, 0.000000, 21.719760, 7.000000, 21.719760, -7.000000},
  {6.000000, 6.000000, 0.000000, 21.839760, 7.000000, 21.839760, -7.000000},
  {6.000000, 6.000000, 0.000000, 21.959760, 7.000000, 21.959760, -7.000000},
  {5.980040, 5.980040, 0.000000, 22.079361, 7.000000, 22.079361, -7.000000},
  {5.920120, 5.920120, 0.000000, 22.197763, 7.000000, 22.197763, -7.000000},
  {5.820200, 5.820200, 0.000000, 22.314167, 7.000000, 22.314167, -7.000000},
  {5.680280, 5.680280, 0.000000, 22.427773, 7.000000, 22.427773, -7.000000},
  {5.500360, 5.500360, 0.000000, 22.537780, 7.000000, 22.537780, -7.000000},
  {5.300400, 5.300400, 0.000000, 22.643788, 7.000000, 22.643788, -7.000000},
  {5.100400, 5.100400, 0.000000, 22.745796, 7.000000, 22.745796, -7.000000},
  {4.900400, 4.900400, 0.000000, 22.843804, 7.000000, 22.843804, -7.000000},
  {4.700400, 4.700400, 0.000000, 22.937812, 7.000000, 22.937812, -7.000000},
  {4.500400, 4.500400, 0.000000, 23.027820, 7.000000, 23.027820, -7.000000},
  {4.300400, 4.300400, 0.000000, 23.113828, 7.000000, 23.113828, -7.000000},
  {4.100400, 4.100400, 0.000000, 23.195836, 7.000000, 23.195836, -7.000000},
  {3.900400, 3.900400, 0.000000, 23.273844, 7.000000, 23.273844, -7.000000},
  {3.700400, 3.700400, 0.000000, 23.347852, 7.000000, 23.347852, -7.000000},
  {3.500400, 3.500400, 0.000000, 23.417860, 7.000000, 23.417860, -7.000000},
  {3.300400, 3.300400, 0.000000, 23.483868, 7.000000, 23.483868, -7.000000},
  {3.100400, 3.100400, 0.000000, 23.545876, 7.000000, 23.545876, -7.000000},
  {2.900400, 2.900400, 0.000000, 23.603884, 7.000000, 23.603884, -7.000000},
  {2.700400, 2.700400, 0.000000, 23.657892, 7.000000, 23.657892, -7.000000},
  {2.500400, 2.500400, 0.000000, 23.707900, 7.000000, 23.707900, -7.000000},
  {2.300400, 2.300400, 0.000000, 23.753908, 7.000000, 23.753908, -7.000000},
  {2.100400, 2.100400, 0.000000, 23.795916, 7.000000, 23.795916, -7.000000},
  {1.900400, 1.900400, 0.000000, 23.833924, 7.000000, 23.833924, -7.000000},
  {1.700400, 1.700400, 0.000000, 23.867932, 7.000000, 23.867932, -7.000000},
  {1.500400, 1.500400, 0.000000, 23.897940, 7.000000, 23.897940, -7.000000},
  {1.300400, 1.300400, 0.000000, 23.923948, 7.000000, 23.923948, -7.000000},
  {1.100400, 1.100400, 0.000000, 23.945956, 7.000000, 23.945956, -7.000000},
  {0.900400, 0.900400, 0.000000, 23.963964, 7.000000, 23.963964, -7.000000},
  {0.700400, 0.700400, 0.000000, 23.977972, 7.000000, 23.977972, -7.000000},
  {0.500400, 0.500400, 0.000000, 23.987980, 7.000000, 23.987980, -7.000000},
  {0.320360, 0.320360, 0.000000, 23.994387, 7.000000, 23.994387, -7.000000},
  {0.180280, 0.180280, 0.000000, 23.997993, 7.000000, 23.997993, -7.000000},
  {0.080200, 0.080200, 0.000000, 23.999597, 7.000000, 23.999597, -7.000000},
  {0.020120, 0.020120, 0.000000, 23.999999, 7.000000, 23.999999, -7.000000},
  {0.000040, 0.000040, 0.000000, 24.000000, 7.000000, 24.000000, -7.000000},
  {0.000000, 0.000000, 0.000000, 24.000000, 7.000000, 24.000000, -7.000000}};
}}