package org.usfirst.frc1039.TShirtCannonJava.commands;

import org.usfirst.frc1039.TShirtCannonJava.Robot;
import org.usfirst.frc1039.TShirtCannonJava.subsystems.Cannon;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoInit extends Command {

    public AutoInit() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cannon);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cannon.currentBarrel = -1;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.cannon.zeroBarrels();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (0 == Robot.cannon.currentBarrel);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
