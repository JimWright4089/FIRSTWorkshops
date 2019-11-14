//----------------------------------------------------------------------------
//
//  $Workfile: FollowPath.java$
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
package frc.robot.commands;

// ----------------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------------
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.Notifier;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import com.ctre.phoenix.sensors.PigeonIMU;
import frc.robot.RobotMap;
import frc.robot.Constants;

//----------------------------------------------------------------------------
//Class Declarations
//----------------------------------------------------------------------------
//
//Class Name: FollowPath
//
//Purpose:
//  Drive the robot using Jaci's PAthfinder V1
//
//----------------------------------------------------------------------------
public class FollowPath extends CommandGroup 
{
  // ----------------------------------------------------------------------------
  // Attributes
  // ----------------------------------------------------------------------------
  boolean mRunLoop = true;

  // --------------------------------------------------------------------
  // Purpose:
  // Constructor
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  public FollowPath() 
  {
    InitPath(Constants.k_path_name);
  }

  // --------------------------------------------------------------------
  // Purpose:
  // Constructor
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  public FollowPath(String name) 
  {
    InitPath(name);
  }

  // --------------------------------------------------------------------
  // Purpose:
  // Set up the path to run
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  public void InitPath(String name) 
  {
    try
    {
      System.out.println(name + ".left");
      System.out.println(name + ".right");
      Trajectory left_trajectory = PathfinderFRC.getTrajectory(name + ".left");
      Trajectory right_trajectory = PathfinderFRC.getTrajectory(name + ".right");
      RobotMap.sLeftFollower = new EncoderFollower(left_trajectory);
      RobotMap.sRightFollower = new EncoderFollower(right_trajectory);
   
      RobotMap.sLeftFollower.configureEncoder(-1*RobotMap.sMotorLeftA.getSelectedSensorPosition(0), 
          Constants.k_ticks_per_rev, Constants.k_wheel_diameter);
      // You must tune the PID values on the following line!
      RobotMap.sLeftFollower.configurePIDVA(1.0, 0.0, 0.0, 1 / Constants.k_max_velocity, 0);
  
      RobotMap.sRightFollower.configureEncoder(-1*RobotMap.sMotorRightA.getSelectedSensorPosition(0), 
      Constants.k_ticks_per_rev, Constants.k_wheel_diameter);
      // You must tune the PID values on the following line!
      RobotMap.sRightFollower.configurePIDVA(1.0, 0.0, 0.0, 1 / Constants.k_max_velocity, 0);
      
      RobotMap.sFollowerNotifier = new Notifier(this::followPath);
      RobotMap.sFollowerNotifier.startPeriodic(left_trajectory.get(0).dt);
    }
    catch(Exception e)
    {
      System.console().printf(e.toString());
    }
  }

  // --------------------------------------------------------------------
  // Purpose:
  // Do nothing
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  @Override
  protected void execute() 
  {
  }

  // --------------------------------------------------------------------
  // Purpose:
  // Inform the scheduler the command has finished
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  @Override
  protected boolean isFinished() 
  {
	  return RobotMap.sLeftFollower.isFinished() || RobotMap.sRightFollower.isFinished();
  }

  // --------------------------------------------------------------------
  // Purpose:
  // Called at the end of the command
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  @Override
  protected void end() 
  {
  }

  // --------------------------------------------------------------------
  // Purpose:
  // If there user hits stop, stop the path
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  @Override
  protected void interrupted() 
  {
    mRunLoop = false;
  }

  // --------------------------------------------------------------------
  // Purpose:
  // The run task that is in the background that runs at the time slice
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  private void followPath() 
  {
    if ((isFinished())||(false == mRunLoop)) 
    {
      // Stop the motors and stop the follower
      RobotMap.sFollowerNotifier.stop();
      RobotMap.sMotorLeftA.set(0);
      RobotMap.sMotorRightA.set(0);
    } 
    else 
    {
      PigeonIMU.FusionStatus fusionStatus = new PigeonIMU.FusionStatus();
      double[] xyz_dps = new double[3];
      RobotMap.sPigeonIMU.getRawGyro(xyz_dps);
      RobotMap.sPigeonIMU.getFusedHeading(fusionStatus);
  
      double left_speed = RobotMap.sLeftFollower.calculate(RobotMap.sMotorLeftA.getSelectedSensorPosition(0)*-1);
      double right_speed = RobotMap.sRightFollower.calculate(RobotMap.sMotorRightA.getSelectedSensorPosition(0)*-1);
      double heading = fusionStatus.heading*-1;
      double desired_heading = Pathfinder.r2d(RobotMap.sLeftFollower.getHeading());
      double heading_difference = Pathfinder.boundHalfDegrees(desired_heading - heading);
      double turn =  0.8 * (-1.0/80.0) * heading_difference;
      
      System.out.print(left_speed);
      System.out.print(" ");
      System.out.print(right_speed);
      System.out.print(" ");
      System.out.print(heading);
      System.out.print(" ");
      System.out.print(desired_heading);
      System.out.print(" ");
      System.out.println(turn);

      RobotMap.sMotorLeftA.set(-1*(left_speed + turn));
      RobotMap.sMotorRightA.set(-1*(right_speed - turn));
    }
  }
}
