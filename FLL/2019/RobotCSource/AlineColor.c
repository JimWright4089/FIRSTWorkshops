#pragma config(Sensor, S1,     LeftColor,      sensorEV3_Color)
#pragma config(Sensor, S2,     RightColor,     sensorEV3_Color)
#pragma config(Sensor, S4,     Gyro,           sensorEV3_Gyro)
#pragma config(Motor,  motorC,          motorLeft,     tmotorEV3_Large, PIDControl, driveLeft, encoder)
#pragma config(Motor,  motorD,          motorRight,    tmotorEV3_Large, PIDControl, driveRight, encoder)
//*!!Code automatically generated by 'ROBOTC' configuration wizard               !!*//
//----------------------------------------------------------------------------
//
//  $Workfile: AlineColor.c$
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
//     Run the robot and stop it on a white line
//
// Notes:
// None.
// --------------------------------------------------------------------
task main()
{
	while (true)
	{
		int lColor = getColorSaturation(LeftColor);
		int rColor = getColorSaturation(RightColor);

		if((lColor < 50)&&(rColor < 50))
		{
			motor[motorLeft] = 20;
			motor[motorRight] = 20;
		}
		else
		{
			motor[motorLeft] = 0;
			motor[motorRight] = 0;
		}
	}
}
