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
    public Red32Path60InPerSec() {
       kSpeed = 6.000000;
       kNumPoints = 142;
       kPoints = new double[][]{
  {0.400000, 0.400000, 359.997043, 16.002958, 167.250000, 16.002235, 153.250000},
  {0.911332, 0.688668, 359.978818, 16.021184, 167.249996, 16.016009, 153.249997},
  {2.050667, 1.549333, 359.937783, 16.062198, 167.249966, 16.046995, 153.249974},
  {3.646215, 2.753785, 359.864737, 16.135122, 167.249841, 16.102071, 153.249880},
  {5.698705, 4.301293, 359.750357, 16.249095, 167.249458, 16.188096, 153.249591},
  {7.981246, 6.018749, 359.589724, 16.408718, 167.248539, 16.308469, 153.248898},
  {10.266834, 7.733156, 359.382340, 16.614046, 167.246697, 16.463126, 153.247510},
  {12.556320, 9.443662, 359.127565, 16.865151, 167.243432, 16.651983, 153.245055},
  {14.850538, 11.149431, 358.824625, 17.162115, 167.238125, 16.874936, 153.241071},
  {17.150299, 12.849654, 358.472612, 17.505025, 167.230037, 17.131858, 153.235011},
  {19.456378, 14.543553, 358.070491, 17.893976, 167.218302, 17.422597, 153.226240},
  {21.769504, 16.230397, 357.617108, 18.329058, 167.201923, 17.746975, 153.214029},
  {24.090345, 17.909519, 357.111199, 18.810355, 167.179769, 18.104787, 153.197559},
  {26.419487, 19.580331, 356.551404, 19.337937, 167.150565, 18.495795, 153.175917},
  {28.757410, 21.242350, 355.936285, 19.911850, 167.112892, 18.919729, 153.148090},
  {31.104459, 22.895231, 355.264347, 20.532107, 167.065175, 19.376285, 153.112969},
  {33.460809, 24.538798, 354.534065, 21.198673, 167.005684, 19.865118, 153.069342},
  {35.826423, 26.173086, 353.743922, 21.911457, 166.932524, 20.385844, 153.015897},
  {38.201001, 27.798391, 352.892449, 22.670289, 166.843636, 20.938037, 152.951217},
  {40.583932, 29.415325, 351.978277, 23.474905, 166.736794, 21.521225, 152.873781},
  {42.974229, 31.024872, 351.000197, 24.324927, 166.609607, 22.134891, 152.781963},
  {45.370468, 32.628455, 349.957234, 25.219838, 166.459522, 22.778473, 152.674032},
  {47.770724, 34.227997, 348.848730, 26.158960, 166.283835, 23.451360, 152.548155},
  {50.172508, 35.825986, 347.674430, 27.141428, 166.079703, 24.152898, 152.402397},
  {52.572721, 37.425522, 346.434591, 28.166161, 165.844165, 24.882387, 152.234726},
  {54.967613, 39.030357, 345.130081, 29.231842, 165.574168, 25.639087, 152.043015},
  {57.352772, 40.644901, 343.762491, 30.336895, 165.266603, 26.422219, 151.825051},
  {59.723152, 42.274207, 342.334238, 31.479461, 164.918345, 27.230969, 151.578543},
  {62.073133, 43.923897, 340.848661, 32.657396, 164.526301, 28.064494, 151.301127},
  {64.396641, 45.600054, 339.310093, 33.868263, 164.087471, 28.921923, 150.990383},
  {66.453464, 47.142934, 337.729455, 35.105014, 163.600776, 29.799288, 150.645110},
  {68.005128, 48.391064, 336.123969, 36.356303, 163.067714, 30.689676, 150.265787},
  {69.050060, 49.346030, 334.511119, 37.611114, 162.490987, 31.586411, 149.853624},
  {69.589699, 50.006400, 332.908152, 38.858920, 161.874488, 32.483064, 149.410601},
  {69.628535, 50.367679, 331.331580, 40.089824, 161.223236, 33.373464, 148.939486},
  {69.404797, 50.591591, 329.791652, 41.298662, 160.540946, 34.254620, 148.442125},
  {69.154675, 50.841902, 328.292688, 42.484690, 159.829408, 35.126567, 147.918992},
  {68.881576, 51.115202, 326.838452, 43.647375, 159.090469, 35.989354, 147.370627},
  {68.589008, 51.407979, 325.432130, 44.786393, 158.325995, 36.843044, 146.797630},
  {68.280464, 51.716736, 324.076339, 45.901612, 157.537849, 37.687717, 146.200658},
  {67.959324, 52.038089, 322.773140, 46.993085, 156.727865, 38.523471, 145.580415},
  {67.628772, 52.368852, 321.524074, 48.061027, 155.897828, 39.350426, 144.937653},
  {67.291734, 52.706095, 320.330201, 49.105798, 155.049462, 40.168727, 144.273156},
  {66.950842, 53.047185, 319.192153, 50.127884, 154.184416, 40.978545, 143.587738},
  {66.608410, 53.389807, 318.110179, 51.127880, 153.304257, 41.780076, 142.882234},
  {66.266424, 53.731973, 317.084207, 52.106467, 152.410465, 42.573548, 142.157491},
  {65.926552, 54.072014, 316.113888, 53.064396, 151.504432, 43.359216, 141.414364},
  {65.590158, 54.408567, 315.198653, 54.002478, 150.587464, 44.137365, 140.653706},
  {65.258319, 54.740553, 314.337754, 54.921562, 149.660780, 44.908309, 139.876366},
  {64.931856, 55.067151, 313.530310, 55.822528, 148.725516, 45.672387, 139.083181},
  {64.611360, 55.387772, 312.775343, 56.706277, 147.782733, 46.429966, 138.274976},
  {64.297217, 55.702029, 312.071813, 57.573717, 146.833418, 47.181439, 137.452556},
  {63.989636, 56.009714, 311.418644, 58.425763, 145.878490, 47.927222, 136.616707},
  {63.688677, 56.310767, 310.814751, 59.263326, 144.918809, 48.667751, 135.768192},
  {63.394272, 56.605258, 310.259061, 60.087309, 143.955178, 49.403485, 134.907753},
  {63.106243, 56.893363, 309.750528, 60.898606, 142.988350, 50.134903, 134.036105},
  {62.824328, 57.175346, 309.288151, 61.698096, 142.019033, 50.862499, 133.153941},
  {62.548190, 57.451544, 308.870984, 62.486641, 141.047896, 51.586786, 132.261932},
  {62.277434, 57.722354, 308.498145, 63.265090, 140.075575, 52.308293, 131.360724},
  {62.011619, 57.988216, 308.168825, 64.034269, 139.102672, 53.027564, 130.450942},
  {61.750263, 58.249612, 307.882292, 64.794990, 138.129769, 53.745156, 129.533190},
  {61.492860, 58.507049, 307.637900, 65.548044, 137.157421, 54.461642, 128.608054},
  {61.238877, 58.761060, 307.435088, 66.294203, 136.186171, 55.177607, 127.676100},
  {60.987768, 59.012193, 307.273385, 67.034222, 135.216545, 55.893653, 126.737881},
  {60.738969, 59.261009, 307.152412, 67.768838, 134.249059, 56.610392, 125.793937},
  {60.491911, 59.508079, 307.071884, 68.498770, 133.284224, 57.328452, 124.844793},
  {60.246017, 59.753981, 307.031611, 69.224722, 132.322545, 58.048475, 123.890967},
  {60.000705, 59.999295, 307.031495, 69.947380, 131.364527, 58.771116, 122.932972},
  {59.755392, 60.244606, 307.071538, 70.667416, 130.410676, 59.497047, 121.971312},
  {59.509495, 60.490495, 307.151834, 71.385486, 129.461504, 60.226955, 121.006493},
  {59.262433, 60.737545, 307.272573, 72.102231, 128.517527, 60.961542, 120.039022},
  {59.013628, 60.986332, 307.434041, 72.818279, 127.579274, 61.701528, 119.069406},
  {58.762511, 61.237427, 307.636616, 73.534243, 126.647283, 62.447649, 118.098164},
  {58.508518, 61.491391, 307.880768, 74.250724, 125.722106, 63.200661, 117.125821},
  {58.251102, 61.748773, 308.167056, 74.968308, 124.804309, 63.961335, 116.152919},
  {57.989731, 62.010104, 308.496129, 75.687567, 123.894480, 64.730464, 115.180015},
  {57.723895, 62.275893, 308.868716, 76.409060, 122.993221, 65.508857, 114.207688},
  {57.453116, 62.546619, 309.285626, 77.133330, 122.101157, 66.297342, 113.236543},
  {57.176949, 62.822725, 309.747740, 77.860905, 121.218936, 67.096766, 112.267214},
  {56.895000, 63.104606, 310.256005, 78.592299, 120.347225, 67.907993, 111.300370},
  {56.606932, 63.392598, 310.811421, 79.328008, 119.486719, 68.731901, 110.336718},
  {56.312478, 63.686967, 311.415034, 80.068508, 118.638134, 69.569383, 109.377012},
  {56.011463, 63.987888, 312.067917, 80.814259, 117.802209, 70.421343, 108.422055},
  {55.703816, 64.295430, 312.771155, 81.565698, 116.979710, 71.288693, 107.472705},
  {55.389596, 64.609537, 313.525822, 82.323242, 116.171421, 72.172345, 106.529881},
  {55.069011, 64.929997, 314.332962, 83.087281, 115.378148, 73.073210, 105.594571},
  {54.742445, 65.256426, 315.193551, 83.858184, 114.600714, 73.992187, 104.667835},
  {54.410488, 65.588237, 316.108472, 84.636291, 113.839958, 74.930157, 103.750807},
  {54.073959, 65.924608, 317.078472, 85.421915, 113.096728, 75.887970, 102.844708},
  {53.733934, 66.264463, 318.104124, 86.215341, 112.371877, 76.866436, 101.950842},
  {53.391776, 66.606442, 319.185775, 87.016826, 111.666259, 77.866306, 101.070600},
  {53.049152, 66.948877, 320.323501, 87.826595, 110.980724, 78.888264, 100.205463},
  {52.708047, 67.289784, 321.517054, 88.644847, 110.316104, 79.932903, 99.356996},
  {52.370774, 67.626851, 322.765806, 89.471752, 109.673215, 81.000711, 98.526849},
  {52.039966, 67.957449, 324.068698, 90.307455, 109.052841, 82.092048, 97.716745},
  {51.718550, 68.278652, 325.424192, 91.152076, 108.455733, 83.207130, 96.928468},
  {51.409711, 68.587277, 326.830230, 92.005714, 107.882596, 84.346011, 96.163853},
  {51.116833, 68.879947, 328.284200, 92.868449, 107.334088, 85.508561, 95.424762},
  {50.843411, 69.153168, 329.782917, 93.740343, 106.810809, 86.694457, 94.713062},
  {50.592958, 69.403431, 331.322622, 94.621446, 106.313297, 87.903166, 94.030598},
  {50.368885, 69.627330, 332.898996, 95.511792, 105.842030, 89.133945, 93.379163},
  {50.174373, 69.821687, 334.507204, 96.411407, 105.397417, 90.385840, 92.760465},
  {50.012244, 69.983685, 336.141944, 97.320299, 104.979800, 91.657689, 92.176095},
  {49.884834, 70.110991, 337.797535, 98.238466, 104.589455, 92.948137, 91.627494},
  {49.793880, 70.201869, 339.468011, 99.165883, 104.226593, 94.255659, 91.115922},
  {49.740441, 70.255264, 341.147232, 100.102508, 103.891363, 95.578584, 90.642434},
  {49.559851, 70.037734, 342.823429, 101.045114, 103.584826, 96.910671, 90.209237},
  {49.085268, 69.316163, 344.479408, 101.987129, 103.308506, 98.240944, 89.819025},
  {48.312111, 68.093269, 346.098572, 102.921702, 103.063153, 99.558171, 89.473206},
  {47.233941, 66.375474, 347.665377, 103.841735, 102.848776, 100.851044, 89.171943},
  {45.842356, 64.171158, 349.165652, 104.739911, 102.664691, 102.108329, 88.914245},
  {44.294353, 61.721417, 350.592114, 105.612018, 102.509046, 103.323554, 88.697350},
  {42.749892, 59.266250, 351.944027, 106.457111, 102.379279, 104.495145, 88.517436},
  {41.204594, 56.811885, 353.221528, 107.274311, 102.272925, 105.621879, 88.370786},
  {39.654291, 54.362488, 354.425432, 108.062797, 102.187625, 106.702821, 88.253836},
  {38.095728, 51.921317, 355.557091, 108.821804, 102.121131, 107.737284, 88.163201},
  {36.526466, 49.490813, 356.618252, 109.550633, 102.071312, 108.724796, 88.095691},
  {34.944775, 47.072708, 357.610949, 110.248643, 102.036154, 109.665057, 88.048322},
  {33.349523, 44.668135, 358.537400, 110.915258, 102.013759, 110.557916, 88.018320},
  {31.740080, 42.277730, 359.399927, 111.549957, 102.002351, 111.403334, 88.003118},
  {31.340428, 38.671662, 0.000000, 112.176761, 102.000000, 112.176761, 88.000000},
  {33.009254, 33.009254, 0.000000, 112.836946, 102.000000, 112.836946, 88.000000},
  {31.009254, 31.009254, 0.000000, 113.457131, 102.000000, 113.457131, 88.000000},
  {29.009254, 29.009254, 0.000000, 114.037316, 102.000000, 114.037316, 88.000000},
  {27.009254, 27.009254, 0.000000, 114.577501, 102.000000, 114.577501, 88.000000},
  {25.009254, 25.009254, 0.000000, 115.077686, 102.000000, 115.077686, 88.000000},
  {23.009254, 23.009254, 0.000000, 115.537872, 102.000000, 115.537872, 88.000000},
  {21.009254, 21.009254, 0.000000, 115.958057, 102.000000, 115.958057, 88.000000},
  {19.009254, 19.009254, 0.000000, 116.338242, 102.000000, 116.338242, 88.000000},
  {17.009254, 17.009254, 0.000000, 116.678427, 102.000000, 116.678427, 88.000000},
  {15.009254, 15.009254, 0.000000, 116.978612, 102.000000, 116.978612, 88.000000},
  {13.009254, 13.009254, 0.000000, 117.238797, 102.000000, 117.238797, 88.000000},
  {11.009254, 11.009254, 0.000000, 117.458982, 102.000000, 117.458982, 88.000000},
  {9.009254, 9.009254, 0.000000, 117.639167, 102.000000, 117.639167, 88.000000},
  {7.009254, 7.009254, 0.000000, 117.779352, 102.000000, 117.779352, 88.000000},
  {5.009254, 5.009254, 0.000000, 117.879537, 102.000000, 117.879537, 88.000000},
  {3.208329, 3.208329, 0.000000, 117.943704, 102.000000, 117.943704, 88.000000},
  {1.806478, 1.806478, 0.000000, 117.979833, 102.000000, 117.979833, 88.000000},
  {0.804627, 0.804627, 0.000000, 117.995926, 102.000000, 117.995926, 88.000000},
  {0.202776, 0.202776, 0.000000, 117.999981, 102.000000, 117.999981, 88.000000},
  {0.000925, 0.000925, 0.000000, 118.000000, 102.000000, 118.000000, 88.000000},
  {0.000000, 0.000000, 0.000000, 118.000000, 102.000000, 118.000000, 88.000000}};
}}
