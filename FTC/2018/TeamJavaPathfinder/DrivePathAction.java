package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.hardware.DcMotor;

public class DrivePathAction {
    final int LEFT_MOTOR = 0;
    final int RIGHT_MOTOR = 1;
    final int HEADING = 2;
    final double DIST_TO_REAL_DIST_CONST = -25.5;

    private Path mPath;
    private int mCount = 0;

    public DrivePathAction(Path path) {
        mPath = path;
        mCount = 0;
    }

    public boolean isFinished() {
        int curCount = mPath.kNumPoints - mCount;
        if(curCount<1)
        {
            System.out.println(mPath.kNumPoints);
        }

        return curCount<1;
    }

    public void execute(DcMotor leftDrive,
                        DcMotor rightDrive,
                        ModernRoboticsI2cGyro gyro) {
        if(mCount<mPath.kNumPoints)
        {
            int currentAngle = gyro.getHeading();

            if(mPath.kPoints[mCount][HEADING]>180)
            {
                mPath.kPoints[mCount][HEADING] -= 360.0;
            }

            double targetSpeedL = mPath.kPoints[mCount][LEFT_MOTOR]*DIST_TO_REAL_DIST_CONST;
            double targetSpeedR = mPath.kPoints[mCount][RIGHT_MOTOR]*DIST_TO_REAL_DIST_CONST;

            double angle_difference = mPath.kPoints[mCount][HEADING] -
                    currentAngle;    // Make sure to bound this from -180 to 180, otherwise you will get super large values

            double turn = 3.0*angle_difference;

            targetSpeedL += turn;
            targetSpeedR -= turn;

            leftDrive.setPower(targetSpeedL);
            rightDrive.setPower(targetSpeedR);
        }
        mCount++;
    }

    public void end(DcMotor leftDrive, DcMotor rightDrive) {
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }

    public void initialize() {
        mCount = 0;
    }
}
