/* Red11 Feed Switch from Side start 1 aud */
package org.usfirst.frc4089.Stealth2018.MPPaths;

public class Path {
  public double kSpeed = 14.0;
  public int kNumPoints =64;
  public double[][] kPoints = new double[][]{
    {1.941176, 1.941176, 0.015257, 16.016520, 50.750002, 16.020248, 36.750003},
    {3.488871, 4.275835, 0.079671, 16.086297, 50.750060, 16.105765, 36.750074},
    {7.850859, 9.619725, 0.224454, 16.243314, 50.750477, 16.298158, 36.750584},
    {13.960238, 17.098559, 0.481330, 16.522514, 50.752197, 16.640123, 36.752691},
    {20.948262, 25.639886, 0.865345, 16.941450, 50.757121, 17.152885, 36.758718},
    {27.946678, 34.170765, 1.374795, 17.500277, 50.768050, 17.836170, 36.772080},
    {34.960430, 42.686235, 2.007164, 18.199180, 50.788689, 18.689523, 36.797278},
    {41.995675, 51.180127, 2.758927, 19.038367, 50.823623, 19.712240, 36.839850},
    {49.059988, 59.644859, 3.625319, 20.018043, 50.878279, 20.903285, 36.906295},
    {56.162496, 68.071300, 4.600079, 21.138399, 50.958868, 22.261203, 37.003965},
    {63.313893, 76.448762, 5.675199, 22.399585, 51.072310, 23.784031, 37.140931},
    {70.526316, 84.765124, 6.840681, 23.801698, 51.226135, 25.469224, 37.325798},
    {77.813052, 93.007124, 8.084357, 25.344764, 51.428361, 27.313598, 37.567492},
    {85.188074, 101.160823, 9.391773, 27.028729, 51.687335, 29.313309, 37.874996},
    {92.665435, 109.212216, 10.746177, 28.853459, 52.011547, 31.463878, 38.257067},
    {100.258559, 117.147931, 12.128624, 30.818760, 52.409418, 33.760259, 38.721920},
    {107.979532, 124.955935, 13.518196, 32.924416, 52.889051, 36.196974, 39.276911},
    {114.930857, 131.592734, 14.882021, 35.152700, 53.453310, 38.748314, 39.922916},
    {120.183906, 136.045905, 16.180371, 37.468485, 54.097366, 41.369755, 40.651917},
    {123.693871, 138.360158, 17.380845, 39.836876, 54.812066, 44.018981, 41.451302},
    {125.410564, 138.585538, 18.459248, 42.223250, 55.584296, 46.656071, 42.304609},
    {126.213163, 137.783830, 19.406330, 44.610787, 56.403792, 49.262502, 43.199188},
    {127.011332, 136.986433, 20.222810, 47.000449, 57.265341, 51.839855, 44.128364},
    {127.802935, 136.195483, 20.909754, 49.393427, 58.163724, 54.389986, 45.085712},
    {128.587073, 135.411881, 21.468374, 51.791123, 59.093728, 56.914950, 46.065052},
    {129.363853, 134.635522, 21.899867, 54.195132, 60.050151, 59.416931, 47.060431},
    {130.134167, 133.865519, 22.205283, 56.607221, 61.027794, 61.898188, 48.066094},
    {130.899490, 133.100401, 22.385430, 59.029309, 62.021454, 64.361003, 49.076453},
    {131.661693, 132.338295, 22.440811, 61.463443, 63.025901, 66.807646, 50.086060},
    {132.422879, 131.577104, 22.371583, 63.911772, 64.035857, 69.240337, 51.089569},
    {133.185219, 130.814654, 22.177550, 66.376524, 65.045967, 71.661215, 52.081707},
    {133.950793, 130.048864, 21.858172, 68.859970, 66.050765, 74.072315, 53.057249},
    {134.721439, 129.277895, 21.412611, 71.364394, 67.044650, 76.475538, 54.010993},
    {135.498571, 128.500329, 20.839795, 73.892048, 68.021845, 78.872634, 54.937742},
    {136.283001, 127.715351, 20.138518, 76.445105, 68.976372, 81.265178, 55.832290},
    {137.074732, 126.922953, 19.307577, 79.025601, 69.902026, 83.654550, 56.689425},
    {137.872738, 126.124162, 18.345931, 81.635366, 70.792355, 86.041914, 57.503926},
    {138.674731, 125.321264, 17.252919, 84.275945, 71.640653, 88.428209, 58.270586},
    {139.476932, 124.518043, 16.028494, 86.948512, 72.439974, 90.814127, 58.984231},
    {140.273866, 123.719981, 14.673508, 89.653764, 73.183152, 93.200114, 59.639763},
    {141.058218, 122.934406, 13.190012, 92.391821, 73.862867, 95.586357, 60.232205},
    {141.820786, 122.170543, 11.581565, 95.162120, 74.471718, 97.972798, 60.756759},
    {141.955926, 120.935511, 9.860956, 97.951596, 75.000316, 100.349205, 61.207148},
    {140.384899, 118.367208, 8.058709, 100.724973, 75.437978, 102.687601, 61.576229},
    {136.609521, 114.121577, 6.217967, 103.435947, 75.777814, 104.952302, 61.860175},
    {130.595347, 108.233131, 4.387517, 106.036653, 76.019444, 107.107678, 62.060472},
    {122.926817, 101.215916, 2.610384, 108.490596, 76.169661, 109.128212, 62.184188},
    {114.674048, 93.940632, 0.913269, 110.782989, 76.240287, 111.006133, 62.242065},
    {102.117862, 90.960362, 0.000000, 112.825323, 76.250000, 112.825323, 62.250000},
    {88.781742, 88.781742, 0.000000, 114.600958, 76.250000, 114.600958, 62.250000},
    {81.017036, 81.017036, 0.000000, 116.221299, 76.250000, 116.221299, 62.250000},
    {73.252331, 73.252331, 0.000000, 117.686345, 76.250000, 117.686345, 62.250000},
    {65.487625, 65.487625, 0.000000, 118.996098, 76.250000, 118.996098, 62.250000},
    {57.722919, 57.722919, 0.000000, 120.150556, 76.250000, 120.150556, 62.250000},
    {49.958213, 49.958213, 0.000000, 121.149720, 76.250000, 121.149720, 62.250000},
    {42.193507, 42.193507, 0.000000, 121.993590, 76.250000, 121.993590, 62.250000},
    {34.428801, 34.428801, 0.000000, 122.682167, 76.250000, 122.682167, 62.250000},
    {26.664095, 26.664095, 0.000000, 123.215448, 76.250000, 123.215448, 62.250000},
    {18.899389, 18.899389, 0.000000, 123.593436, 76.250000, 123.593436, 62.250000},
    {11.684024, 11.684024, 0.000000, 123.827117, 76.250000, 123.827117, 62.250000},
    {5.988589, 5.988589, 0.000000, 123.946888, 76.250000, 123.946888, 62.250000},
    {2.234330, 2.234330, 0.000000, 123.991575, 76.250000, 123.991575, 62.250000},
    {0.421247, 0.421247, 0.000000, 124.000000, 76.250000, 124.000000, 62.250000},
    {0.000000, 0.000000, 0.000000, 124.000000, 76.250000, 124.000000, 62.250000}};
}
