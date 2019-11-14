//----------------------------------------------------------------------------
//
//  $Workfile: DrivePathAction.java$
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
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.paths.*;
import frc.robot.*;
import java.io.FileWriter;
import java.io.IOException;

//----------------------------------------------------------------------------
//Class Declarations
//----------------------------------------------------------------------------
//
//Class Name: DrivePathAction
//
//Purpose:
//  Drive the robot using the old paths
//
//----------------------------------------------------------------------------
public class DrivePathAction extends Command 
{
    // ----------------------------------------------------------------------------
    // Attributes
    // ----------------------------------------------------------------------------
    private Path mPath;
    private int mCount = 0;
    private FileWriter mLogFile;
  
    // --------------------------------------------------------------------
    // Purpose:
    // Constructor
    //
    // Notes:
    // None.
    // --------------------------------------------------------------------
    public DrivePathAction(Path path) 
    {
      mPath = path;
      mCount = 0;
    }

    // --------------------------------------------------------------------
    // Purpose:
    // Cakked to see if the command needs to end
    //
    // Notes:
    // None.
    // --------------------------------------------------------------------
    @Override
    public boolean isFinished() 
    {
      int curCount = mPath.kNumPoints - mCount;
        if(curCount<1)
        {
          System.out.println(mPath.kNumPoints);
        }
        
        return curCount<1;
    }

    // --------------------------------------------------------------------
    // Purpose:
    // Main loop runned by the scheduler
    //
    // Notes:
    // None.
    // --------------------------------------------------------------------
    @Override
    public void execute() 
    {
      if(mCount<mPath.kNumPoints)
      {
        Robot.mDrive.AutoDrive(
            mPath.kSpeed,
            mPath.kPoints[mCount][0],
            mPath.kPoints[mCount][1],
            mPath.kPoints[mCount][2],
            mLogFile);
      }
      mCount++;
    }

    // --------------------------------------------------------------------
    // Purpose:
    // Called at the end of the command
    //
    // Notes:
    // None.
    // --------------------------------------------------------------------
    @Override
    public void end() 
    {
        Robot.mDrive.DriveRobot(0, 0);
    }

    // --------------------------------------------------------------------
    // Purpose:
    // Called to set up command
    //
    // Notes:
    // None.
    // --------------------------------------------------------------------
    @Override
    public void initialize() 
    {
      try {
        mLogFile = new FileWriter("/home/lvuser/drivePath.csv", true);
        mLogFile.write("\n");
        mLogFile.write("\n");
        mLogFile.write("Event:"+DriverStation.getInstance().getEventName()+"\n");
        mLogFile.write("Match Number:"+DriverStation.getInstance().getMatchNumber()+"\n");
        mLogFile.write("Replay Number:"+DriverStation.getInstance().getReplayNumber()+"\n");
        mLogFile.write("Game Data:"+DriverStation.getInstance().getGameSpecificMessage()+"\n");        
        mLogFile.write("\n");
      }
      catch(IOException e) 
      {
        e.printStackTrace();
        System.out.println("Unable to create FileWriter");
      }
      mCount = 0;
    }
}
