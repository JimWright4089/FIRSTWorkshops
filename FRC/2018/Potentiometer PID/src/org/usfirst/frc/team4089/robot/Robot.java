/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4089.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.Joystick;


public class Robot extends IterativeRobot {
  public static NetworkTable netTable;
  Joystick driveJoystick;
  public static WPI_TalonSRX driveSRX;
  
	@Override
	public void robotInit() {
    netTable = NetworkTable.getTable("FRCRobot");
    driveJoystick = new Joystick(0);
    driveSRX = new WPI_TalonSRX(6);
    driveSRX.configSelectedFeedbackSensor(
         FeedbackDevice.CTRE_MagEncoder_Relative, 0, 20);
	}

	@Override
	public void teleopInit() {
	}
  // Constants for Velocity
  final double kP = 0.001;
  final double kD = 0.00004;
  final double kI =  0.000015;
  final double kICap = 50000;

  double prevError = 0;
  double integral = 0;
  double power = 0;
  
	@Override
  public void teleopPeriodic() {
    VelocityPID();
//    PositionPID();
  }

  void VelocityPID()
  {
    double setPoint = driveJoystick.getRawAxis(3)*250;
    double curPoint = driveSRX.getSelectedSensorVelocity(0);
    
    double error = setPoint - curPoint;
    double derivative = error - prevError;
        
    power = power + (error * kP) + 
        (derivative * kD) + 
        (integral * kI);

    power = Cap(power,1.0);
    
    prevError = error;
    integral += error;
    integral = Cap(integral,kICap);
    
    netTable.putNumber("error", error);
    netTable.putNumber("derivative", derivative);
    netTable.putNumber("integral", integral);
    netTable.putNumber("power", power);
    netTable.putNumber("setPoint", setPoint);
    netTable.putNumber("curPoint", curPoint);
    
    System.out.print(setPoint);
    System.out.print(" ");
    System.out.println(curPoint);

    //System.out.println(driveSRX.getSelectedSensorPosition(0));
    driveSRX.set(power);
//    driveSRX.set(-1);
  }
	
	
  /*  
  Constants for Position
  final double kPPos = 0.004;
  final double kDPos = 0.000015;
  final double kIPos = 0.00003;
  final double kICapPos = 50000;

  Constants for Position overshoot
  final double kPPos = 0.002;
  final double kDPos = 0.000015;
  final double kIPos = 0.00006;
  final double kICapPos = 50000;
*/
  
  final double kPPos = 0.004;
  final double kDPos = 0.000015;
  final double kIPos = 0.00003;
  final double kICapPos = 50000;  
  
	void PositionPID()
	{
    double setPoint = driveJoystick.getRawAxis(3)*-4000;
    double curPoint = driveSRX.getSelectedSensorPosition(0);
    
    double error = setPoint - curPoint;
    double derivative = error - prevError;
        
    double power = (error * kPPos) + 
        (derivative * kDPos) + 
        (integral * kIPos);

    power = Cap(power,1.0);
    
    prevError = error;
    integral += error;
    integral = Cap(integral,kICapPos);
    
    netTable.putNumber("setPoint", setPoint);
    netTable.putNumber("curPoint", curPoint);
    netTable.putNumber("error", error);
    netTable.putNumber("derivative", derivative);
    netTable.putNumber("integral", integral);
    netTable.putNumber("power", power);

    System.out.print(setPoint);
    System.out.print(" ");
    System.out.println(curPoint);
    //System.out.println(driveSRX.getSelectedSensorPosition(0));
    driveSRX.set(power);
	  
	}
	
	
  // --------------------------------------------------------------------
  // Purpose:
  // Trim the top and bottom off of a number
  //
  // Notes:
  // None.
  // --------------------------------------------------------------------
  static public double Cap(double value, double peak) {
    if (value < -peak) {
      return -peak;
    }

    if (value > +peak) {
      return +peak;
    }
    return value;
  }

	
}
