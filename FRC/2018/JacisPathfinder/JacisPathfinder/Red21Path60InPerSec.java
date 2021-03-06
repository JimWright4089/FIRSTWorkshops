//----------------------------------------------------------------------------
//
//  $Workfile: Red21Path60InPerSec.java
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

public class Red21Path60InPerSec extends Path {
    public Red21Path60InPerSec{
       kNumPoints = 127
       kPoints = new double[][]{
  {0.400000, 0.400000, 359.998030, 16.003243, 95.250000, 16.002762, 81.250000}
,
  {0.864138, 0.735862, 359.987530, 16.020526, 95.249998, 16.017479, 81.249998}
,
  {1.944260, 1.655740, 359.963914, 16.059411, 95.249981, 16.050594, 81.249984}
,
  {3.456291, 2.943708, 359.921959, 16.128537, 95.249912, 16.109468, 81.249925}
,
  {5.400016, 4.599983, 359.856475, 16.236537, 95.249704, 16.201467, 81.249748}
,
  {7.559118, 6.440880, 359.764946, 16.387719, 95.249204, 16.330284, 81.249322}
,
  {9.717303, 8.282694, 359.647522, 16.582062, 95.248208, 16.495936, 81.248473}
,
  {11.874292, 10.125702, 359.504398, 16.819541, 95.246450, 16.698444, 81.246974}
,
  {14.029792, 11.970198, 359.335818, 17.100123, 95.243610, 16.937836, 81.244550}
,
  {16.183497, 13.816489, 359.142075, 17.423764, 95.239310, 17.214142, 81.240880}
,
  {18.335081, 15.664898, 358.923518, 17.790414, 95.233120, 17.527395, 81.235591}
,
  {20.484200, 17.515772, 358.680548, 18.200008, 95.224554, 17.877634, 81.228266}
,
  {22.630488, 19.369474, 358.413631, 18.652472, 95.213077, 18.264899, 81.218442}
,
  {24.773557, 21.226394, 358.123291, 19.147717, 95.198104, 18.689233, 81.205613}
,
  {26.912995, 23.086943, 357.810124, 19.685638, 95.179004, 19.150681, 81.189229}
,
  {29.048366, 24.951557, 357.474795, 20.266114, 95.155104, 19.649289, 81.168699}
,
  {31.179209, 26.820697, 357.118046, 20.889003, 95.125687, 20.185106, 81.143394}
,
  {33.305042, 28.694846, 356.740695, 21.554148, 95.090002, 20.758179, 81.112648}
,
  {35.425357, 30.574511, 356.343647, 22.261365, 95.047265, 21.368556, 81.075762}
,
  {37.539627, 32.460219, 355.927891, 23.010450, 94.996661, 22.016284, 81.032005}
,
  {39.647308, 34.352516, 355.494505, 23.801175, 94.937355, 22.701409, 80.980618}
,
  {41.747836, 36.251964, 355.044661, 24.633287, 94.868490, 23.423978, 80.920817}
,
  {43.840638, 38.159137, 354.579623, 25.506507, 94.789198, 24.184034, 80.851800}
,
  {45.925133, 40.074617, 354.100750, 26.420531, 94.698602, 24.981618, 80.772743}
,
  {48.000733, 41.998991, 353.609499, 27.375028, 94.595826, 25.816770, 80.682816}
,
  {50.066855, 43.932844, 353.107422, 28.369644, 94.479998, 26.689529, 80.581178}
,
  {52.122918, 45.876757, 352.596165, 29.403998, 94.350261, 27.599930, 80.466985}
,
  {54.168353, 47.831299, 352.077468, 30.477687, 94.205774, 28.548010, 80.339400}
,
  {56.202608, 49.797022, 351.553162, 31.590286, 94.045726, 29.533803, 80.197590}
,
  {58.225151, 51.774459, 351.025164, 32.741353, 93.869339, 30.557344, 80.040742}
,
  {60.024315, 53.575283, 350.497302, 33.926262, 93.676573, 31.614945, 79.868683}
,
  {61.390456, 55.009141, 349.974982, 35.136281, 93.468320, 32.699186, 79.682074}
,
  {62.326510, 56.073097, 349.463131, 36.362791, 93.245812, 33.802636, 79.481888}
,
  {62.835663, 56.763962, 348.966154, 37.597298, 93.010608, 34.917855, 79.269408}
,
  {62.921282, 57.078370, 348.487904, 38.831438, 92.764572, 36.037391, 79.046216}
,
  {62.795944, 57.203737, 348.030175, 40.061073, 92.508973, 37.157521, 78.813376}
,
  {62.670163, 57.329546, 347.593038, 41.286215, 92.244311, 38.278259, 78.571265}
,
  {62.544080, 57.455656, 347.176544, 42.506891, 91.971080, 39.399623, 78.320260}
,
  {62.417817, 57.581944, 346.780722, 43.723139, 91.689773, 40.521641, 78.060744}
,
  {62.291483, 57.708303, 346.405583, 44.935009, 91.400874, 41.644345, 77.793100}
,
  {62.165169, 57.834640, 346.051123, 46.142562, 91.104867, 42.767777, 77.517710}
,
  {62.038953, 57.960877, 345.717328, 47.345867, 90.802229, 43.891983, 77.234963}
,
  {61.912900, 58.086951, 345.404169, 48.545002, 90.493430, 45.017017, 76.945245}
,
  {61.787061, 58.212809, 345.111613, 49.740055, 90.178938, 46.142938, 76.648943}
,
  {61.661476, 58.338412, 344.839616, 50.931118, 89.859213, 47.269812, 76.346447}
,
  {61.536172, 58.463731, 344.588133, 52.118290, 89.534711, 48.397709, 76.038146}
,
  {61.411169, 58.588749, 344.357114, 53.301677, 89.205883, 49.526708, 75.724429}
,
  {61.286475, 58.713457, 344.146510, 54.481388, 88.873173, 50.656890, 75.405686}
,
  {61.162091, 58.837854, 343.956269, 55.657536, 88.537023, 51.788342, 75.082308}
,
  {61.038008, 58.961948, 343.786341, 56.830237, 88.197867, 52.921157, 74.754687}
,
  {60.914213, 59.085753, 343.636679, 57.999612, 87.856136, 54.055430, 74.423212}
,
  {60.790685, 59.209289, 343.507240, 59.165781, 87.512257, 55.191262, 74.088278}
,
  {60.667399, 59.332583, 343.397984, 60.328867, 87.166651, 56.328758, 73.750276}
,
  {60.544324, 59.455664, 343.308876, 61.488995, 86.819738, 57.468025, 73.409600}
,
  {60.421427, 59.578566, 343.239887, 62.646290, 86.471933, 58.609176, 73.066646}
,
  {60.298670, 59.701327, 343.190994, 63.800875, 86.123646, 59.752324, 72.721809}
,
  {60.176014, 59.823985, 343.162180, 64.952876, 85.775286, 60.897585, 72.375487}
,
  {60.053418, 59.946582, 343.153435, 66.102417, 85.427259, 62.045080, 72.028079}
,
  {59.930840, 60.069160, 343.164757, 67.249618, 85.079968, 63.194930, 71.679986}
,
  {59.808237, 60.191762, 343.196149, 68.394602, 84.733814, 64.347256, 71.331613}
,
  {59.685568, 60.314428, 343.247622, 69.537486, 84.389196, 65.502182, 70.983365}
,
  {59.562791, 60.437201, 343.319193, 70.678389, 84.046512, 66.659834, 70.635650}
,
  {59.439868, 60.560119, 343.410887, 71.817423, 83.706158, 67.820335, 70.288882}
,
  {59.316762, 60.683219, 343.522733, 72.954699, 83.368528, 68.983810, 69.943475}
,
  {59.193438, 60.806535, 343.654767, 74.090325, 83.034016, 70.150384, 69.599848}
,
  {59.069869, 60.930096, 343.807029, 75.224405, 82.703015, 71.320179, 69.258424}
,
  {58.946028, 61.053927, 343.979562, 76.357039, 82.375916, 72.493316, 68.919630}
,
  {58.821896, 61.178048, 344.172416, 77.488323, 82.053112, 73.669915, 68.583897}
,
  {58.697459, 61.302472, 344.385640, 78.618349, 81.734993, 74.850092, 68.251661}
,
  {58.572711, 61.427206, 344.619283, 79.747202, 81.421949, 76.033959, 67.923363}
,
  {58.447654, 61.552248, 344.873398, 80.874964, 81.114372, 77.221625, 67.599449}
,
  {58.322296, 61.677589, 345.148033, 82.001711, 80.812649, 78.413195, 67.280371}
,
  {58.196659, 61.803208, 345.443233, 83.127514, 80.517171, 79.608767, 66.966584}
,
  {58.070771, 61.929077, 345.759040, 84.252439, 80.228327, 80.808434, 66.658550}
,
  {57.944673, 62.055154, 346.095488, 85.376542, 79.946503, 82.012280, 66.356737}
,
  {57.818419, 62.181387, 346.452602, 86.499878, 79.672087, 83.220383, 66.061616}
,
  {57.692075, 62.307708, 346.830398, 87.622493, 79.405464, 84.432812, 65.773665}
,
  {57.565719, 62.434039, 347.228876, 88.744425, 79.147020, 85.649626, 65.493367}
,
  {57.439448, 62.560285, 347.648023, 89.865707, 78.897137, 86.870874, 65.221210}
,
  {57.313369, 62.686336, 348.087808, 90.986366, 78.656195, 88.096592, 64.957684}
,
  {57.187609, 62.812068, 348.548177, 92.106419, 78.424573, 89.326805, 64.703285}
,
  {57.062309, 62.937338, 349.029056, 93.225880, 78.202646, 90.561524, 64.458513}
,
  {56.937629, 63.061989, 349.530343, 94.344751, 77.990787, 91.800744, 64.223869}
,
  {56.813743, 63.185843, 350.051909, 95.463030, 77.789362, 93.044448, 63.999856}
,
  {56.690845, 63.308709, 350.593590, 96.580707, 77.598735, 94.292599, 63.786981}
,
  {56.569145, 63.430375, 351.155192, 97.697765, 77.419264, 95.545144, 63.585746}
,
  {56.448870, 63.550616, 351.736480, 98.814178, 77.251302, 96.802012, 63.396657}
,
  {56.330263, 63.669187, 352.337182, 99.929915, 77.095192, 98.063113, 63.220213}
,
  {56.213584, 63.785831, 352.956982, 101.044938, 76.951275, 99.328334, 63.056913}
,
  {56.099105, 63.900274, 353.595519, 102.159199, 76.819878, 100.597546, 62.907249}
,
  {55.987112, 64.012231, 354.252388, 103.272648, 76.701324, 101.870595, 62.771706}
,
  {55.853869, 64.093776, 354.926837, 104.384745, 76.595965, 103.146757, 62.650809}
,
  {55.514128, 63.930164, 355.615704, 105.491246, 76.504406, 104.421006, 62.545374}
,
  {54.808249, 63.332707, 356.313444, 106.584692, 76.427238, 105.684518, 62.456208}
,
  {53.738976, 62.298661, 357.014068, 107.657648, 76.364666, 106.928378, 62.383673}
,
  {52.308691, 60.825646, 357.711195, 108.702713, 76.316504, 108.143601, 62.327673}
,
  {50.543189, 58.939527, 358.398449, 109.712993, 76.282173, 109.321712, 62.287642}
,
  {48.628129, 56.854637, 359.071801, 110.685319, 76.260688, 110.458527, 62.262525}
,
  {46.723836, 54.758979, 359.729490, 111.619744, 76.250899, 111.553646, 62.251055}
,
  {47.083187, 50.388081, 0.000000, 112.561407, 76.250000, 112.561407, 62.250000}
,
  {46.741686, 46.741686, 0.000000, 113.496241, 76.250000, 113.496241, 62.250000}
,
  {44.741686, 44.741686, 0.000000, 114.391075, 76.250000, 114.391075, 62.250000}
,
  {42.741686, 42.741686, 0.000000, 115.245909, 76.250000, 115.245909, 62.250000}
,
  {40.741686, 40.741686, 0.000000, 116.060742, 76.250000, 116.060742, 62.250000}
,
  {38.741686, 38.741686, 0.000000, 116.835576, 76.250000, 116.835576, 62.250000}
,
  {36.741686, 36.741686, 0.000000, 117.570410, 76.250000, 117.570410, 62.250000}
,
  {34.741686, 34.741686, 0.000000, 118.265244, 76.250000, 118.265244, 62.250000}
,
  {32.741686, 32.741686, 0.000000, 118.920077, 76.250000, 118.920077, 62.250000}
,
  {30.741686, 30.741686, 0.000000, 119.534911, 76.250000, 119.534911, 62.250000}
,
  {28.741686, 28.741686, 0.000000, 120.109745, 76.250000, 120.109745, 62.250000}
,
  {26.741686, 26.741686, 0.000000, 120.644578, 76.250000, 120.644578, 62.250000}
,
  {24.741686, 24.741686, 0.000000, 121.139412, 76.250000, 121.139412, 62.250000}
,
  {22.741686, 22.741686, 0.000000, 121.594246, 76.250000, 121.594246, 62.250000}
,
  {20.741686, 20.741686, 0.000000, 122.009080, 76.250000, 122.009080, 62.250000}
,
  {18.741686, 18.741686, 0.000000, 122.383913, 76.250000, 122.383913, 62.250000}
,
  {16.741686, 16.741686, 0.000000, 122.718747, 76.250000, 122.718747, 62.250000}
,
  {14.741686, 14.741686, 0.000000, 123.013581, 76.250000, 123.013581, 62.250000}
,
  {12.741686, 12.741686, 0.000000, 123.268415, 76.250000, 123.268415, 62.250000}
,
  {10.741686, 10.741686, 0.000000, 123.483248, 76.250000, 123.483248, 62.250000}
,
  {8.741686, 8.741686, 0.000000, 123.658082, 76.250000, 123.658082, 62.250000}
,
  {6.741686, 6.741686, 0.000000, 123.792916, 76.250000, 123.792916, 62.250000}
,
  {4.767518, 4.767518, 0.000000, 123.888266, 76.250000, 123.888266, 62.250000}
,
  {3.019180, 3.019180, 0.000000, 123.948650, 76.250000, 123.948650, 62.250000}
,
  {1.670843, 1.670843, 0.000000, 123.982067, 76.250000, 123.982067, 62.250000}
,
  {0.722506, 0.722506, 0.000000, 123.996517, 76.250000, 123.996517, 62.250000}
,
  {0.174169, 0.174169, 0.000000, 124.000000, 76.250000, 124.000000, 62.250000}
,
  {0.000000, 0.000000, 0.000000, 124.000000, 76.250000, 124.000000, 62.250000}
};
}}
