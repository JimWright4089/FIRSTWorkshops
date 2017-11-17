package org.usfirst.frc1039.TShirtCannonJava.commands;

import org.usfirst.frc1039.TShirtCannonJava.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Rotate extends Command {

    public Rotate() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		Robot.cannon.isSafeToBarrleIn = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(false == Robot.cannon.isBarrleIn())
    	{
    		Robot.cannon.rotate();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.cannon.stopRotate();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
