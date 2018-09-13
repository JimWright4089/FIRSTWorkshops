#pragma config(Sensor, S4,     Gyro,           sensorEV3_Gyro, modeEV3Gyro_Angle)

/*
Gyro modes
0 - modeEV3Gyro_Angle
1 - modeEV3Gyro_Rate
2 - modeEV3Gyro_Fast
3 - modeEV3Gyro_RateAndAngle
4 - modeEV3Gyro_Calibration - Not utilized
*/
task main()
{
	resetGyro(Gyro);

	// The code below will rotate the robot 360 degrees and wait 1 second and repeat
	while (true)
	{
		int angle = SensorValue[Gyro];
		displayCenteredTextLine(3, "Sensor: %d", angle);
	}
}
