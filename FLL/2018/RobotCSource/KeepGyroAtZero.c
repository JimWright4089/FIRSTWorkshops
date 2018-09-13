#pragma config(Sensor, S4,     	Gyro,           sensorEV3_Gyro)
#pragma config(Motor,  motorC,	motorLeft,          tmotorEV3_Large, PIDControl, driveLeft, encoder)
#pragma config(Motor,  motorD,  motorRight,         tmotorEV3_Large, PIDControl, driveRight, encoder)
//*!!Code automatically generated by 'ROBOTC' configuration wizard               !!*//

/*
Gyro modes
0 - modeEV3Gyro_Angle
1 - modeEV3Gyro_Rate
2 - modeEV3Gyro_Fast
3 - modeEV3Gyro_RateAndAngle
4 - modeEV3Gyro_Calibration - Not utilized
*/
int DeadBand(int axisVal);

task main()
{
	resetGyro(Gyro);

	// The code below will rotate the robot 360 degrees and wait 1 second and repeat
	while (true)
	{
		int angle = DeadBand(SensorValue[Gyro]);

		if(0 == angle)
		{
			motor[motorLeft] = 0;
			motor[motorRight] = 0;
		}
		else
		{
			if(angle > 0)
			{
				motor[motorLeft] = 20;
				motor[motorRight] = -20;
			}
			else
			{
				motor[motorLeft] = -20;
				motor[motorRight] = 20;
			}
		}
	}
}

int DeadBand(int axisVal)
{
  if (axisVal < -4) {
    return axisVal;
  }

  if (axisVal > 4) {
    return axisVal;
  }

  return 0;
}

