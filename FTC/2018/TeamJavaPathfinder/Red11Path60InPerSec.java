//----------------------------------------------------------------------------
//
//  $Workfile: Red11Path60InPerSec.java
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
package org.firstinspires.ftc.teamcode;

public class Red11Path60InPerSec extends Path {
    public Red11Path60InPerSec() {
       kSpeed = 6.000000;
       kNumPoints = 172;
       kPoints = new double[][]{
  {0.400000, 0.400000, 0.002675, 16.003018, 287.250000, 16.003671, 273.250000},
  {0.721853, 0.878147, 0.015467, 16.017455, 287.250002, 16.021234, 273.250003},
  {1.624280, 1.975720, 0.044233, 16.049940, 287.250019, 16.060748, 273.250023},
  {2.887984, 3.512015, 0.095311, 16.107700, 287.250090, 16.130989, 273.250109},
  {4.513441, 5.486558, 0.174961, 16.197968, 287.250303, 16.240720, 273.250368},
  {6.320806, 7.679191, 0.286147, 16.324384, 287.250811, 16.394302, 273.250986},
  {8.130183, 9.869813, 0.428538, 16.486984, 287.251826, 16.591695, 273.252217},
  {9.942177, 12.057815, 0.601705, 16.685820, 287.253614, 16.832841, 273.254386},
  {11.757417, 14.242569, 0.805118, 16.920950, 287.256501, 17.117671, 273.257883},
  {13.576560, 16.423419, 1.038136, 17.192446, 287.260869, 17.446097, 273.263167},
  {15.400292, 18.599679, 1.300010, 17.500388, 287.267155, 17.818013, 273.270758},
  {17.229330, 20.770630, 1.589870, 17.844865, 287.275845, 18.233293, 273.281235},
  {19.064426, 22.935521, 1.906723, 18.225976, 287.287480, 18.691790, 273.295232},
  {20.906366, 25.093565, 2.249451, 18.643828, 287.302645, 19.193331, 273.313434},
  {22.755971, 27.243943, 2.616797, 19.098537, 287.321971, 19.737719, 273.336569},
  {24.614091, 29.385805, 3.007368, 19.590226, 287.346127, 20.324727, 273.365408},
  {26.481606, 31.518269, 3.419625, 20.119025, 287.375823, 20.954101, 273.400751},
  {28.359420, 33.640433, 3.851883, 20.685071, 287.411798, 21.625555, 273.443423},
  {30.248457, 35.751373, 4.302304, 21.288509, 287.454820, 22.338772, 273.494271},
  {32.149651, 37.850155, 4.768898, 21.929487, 287.505679, 23.093404, 273.554145},
  {34.063945, 39.935838, 5.249520, 22.608163, 287.565179, 23.889069, 273.623900},
  {35.992276, 42.007484, 5.741873, 23.324698, 287.634136, 24.725355, 273.704378},
  {37.935571, 44.064167, 6.243507, 24.079261, 287.713367, 25.601820, 273.796405},
  {39.894739, 46.104979, 6.751824, 24.872028, 287.803681, 26.517994, 273.900775},
  {41.870661, 48.129039, 7.264081, 25.703182, 287.905878, 27.473380, 274.018243},
  {43.864185, 50.135500, 7.777397, 26.572915, 288.020731, 28.467461, 274.149513},
  {45.876119, 52.123556, 8.288758, 27.481429, 288.148985, 29.499698, 274.295228},
  {47.907226, 54.092442, 8.795027, 28.428939, 288.291339, 30.569540, 274.455956},
  {49.958225, 56.041442, 9.292946, 29.415675, 288.448445, 31.676428, 274.632186},
  {52.029785, 57.969885, 9.779152, 30.441883, 288.620887, 32.819796, 274.824310},
  {53.932274, 59.667408, 10.248580, 31.504087, 288.808503, 33.994955, 275.031872},
  {55.472329, 60.927376, 10.695083, 32.595044, 289.010206, 35.193196, 275.253403},
  {56.644337, 61.755400, 11.113430, 33.707465, 289.224573, 36.405992, 275.487108},
  {57.442387, 62.157387, 11.499359, 34.834004, 289.449874, 37.625001, 275.730897},
  {57.860398, 62.139415, 11.849602, 35.967260, 289.684099, 38.842067, 275.982440},
  {58.086244, 61.913607, 12.162876, 37.103558, 289.925822, 40.053239, 276.240086},
  {58.311592, 61.688292, 12.439263, 38.243002, 290.174349, 41.258665, 276.503001},
  {58.536412, 61.463500, 12.678848, 39.385703, 290.428982, 42.458508, 276.770363},
  {58.760708, 61.239229, 12.881718, 40.531788, 290.689017, 43.652935, 277.041363},
  {58.984512, 61.015446, 13.047953, 41.681391, 290.953746, 44.842121, 277.315206},
  {59.207878, 60.792096, 13.177623, 42.834658, 291.222456, 46.026246, 277.591104},
  {59.430883, 60.569103, 13.270787, 43.991741, 291.494429, 47.205491, 277.868285},
  {59.653617, 60.346378, 13.327490, 45.152804, 291.768940, 48.380037, 278.145982},
  {59.876179, 60.123820, 13.347760, 46.318012, 292.045257, 49.550065, 278.423442},
  {60.098679, 59.901320, 13.331606, 47.487541, 292.322642, 50.715753, 278.699917},
  {60.321226, 59.678770, 13.279020, 48.661568, 292.600351, 51.877275, 278.974668},
  {60.543927, 59.456061, 13.189977, 49.840272, 292.877628, 53.034800, 279.246964},
  {60.766884, 59.233092, 13.064435, 51.023837, 293.153710, 54.188490, 279.516079},
  {60.990190, 59.009770, 12.902335, 52.212442, 293.427823, 55.338500, 279.781294},
  {61.213921, 58.786019, 12.703609, 53.406268, 293.699185, 56.484975, 280.041895},
  {61.438135, 58.561781, 12.468176, 54.605490, 293.966998, 57.628053, 280.297173},
  {61.662867, 58.337020, 12.195951, 55.810278, 294.230457, 58.767858, 280.546425},
  {61.888123, 58.111731, 11.886849, 57.020793, 294.488740, 59.904507, 280.788952},
  {62.113878, 57.885939, 11.540787, 58.237185, 294.741014, 61.038102, 281.024059},
  {62.340068, 57.659708, 11.157693, 59.459594, 294.986434, 62.168733, 281.251058},
  {62.566587, 57.433144, 10.737514, 60.688141, 295.224140, 63.296480, 281.469266},
  {62.793281, 57.206400, 10.280221, 61.922929, 295.453258, 64.421405, 281.678004},
  {63.019946, 56.979682, 9.785817, 63.164042, 295.672903, 65.543560, 281.876603},
  {63.246320, 56.753250, 9.254350, 64.411537, 295.882177, 66.662982, 282.064399},
  {63.472080, 56.527427, 8.685920, 65.665443, 296.080172, 67.779694, 282.240737},
  {63.696842, 56.302600, 8.080690, 66.925758, 296.265968, 68.893704, 282.404973},
  {63.920150, 56.079222, 7.438898, 68.192446, 296.438642, 70.005010, 282.556473},
  {64.141484, 55.857816, 6.760867, 69.465432, 296.597261, 71.113592, 282.694615},
  {64.360250, 55.638974, 6.047016, 70.744598, 296.740894, 72.219421, 282.818793},
  {64.575787, 55.423358, 5.297874, 72.029783, 296.868610, 73.322454, 282.928416},
  {64.787366, 55.211698, 4.514089, 73.320778, 296.979483, 74.422638, 283.022911},
  {64.994195, 55.004786, 3.696438, 74.617323, 297.072599, 75.519907, 283.101724},
  {65.195426, 54.803472, 2.845837, 75.919104, 297.147058, 76.614187, 283.164323},
  {65.390162, 54.608652, 1.963350, 77.225753, 297.201982, 77.705396, 283.210201},
  {65.577468, 54.421261, 1.050192, 78.536848, 297.236522, 78.793444, 283.238874},
  {65.756387, 54.242260, 0.107737, 79.851908, 297.249861, 79.878233, 283.249885},
  {47.069232, 72.891995, 2.221487, 80.793158, 297.265773, 81.335834, 283.276295},
  {46.590967, 73.401695, 4.416110, 81.723381, 297.320292, 82.801372, 283.361856},
  {48.607157, 71.387545, 6.280792, 82.691238, 297.411480, 84.222853, 283.495512},
  {50.601646, 69.394749, 7.819075, 83.695550, 297.536251, 85.600186, 283.666415},
  {52.553763, 67.443972, 9.037878, 84.735192, 297.690857, 86.934416, 283.864671},
  {54.457261, 65.541484, 9.945144, 85.809338, 297.870988, 88.227212, 284.081358},
  {56.316316, 63.683128, 10.548128, 86.917608, 298.071863, 89.480467, 284.308442},
  {58.142083, 61.857774, 10.852262, 88.060134, 298.288277, 90.696015, 284.538654},
  {59.949909, 60.050089, 10.860462, 89.237575, 298.514611, 91.875424, 284.765366},
  {61.757111, 58.242761, 10.572808, 90.451079, 298.744797, 93.019867, 284.982482},
  {63.581055, 56.418420, 9.986536, 91.702195, 298.972239, 94.130029, 285.184359},
  {65.437237, 54.561554, 9.096340, 92.992745, 299.189706, 95.206075, 285.365771},
  {67.337088, 52.660712, 7.895040, 94.324628, 299.389211, 96.247651, 285.521912},
  {69.285234, 50.711243, 6.374694, 95.699532, 299.561882, 97.253952, 285.648443},
  {71.276089, 48.718717, 4.528268, 97.118552, 299.697882, 98.223865, 285.741583},
  {73.289891, 46.702893, 2.351961, 98.581674, 299.786412, 99.156205, 285.798206},
  {75.288789, 44.701660, 359.848171, 100.087161, 299.815886, 100.050062, 285.815935},
  {77.214211, 42.773679, 357.028891, 101.630886, 299.774338, 100.905232, 285.793157},
  {78.987471, 40.997792, 353.919011, 103.205747, 299.650152, 101.722669, 285.728928},
  {80.515736, 39.467056, 350.558649, 104.801363, 299.433079, 102.504832, 285.622722},
  {81.704490, 38.276247, 347.003429, 106.404282, 299.115430, 103.255784, 285.474061},
  {82.475031, 37.504312, 343.321892, 107.998823, 298.693183, 103.980899, 285.282132},
  {82.782248, 37.196526, 339.589990, 109.568512, 298.166651, 104.686211, 285.045556},
  {82.626078, 37.352988, 335.883691, 111.097803, 297.540475, 105.377539, 284.762424},
  {82.051775, 37.928343, 332.271541, 112.573634, 296.822896, 106.059689, 284.430619},
  {75.281972, 44.626755, 329.762134, 113.887422, 296.087429, 106.837148, 283.992238},
  {64.290289, 55.708959, 329.059738, 114.994322, 295.433159, 107.796305, 283.425305},
  {64.488399, 55.510779, 328.324905, 116.096316, 294.763002, 108.744891, 282.848450},
  {64.698666, 55.300433, 327.555643, 117.192985, 294.076209, 109.682261, 282.261429},
  {64.921896, 55.077115, 326.749830, 118.283864, 293.371990, 110.607724, 281.664007},
  {65.158923, 54.839991, 325.905207, 119.368434, 292.649508, 111.520542, 281.055950},
  {65.410602, 54.588202, 325.019372, 120.446120, 291.907880, 112.419928, 280.437037},
  {65.677799, 54.320884, 324.089786, 121.516278, 291.146177, 113.305044, 279.807058},
  {65.961371, 54.037178, 323.113766, 122.578190, 290.363423, 114.174997, 279.165818},
  {66.262145, 53.736254, 322.088494, 123.631052, 289.558593, 115.028841, 278.513143},
  {66.580891, 53.417341, 321.011027, 124.673965, 288.730620, 115.865573, 277.848882},
  {66.918283, 53.079763, 319.878310, 125.705921, 287.878395, 116.684137, 277.172910},
  {67.274853, 52.722986, 318.687202, 126.725793, 287.000771, 117.483420, 276.485137},
  {67.650931, 52.346679, 317.434507, 127.732316, 286.096575, 118.262261, 275.785510},
  {68.046572, 51.950784, 316.117020, 128.724078, 285.164618, 119.019449, 275.074019},
  {68.461476, 51.535600, 314.731584, 129.699498, 284.203709, 119.753735, 274.350699},
  {68.894881, 51.101889, 313.275169, 130.656815, 283.212677, 120.463836, 273.615637},
  {69.345451, 50.650982, 311.744960, 131.594074, 282.190394, 121.148450, 272.868969},
  {69.811158, 50.184911, 310.138478, 132.509108, 281.135808, 121.806267, 272.110888},
  {70.289147, 49.706530, 308.453707, 133.399537, 280.047983, 122.435985, 271.341634},
  {70.775615, 49.219644, 306.689257, 134.262757, 278.926143, 123.036330, 270.561496},
  {71.265706, 48.729110, 304.844532, 135.095951, 277.769723, 123.606076, 269.770800},
  {71.753444, 48.240914, 302.919914, 135.896099, 276.578427, 124.144065, 268.969899},
  {72.231715, 47.762174, 300.916953, 136.660008, 275.352290, 124.649227, 268.159158},
  {72.692339, 47.301082, 298.838537, 137.384355, 274.091738, 125.120600, 267.338936},
  {73.126239, 46.866723, 296.689040, 138.065745, 272.797641, 125.557342, 266.509567},
  {73.523732, 46.468798, 294.474426, 138.700790, 271.471363, 125.958742, 265.671344},
  {73.874932, 46.117204, 292.202276, 139.286201, 270.114788, 126.324223, 264.824502},
  {74.170271, 45.821526, 289.881741, 139.818892, 268.730327, 126.653340, 263.969209},
  {74.401079, 45.590448, 287.523392, 140.296087, 267.320897, 126.945770, 263.105565},
  {74.560186, 45.431153, 285.138976, 140.715431, 265.889870, 127.201298, 262.233612},
  {74.642460, 45.348781, 282.741081, 141.075079, 264.440990, 127.419806, 261.353352},
  {74.645223, 45.346014, 280.342733, 141.373776, 262.978272, 127.601256, 260.464768},
  {74.568471, 45.422858, 277.956960, 141.610897, 261.505874, 127.745684, 259.567865},
  {74.414875, 45.576637, 275.596351, 141.786461, 260.027968, 127.853190, 258.662694},
  {74.189555, 45.802220, 273.272657, 141.901113, 258.548613, 127.923944, 257.749387},
  {73.899670, 46.092438, 270.996454, 141.956071, 257.071641, 127.958189, 256.828174},
  {73.553875, 46.438621, 268.776902, 141.953056, 255.600567, 127.956246, 255.899404},
  {73.161722, 46.831202, 266.621592, 141.894197, 254.138517, 127.918527, 254.963539},
  {72.733078, 47.260300, 264.536502, 141.781939, 252.688193, 127.845541, 254.021156},
  {72.092641, 47.593126, 262.531087, 141.619431, 251.255528, 127.738213, 253.075363},
  {71.015826, 47.654296, 260.618831, 141.411201, 249.850558, 127.598440, 252.132582},
  {69.467695, 47.386844, 258.811414, 141.163017, 248.483551, 127.429103, 251.200096},
  {67.467572, 46.771404, 257.117347, 140.881533, 247.163886, 127.233931, 250.285255},
  {65.032290, 45.791112, 255.542386, 140.574045, 245.900110, 127.017388, 249.395402},
  {62.354853, 44.561037, 254.085903, 140.247274, 244.696585, 126.783840, 248.535326},
  {59.673235, 43.243171, 252.741053, 139.906505, 243.552804, 126.536874, 247.706474},
  {57.039863, 41.876972, 251.499929, 139.556194, 242.467124, 126.279668, 246.909406},
  {54.452294, 40.464895, 250.355026, 139.200274, 241.437881, 126.015160, 246.144554},
  {51.907624, 39.009858, 249.299315, 138.842215, 240.463430, 125.746058, 245.412234},
  {49.402726, 37.514998, 248.326279, 138.485075, 239.542179, 125.474846, 244.712667},
  {46.934412, 35.983510, 247.429927, 138.131551, 238.672607, 125.203800, 244.045990},
  {44.499548, 34.418538, 246.604777, 137.784024, 237.853273, 124.934995, 243.412272},
  {42.095123, 32.823098, 245.845846, 137.444595, 237.082826, 124.670325, 242.811529},
  {39.718287, 31.200044, 245.148614, 137.115123, 236.360008, 124.411510, 242.243733},
  {37.366381, 29.552040, 244.508998, 136.797251, 235.683654, 124.160111, 241.708824},
  {35.036936, 27.881558, 243.923320, 136.492433, 235.052685, 123.917541, 241.206716},
  {32.727674, 26.190880, 243.388274, 136.201957, 234.466116, 123.685081, 240.737305},
  {30.436500, 24.482103, 242.900899, 135.926961, 233.923042, 123.463882, 240.300475},
  {28.161492, 22.757150, 242.458546, 135.668453, 233.422640, 123.254982, 239.896104},
  {25.900884, 21.017790, 242.058859, 135.427322, 232.964167, 123.059310, 239.524067},
  {23.653053, 19.265645, 241.699744, 135.204350, 232.546949, 122.877697, 239.184239},
  {21.416508, 17.502209, 241.379354, 135.000226, 232.170386, 122.710880, 238.876501},
  {19.189870, 15.728863, 241.096066, 134.815550, 231.833941, 122.559511, 238.600736},
  {16.971861, 13.946883, 240.848468, 134.650843, 231.537143, 122.424160, 238.356838},
  {14.761293, 12.157460, 240.635341, 134.506552, 231.279580, 122.305322, 238.144708},
  {12.557052, 10.361707, 240.455650, 134.383057, 231.060900, 122.203417, 237.964260},
  {10.358089, 8.560675, 240.308530, 134.280675, 230.880806, 122.118801, 237.815417},
  {8.163408, 6.755358, 240.193279, 134.199661, 230.739056, 122.051760, 237.698116},
  {5.972057, 4.946711, 240.109353, 134.140213, 230.635460, 122.002520, 237.612307},
  {3.951575, 3.275316, 240.054001, 134.100795, 230.566960, 121.969847, 237.555530},
  {2.319653, 1.923485, 240.021574, 134.077625, 230.526767, 121.950635, 237.522201},
  {1.125713, 0.933671, 240.005855, 134.066373, 230.507267, 121.941302, 237.506027},
  {0.369301, 0.306330, 240.000701, 134.062680, 230.500870, 121.938239, 237.500722},
  {0.050219, 0.041657, 240.000000, 134.062178, 230.500000, 121.937822, 237.500000},
  {0.000000, 0.000000, 240.000000, 134.062178, 230.500000, 121.937822, 237.500000}};
}}