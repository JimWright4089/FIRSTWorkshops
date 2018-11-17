//----------------------------------------------------------------------------
//
//  $Workfile: Red32Path60InPerSec.java
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
//   Max Vel   = 60.000000
//   Max Accel = 100.000000
//   Max Jerk  =  1000.000000
package org.usfirst.frc4089.Stealth2018.MPPaths;

public class Red32Path60InPerSec extends Path {
    public Red32Path60InPerSec{
       kNumPoints = 139
       kPoints = new double[][]{
  {0.400000, 0.400000, 0.003193, 16.002360, 143.250000, 16.003140, 129.250000}
,
  {0.686518, 0.913482, 0.021770, 16.016090, 143.250003, 16.021410, 129.250004}
,
  {1.544550, 2.055450, 0.063588, 16.046981, 143.250026, 16.062519, 129.250035}
,
  {2.745474, 3.654526, 0.137994, 16.101891, 143.250123, 16.135609, 129.250163}
,
  {4.288800, 5.711199, 0.254419, 16.187666, 143.250416, 16.249833, 129.250554}
,
  {6.002278, 7.997717, 0.417748, 16.307710, 143.251120, 16.409784, 129.251493}
,
  {7.713751, 10.286239, 0.628310, 16.461978, 143.252529, 16.615500, 129.253370}
,
  {9.422694, 12.577288, 0.886517, 16.650416, 143.255019, 16.867024, 129.256695}
,
  {11.128626, 14.871343, 1.192863, 16.872952, 143.259058, 17.164402, 129.262092}
,
  {12.831119, 17.168833, 1.547910, 17.129501, 143.265194, 17.507680, 129.270303}
,
  {14.529809, 19.470120, 1.952281, 17.419961, 143.274068, 17.896901, 129.282194}
,
  {16.224419, 21.775482, 2.406643, 17.744215, 143.286407, 18.332096, 129.298755}
,
  {17.914767, 24.085097, 2.911693, 18.102125, 143.303028, 18.813279, 129.321102}
,
  {19.600799, 26.399021, 3.468137, 18.493533, 143.324840, 19.340442, 129.350479}
,
  {21.282600, 28.717165, 4.076667, 18.918263, 143.352842, 19.913541, 129.388264}
,
  {22.960429, 31.039271, 4.737933, 19.376114, 143.388127, 20.532491, 129.435966}
,
  {24.634744, 33.364880, 5.452509, 19.866863, 143.431880, 21.197152, 129.495226}
,
  {26.306230, 35.693306, 6.220857, 20.390260, 143.485380, 21.907318, 129.567818}
,
  {27.975832, 38.023602, 7.043286, 20.946033, 143.549996, 22.662701, 129.655643}
,
  {29.644784, 40.354533, 7.919899, 21.533882, 143.627191, 23.462921, 129.760728}
,
  {31.314640, 42.684546, 8.850549, 22.153480, 143.718519, 24.307487, 129.885216}
,
  {32.987294, 45.011747, 9.834776, 22.804475, 143.825618, 25.195781, 130.031356}
,
  {34.664999, 47.333882, 10.871752, 23.486487, 143.950213, 26.127045, 130.201488}
,
  {36.350372, 49.648335, 11.960221, 24.199112, 144.094111, 27.100367, 130.398027}
,
  {38.046387, 51.952133, 13.098441, 24.941917, 144.259188, 28.114665, 130.623438}
,
  {39.756352, 54.241970, 14.284126, 25.714450, 144.447393, 29.168677, 130.880215}
,
  {41.483864, 56.514253, 15.514404, 26.516230, 144.660730, 30.260959, 131.170844}
,
  {43.232741, 58.765166, 16.785776, 27.346758, 144.901253, 31.389876, 131.497775}
,
  {45.006934, 60.990763, 18.094099, 28.205512, 145.171051, 32.553611, 131.863383}
,
  {46.810416, 63.187075, 19.434577, 29.091951, 145.472236, 33.750175, 132.269928}
,
  {48.476112, 65.121212, 20.797029, 30.002318, 145.805710, 34.973137, 132.717893}
,
  {49.833667, 66.563562, 22.166422, 30.929739, 146.170742, 36.211913, 133.205456}
,
  {50.880250, 67.516963, 23.528188, 31.867483, 146.565906, 37.456286, 133.729813}
,
  {51.610921, 67.986351, 24.868566, 32.808976, 146.989068, 38.696510, 134.287220}
,
  {52.018861, 67.978540, 26.174911, 33.747805, 147.437382, 39.923386, 134.873059}
,
  {52.270394, 67.727168, 27.440091, 34.680827, 147.908921, 41.132319, 135.484016}
,
  {52.535281, 67.462445, 28.661919, 35.608069, 148.403091, 42.323034, 136.118579}
,
  {52.811113, 67.186778, 29.838604, 36.529577, 148.919258, 43.495396, 136.775232}
,
  {53.095592, 66.902462, 30.968730, 37.445414, 149.456751, 44.649397, 137.452475}
,
  {53.386577, 66.611639, 32.051233, 38.355664, 150.014869, 45.785147, 138.148834}
,
  {53.682104, 66.316267, 33.085367, 39.260431, 150.592887, 46.902862, 138.862873}
,
  {53.980415, 66.018106, 34.070678, 40.159841, 151.190059, 48.002853, 139.593199}
,
  {54.279962, 65.718703, 35.006962, 41.054046, 151.805626, 49.085510, 140.338473}
,
  {54.579409, 65.419392, 35.894235, 41.943222, 152.438817, 50.151294, 141.097409}
,
  {54.877631, 65.121298, 36.732698, 42.827568, 153.088859, 51.200724, 141.868777}
,
  {55.173700, 64.825350, 37.522703, 43.707308, 153.754976, 52.234368, 142.651407}
,
  {55.466874, 64.532287, 38.264722, 44.582692, 154.436396, 53.252832, 143.444186}
,
  {55.756584, 64.242682, 38.959323, 45.453993, 155.132351, 54.256752, 144.246055}
,
  {56.042414, 63.956947, 39.607140, 46.321507, 155.842083, 55.246787, 145.056010}
,
  {56.324087, 63.675362, 40.208852, 47.185552, 156.564846, 56.223612, 145.873098}
,
  {56.601449, 63.398079, 40.765166, 48.046470, 157.299905, 57.187913, 146.696415}
,
  {56.874453, 63.125148, 41.276794, 48.904619, 158.046538, 58.140382, 147.525098}
,
  {57.143142, 62.856525, 41.744443, 49.760382, 158.804037, 59.081712, 148.358330}
,
  {57.407639, 62.592087, 42.168796, 50.614157, 159.571711, 60.012596, 149.195326}
,
  {57.668134, 62.331644, 42.550510, 51.466362, 160.348881, 60.933721, 150.035340}
,
  {57.924875, 62.074950, 42.890199, 52.317430, 161.134883, 61.845768, 150.877652}
,
  {58.178152, 61.821712, 43.188429, 53.167812, 161.929067, 62.749411, 151.721571}
,
  {58.428300, 61.571599, 43.445712, 54.017975, 162.730796, 63.645313, 152.566429}
,
  {58.675680, 61.324248, 43.662500, 54.868400, 163.539444, 64.534128, 153.411576}
,
  {58.920682, 61.079270, 43.839183, 55.719584, 164.354395, 65.416496, 154.256381}
,
  {59.163715, 60.836257, 43.976082, 56.572036, 165.175043, 66.293049, 155.100227}
,
  {59.405202, 60.594783, 44.073451, 57.426282, 166.000789, 67.164401, 155.942507}
,
  {59.645580, 60.354414, 44.131470, 58.282860, 166.831037, 68.031160, 156.782622}
,
  {59.885293, 60.114707, 44.150248, 59.142322, 167.665198, 68.893914, 157.619978}
,
  {60.124787, 59.875212, 44.129820, 60.005233, 168.502683, 69.753243, 158.453987}
,
  {60.364514, 59.635481, 44.070147, 60.872172, 169.342900, 70.609712, 159.284057}
,
  {60.604920, 59.395065, 43.971119, 61.743732, 170.185258, 71.463871, 160.109600}
,
  {60.846450, 59.153521, 43.832551, 62.620516, 171.029157, 72.316260, 160.930021}
,
  {61.089537, 58.910414, 43.654188, 63.503143, 171.873989, 73.167401, 161.744719}
,
  {61.334607, 58.665320, 43.435703, 64.392243, 172.719137, 74.017805, 162.553088}
,
  {61.582067, 58.417831, 43.176707, 65.288458, 173.563968, 74.867968, 163.354512}
,
  {61.832304, 58.167559, 42.876743, 66.192441, 174.407833, 75.718370, 164.148365}
,
  {62.085681, 57.914142, 42.535297, 67.104857, 175.250063, 76.569477, 164.934009}
,
  {62.342527, 57.657249, 42.151802, 68.026378, 176.089964, 77.421739, 165.710793}
,
  {62.603133, 57.396590, 41.725639, 68.957688, 176.926818, 78.275589, 166.478052}
,
  {62.867745, 57.131920, 41.256154, 69.899473, 177.759874, 79.131445, 167.235108}
,
  {63.136547, 56.863051, 40.742660, 70.852426, 178.588348, 79.989703, 167.981268}
,
  {63.409661, 56.589865, 40.184450, 71.817240, 179.411420, 80.850745, 168.715824}
,
  {63.687126, 56.312319, 39.580811, 72.794607, 180.228227, 81.714930, 169.438053}
,
  {63.968890, 56.030467, 38.931039, 73.785213, 181.037861, 82.582597, 170.147221}
,
  {64.254794, 55.744467, 38.234455, 74.789732, 181.839368, 83.454064, 170.842580}
,
  {64.544555, 55.454602, 37.490427, 75.808822, 182.631741, 84.329626, 171.523371}
,
  {64.837751, 55.161294, 36.698391, 76.843118, 183.413921, 85.209555, 172.188827}
,
  {65.133806, 54.865118, 35.857880, 77.893226, 184.184790, 86.094100, 172.838175}
,
  {65.431971, 54.566825, 34.968547, 78.959710, 184.943176, 86.983483, 173.470641}
,
  {65.731310, 54.267349, 34.030199, 80.043087, 185.687847, 87.877904, 174.085449}
,
  {66.030689, 53.967826, 33.042828, 81.143816, 186.417515, 88.777537, 174.681830}
,
  {66.328766, 53.669599, 32.006647, 82.262285, 187.130838, 89.682532, 175.259026}
,
  {66.623982, 53.374226, 30.922123, 83.398800, 187.826422, 90.593015, 175.816290}
,
  {66.914573, 53.083475, 29.790014, 84.553572, 188.502828, 91.509090, 176.352900}
,
  {67.198570, 52.799314, 28.611398, 85.726707, 189.158582, 92.430838, 176.868154}
,
  {67.473823, 52.523896, 27.387707, 86.918193, 189.792182, 93.358323, 177.361384}
,
  {67.738033, 52.259522, 26.120747, 88.127887, 190.402113, 94.291588, 177.831958}
,
  {67.988789, 52.008605, 24.812723, 89.355511, 190.986861, 95.230662, 178.279281}
,
  {68.223622, 51.773616, 23.466241, 90.600637, 191.544934, 96.175558, 178.702806}
,
  {68.440069, 51.557022, 22.084311, 91.862690, 192.074876, 97.126278, 179.102033}
,
  {68.635741, 51.361213, 20.670336, 93.140943, 192.575291, 98.082810, 179.476514}
,
  {68.808404, 51.188427, 19.228083, 94.434520, 193.044865, 99.045132, 179.825854}
,
  {68.956052, 51.040672, 17.761649, 95.742400, 193.482386, 100.013211, 180.149712}
,
  {69.076987, 50.919648, 16.275409, 97.063433, 193.886765, 100.986999, 180.447806}
,
  {69.169882, 50.826684, 14.773955, 98.396352, 194.257058, 101.966439, 180.719906}
,
  {69.233841, 50.762677, 13.262026, 99.739789, 194.592477, 102.951455, 180.965841}
,
  {69.268433, 50.728058, 11.744431, 101.092301, 194.892408, 103.941953, 181.185494}
,
  {69.263780, 50.715499, 10.226189, 102.452193, 195.156379, 104.937677, 181.378775}
,
  {68.989691, 50.555222, 8.717264, 103.813178, 195.383429, 105.934999, 181.545153}
,
  {68.227462, 50.083173, 7.232092, 105.164534, 195.572723, 106.926978, 181.684102}
,
  {66.981391, 49.295043, 5.784406, 106.495531, 195.724542, 107.906528, 181.795827}
,
  {65.257463, 48.184831, 4.386958, 107.795545, 195.840210, 108.866434, 181.881227}
,
  {63.072699, 46.752708, 3.051118, 109.054344, 195.922004, 109.799521, 181.941850}
,
  {60.663821, 45.161912, 1.782243, 110.266543, 195.973134, 110.701957, 181.979907}
,
  {58.255435, 43.570593, 0.580251, 111.431404, 195.997124, 111.573184, 181.997842}
,
  {52.452210, 45.363162, 0.000000, 112.480445, 196.000000, 112.480445, 182.000000}
,
  {46.913948, 46.913948, 0.000000, 113.418724, 196.000000, 113.418724, 182.000000}
,
  {44.913948, 44.913948, 0.000000, 114.317002, 196.000000, 114.317002, 182.000000}
,
  {42.913948, 42.913948, 0.000000, 115.175281, 196.000000, 115.175281, 182.000000}
,
  {40.913948, 40.913948, 0.000000, 115.993560, 196.000000, 115.993560, 182.000000}
,
  {38.913948, 38.913948, 0.000000, 116.771839, 196.000000, 116.771839, 182.000000}
,
  {36.913948, 36.913948, 0.000000, 117.510118, 196.000000, 117.510118, 182.000000}
,
  {34.913948, 34.913948, 0.000000, 118.208397, 196.000000, 118.208397, 182.000000}
,
  {32.913948, 32.913948, 0.000000, 118.866676, 196.000000, 118.866676, 182.000000}
,
  {30.913948, 30.913948, 0.000000, 119.484955, 196.000000, 119.484955, 182.000000}
,
  {28.913948, 28.913948, 0.000000, 120.063234, 196.000000, 120.063234, 182.000000}
,
  {26.913948, 26.913948, 0.000000, 120.601513, 196.000000, 120.601513, 182.000000}
,
  {24.913948, 24.913948, 0.000000, 121.099792, 196.000000, 121.099792, 182.000000}
,
  {22.913948, 22.913948, 0.000000, 121.558071, 196.000000, 121.558071, 182.000000}
,
  {20.913948, 20.913948, 0.000000, 121.976350, 196.000000, 121.976350, 182.000000}
,
  {18.913948, 18.913948, 0.000000, 122.354629, 196.000000, 122.354629, 182.000000}
,
  {16.913948, 16.913948, 0.000000, 122.692908, 196.000000, 122.692908, 182.000000}
,
  {14.913948, 14.913948, 0.000000, 122.991187, 196.000000, 122.991187, 182.000000}
,
  {12.913948, 12.913948, 0.000000, 123.249466, 196.000000, 123.249466, 182.000000}
,
  {10.913948, 10.913948, 0.000000, 123.467745, 196.000000, 123.467745, 182.000000}
,
  {8.913948, 8.913948, 0.000000, 123.646024, 196.000000, 123.646024, 182.000000}
,
  {6.913948, 6.913948, 0.000000, 123.784303, 196.000000, 123.784303, 182.000000}
,
  {4.922553, 4.922553, 0.000000, 123.882754, 196.000000, 123.882754, 182.000000}
,
  {3.139763, 3.139763, 0.000000, 123.945549, 196.000000, 123.945549, 182.000000}
,
  {1.756974, 1.756974, 0.000000, 123.980688, 196.000000, 123.980688, 182.000000}
,
  {0.774184, 0.774184, 0.000000, 123.996172, 196.000000, 123.996172, 182.000000}
,
  {0.191395, 0.191395, 0.000000, 124.000000, 196.000000, 124.000000, 182.000000}
,
  {0.000000, 0.000000, 0.000000, 124.000000, 196.000000, 124.000000, 182.000000}
};
}}