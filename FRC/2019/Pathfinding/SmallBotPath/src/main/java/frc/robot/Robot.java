//----------------------------------------------------------------------------
//
//  $Workfile: Robot.java$
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
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;

//----------------------------------------------------------------------------
//Class Declarations
//----------------------------------------------------------------------------
//
//Class Name: Robot
//
//Purpose:
//  The main runner
//
//----------------------------------------------------------------------------
public class Robot extends TimedRobot
{
  // ----------------------------------------------------------------------------
  // Attributes
  // ----------------------------------------------------------------------------
  Command mAutonomousCommand;
  SendableChooser<Command> mChooser = new SendableChooser<>();

  public static OI mOi;
  public static Drive mDrive;
	public static DriverStation mDriversStation;
	NetworkTableInstance mNetTableInst;
  NetworkTable mToPiTable;
  NetworkTableEntry mLedStatusEntry;
  NetworkTableEntry mCasErrorEntry;
  NetworkTableEntry mCasWarnEntry;
  NetworkTableEntry mCasStatusEntry;
  NetworkTableEntry mCasInfoEntry;

  // --------------------------------------------------------------------
  // Purpose:
  // Get the robot ready to run
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  @Override
  public void robotInit()
  {
    RobotMap.init();
    mDrive = new Drive();

    // OI must be constructed after subsystems. If the OI creates Commands
    // (which it very likely will), subsystems are not guaranteed to be
    // constructed yet. Thus, their requires() statements may grab null
    // pointers. Bad news. Don't move it.
    mOi = new OI();

    SmartDashboard.putData("Auto mode", mChooser);

	  mDriversStation = DriverStation.getInstance();
		mNetTableInst = NetworkTableInstance.getDefault();
	  mToPiTable = mNetTableInst.getTable("toPi");
	  mLedStatusEntry = mToPiTable.getEntry("ledStatus");
	  mCasErrorEntry  = mToPiTable.getEntry("casError");
	  mCasWarnEntry   = mToPiTable.getEntry("casWarn");
	  mCasStatusEntry = mToPiTable.getEntry("casStatus");
	  mCasInfoEntry   = mToPiTable.getEntry("casInfo");
  }

  // --------------------------------------------------------------------
  // Purpose:
  // Called when the robot is disabled
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  @Override
  public void disabledInit()
  {
  }

  // --------------------------------------------------------------------
  // Purpose:
  // Disabled loop
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  @Override
  public void disabledPeriodic()
  {
    Scheduler.getInstance().run();
    setStatus();
  }

  // --------------------------------------------------------------------
  // Purpose:
  // Called at the start of auto
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  @Override
  public void autonomousInit()
  {
    mAutonomousCommand = mChooser.getSelected();
    // schedule the autonomous command (example)
    if (mAutonomousCommand != null)
      mAutonomousCommand.start();

    RobotMap.SetUpTalonsForAuto();
    mDrive.ClearCurrentAngle();
    RobotMap.sPigeonIMU.setFusedHeading(0.0, 30);

    mDrive.SetAuto();

    mAutonomousCommand = new AutonomousRunner();
    Scheduler.getInstance().add(mAutonomousCommand);
    setStatus();
  }

  // --------------------------------------------------------------------
  // Purpose:
  // Auto loop
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  @Override
  public void autonomousPeriodic()
  {
    Scheduler.getInstance().run();
  }

  // --------------------------------------------------------------------
  // Purpose:
  // Called at the first of tele
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  @Override
  public void teleopInit()
  {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (mAutonomousCommand != null)
      mAutonomousCommand.cancel();

    // Init teleop
    System.out.println("tele init");
    RobotMap.SetUpTalonsForTele();
    Robot.mDrive.SetTele();

    RobotMap.SetUpTalonsForTele();
    setStatus();
  }

  // --------------------------------------------------------------------
  // Purpose:
  // Tele loop
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  @Override
  public void teleopPeriodic()
  {
    Scheduler.getInstance().run();
    Robot.mDrive.DriveRobot(mOi.driveStick);
  }

  // --------------------------------------------------------------------
  // Purpose:
  // Send status to the pi
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  private void setStatus()
	{
	   if(mDriversStation.isEnabled())
	    {
	      mLedStatusEntry.setDouble((double)'G');  
	    }
	    else
	    {
	      if(Alliance.Red == mDriversStation.getAlliance())
	      {
	        mLedStatusEntry.setDouble((double)'R');  
	      }
	      else
	      {
	        mLedStatusEntry.setDouble((double)'B');  
	      }
	    }
	}
}
