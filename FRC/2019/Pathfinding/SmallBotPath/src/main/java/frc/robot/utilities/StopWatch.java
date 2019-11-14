//----------------------------------------------------------------------------
//
//  $Workfile: StopWatch.java$
//
//  $Revision: X$
//
//  Project:    Stealth Libraries
//
//                            Copyright (c) 2019
//                             James A. Wright
//                            All Rights Reserved
//
//  Modification History:
//  $Log:
//  $
//
//----------------------------------------------------------------------------
package frc.robot.utilities;

//----------------------------------------------------------------------------
//Class Declarations
//----------------------------------------------------------------------------
//
//Class Name: StopWatch
//
//Purpose:
//  Drive the robot using the controller or using the old paths
//
//----------------------------------------------------------------------------
public class StopWatch 
{
	// ----------------------------------------------------------------------------
  	// Attributes
  	// ----------------------------------------------------------------------------
  	long mLastTime = 0;  // The last time the watch was reset
	int mWaitTime = 0;   // The amount of time to wait
	
  	// --------------------------------------------------------------------
  	// Purpose:
  	// Constructor
  	//
  	// Notes:
  	// None.
  	// --------------------------------------------------------------------
	public StopWatch(int waitTime)
	{
		mWaitTime = waitTime;
	}
	
  	// --------------------------------------------------------------------
  	// Purpose:
  	// Change the amount of time to wait
  	//
  	// Notes:
  	// None.
  	// --------------------------------------------------------------------
	public void setTime(int waitTime)
	{
		mWaitTime = waitTime;
	}
	
  	// --------------------------------------------------------------------
  	// Purpose:
  	// Has the expired
  	//
  	// Notes:
  	// None.
  	// --------------------------------------------------------------------
	public boolean isExpired()
	{
		if((System.currentTimeMillis()-mLastTime)>mWaitTime)
		{
			return true;
		}
		return false;
	}
	
  	// --------------------------------------------------------------------
  	// Purpose:
  	// Reset the time to wait
  	//
  	// Notes:
  	// None.
  	// --------------------------------------------------------------------
	public void reset()
	{
		mLastTime = System.currentTimeMillis(); 
	}
	
  	// --------------------------------------------------------------------
  	// Purpose:
  	// Return the time left, if expired then the time is negative
  	//
  	// Notes:
  	// None.
  	// --------------------------------------------------------------------
	public long timeLeft()
	{
		return mWaitTime - (System.currentTimeMillis()-mLastTime);
	}
}