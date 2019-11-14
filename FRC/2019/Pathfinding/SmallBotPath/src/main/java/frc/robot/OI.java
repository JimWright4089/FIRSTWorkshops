//----------------------------------------------------------------------------
//
//  $Workfile: OI.java$
//
//  $Revision: X$
//
//  Project:    T-Wambat 
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
package frc.robot;

// ----------------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------------
import edu.wpi.first.wpilibj.Joystick;

//----------------------------------------------------------------------------
//Class Declarations
//----------------------------------------------------------------------------
//
//Class Name: OI
//
//Purpose:
//  The operator interface (joystick)
//
//----------------------------------------------------------------------------
public class OI
{
  public Joystick driveStick;

  public OI()
  {
    driveStick = new Joystick(0);
  }

  public Joystick getDriveStick()
  {
    return driveStick;
  }
}
