//----------------------------------------------------------------------------
//
//  $Workfile: SetAutoFinished.java$
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
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

//----------------------------------------------------------------------------
//Class Declarations
//----------------------------------------------------------------------------
//
//Class Name: SetAutoFinished
//
//Purpose:
//  The command to signal the old path finished
//
//----------------------------------------------------------------------------
public class SetAutoFinished extends Command {
  
	private boolean autoFinished;
	
	public SetAutoFinished() {
		autoFinished = true;
	}
	
    public SetAutoFinished(boolean value) {
        autoFinished = value;
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.isAutoFinished = autoFinished;
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
      end();
    }
}
