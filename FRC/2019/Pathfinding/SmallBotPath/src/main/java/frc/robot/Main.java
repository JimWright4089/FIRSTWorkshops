//----------------------------------------------------------------------------
//
//  $Workfile: Main.java$
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
import edu.wpi.first.wpilibj.RobotBase;

//----------------------------------------------------------------------------
//Class Declarations
//----------------------------------------------------------------------------
//
//Class Name: Main
//
//Purpose:
//  The entry point
//
//----------------------------------------------------------------------------
public final class Main {
  private Main() {
  }

  /**
   * Main initialization function. Do not perform any initialization here.
   *
   * <p>If you change your main robot class, change the parameter type.
   */
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
