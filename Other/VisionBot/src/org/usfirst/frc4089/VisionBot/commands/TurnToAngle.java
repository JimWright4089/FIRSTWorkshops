// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4089.VisionBot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4089.VisionBot.RobotMap;
import org.usfirst.frc4089.VisionBot.StopWatch;

/**
 *
 */
public class TurnToAngle extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	double mTurnAngle = 0.0;
	double mNeedAngle = 0.0;
	StopWatch mForward = new StopWatch(6000);
	
    public TurnToAngle() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    	mTurnAngle = 0.0;
    }

    public TurnToAngle(double angle) {
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    	mTurnAngle = angle;
    }    
    
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	mForward.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	mNeedAngle = RobotMap.gyro.getAngle() - mTurnAngle;
    	if(mNeedAngle > 0)
    	{
    		RobotMap.driveBaseRobotDrive41.curvatureDrive(-0.6,0.6,true);
    	}
    	else
    	{
    		RobotMap.driveBaseRobotDrive41.curvatureDrive(-0.6,-0.6,true);   		
    	}    	
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	System.out.print(mNeedAngle);
    	System.out.print(" ");
    	System.out.print(Math.abs(mNeedAngle));
    	System.out.print(" ");
    	System.out.println((Math.abs(mNeedAngle)<1.0));
    	if((Math.abs(mNeedAngle)<1.0) || (true == mForward.isExpired()))
		{
    		RobotMap.driveBaseRobotDrive41.tankDrive(0, 0);
			return true;
		}

    	return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}