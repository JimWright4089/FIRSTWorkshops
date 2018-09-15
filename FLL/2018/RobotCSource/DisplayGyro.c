#pragma config(Sensor, S4,     Gyro,           sensorEV3_Gyro, modeEV3Gyro_Angle)
//----------------------------------------------------------------------------
//
//  $Workfile: DisplayGyro.c$
//
//  $Revision: X$
//
//  Project:    PNW Code Wright
//
//                            Copyright (c) 2018
//                                Jim Wright
//                            All Rights Reserved
//
//  Modification History:
//  $Log:
//  $
//
//----------------------------------------------------------------------------

// --------------------------------------------------------------------
// Purpose:
//     Display the gyro on the screen
//
// Notes:
// None.
// --------------------------------------------------------------------
task main()
{
	resetGyro(Gyro);

	while (true)
	{
		int angle = SensorValue[Gyro];
		displayCenteredTextLine(3, "Sensor: %d", angle);
	}
}
