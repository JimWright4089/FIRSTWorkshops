//----------------------------------------------------------------------------
//
//  $Workfile: AutonomousRunner.java$
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
import edu.wpi.first.wpilibj.DriverStation;

//----------------------------------------------------------------------------
//Class Declarations
//----------------------------------------------------------------------------
//
//Class Name: AutonomousRunner
//
//Purpose:
//  Read the game data and descide what to do,
//
//----------------------------------------------------------------------------
public class AutonomousRunner extends CommandGroup 
{
  // --------------------------------------------------------------------
  // Purpose:
  // Constructor
  //
  // Notes:
  // Read the game data and set the commands to run
  // --------------------------------------------------------------------
  public AutonomousRunner() 
  {  
    String gameData = DriverStation.getInstance().getGameSpecificMessage();
    int counter = 0;
    while ((gameData == "" || gameData == null || gameData.length() != 1) && counter < 250) 
    {
      gameData = DriverStation.getInstance().getGameSpecificMessage();
      counter ++;
    }

    if(gameData.length()>0)
    {
      System.out.println("GameData:" + gameData);
      switch(gameData.charAt(0))
      {
        case('1'):
          addSequential(new FollowPath("BlueToDepotFront"));
          break;  
        case('2'):
          addSequential(new FollowPath("BlueToRocket2"));
          break;  
          case('3'):
          addSequential(new FollowPath("BlueToDepot2"));
          break;  
        case('T'):
          addSequential(new FollowPath("TenFeet")); 
          break;  
        default:
          addSequential(new FollowPath("BlueOffLevel2"));
          break;  
      }
    }
    else
    {
      System.out.println("No GameData!");
      addSequential(new FollowPath("BlueOffLevel2"));
    }
  }
}
