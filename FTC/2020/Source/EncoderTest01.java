package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="Encoder Test 01", group="zJim Test")

public class EncoderTest01 extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotorEx leftMotor1 = null;
    private DcMotorEx leftMotor2 = null;
    private DcMotorEx rightMotor1 = null;
    private DcMotorEx rightMotor2 = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftMotor1  = hardwareMap.get(DcMotorEx.class, "leftMotor1");
        leftMotor2  = hardwareMap.get(DcMotorEx.class, "leftMotor2");
        rightMotor1 = hardwareMap.get(DcMotorEx.class, "rightMotor1");
        rightMotor2 = hardwareMap.get(DcMotorEx.class, "rightMotor2");

        leftMotor1.setDirection(DcMotor.Direction.REVERSE);
        leftMotor2.setDirection(DcMotor.Direction.REVERSE);
        rightMotor1.setDirection(DcMotor.Direction.FORWARD);
        rightMotor2.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            leftMotor1.setPower(0.25);
            leftMotor2.setPower(0.25);
            rightMotor1.setPower(0.25);
            rightMotor2.setPower(0.25);
    
            Integer leftPos = leftMotor1.getCurrentPosition();
            Integer rightPos = rightMotor1.getCurrentPosition();
            Double leftVel = (Double)leftMotor1.getVelocity(AngleUnit.DEGREES);
            Double rightVel = (Double)rightMotor1.getVelocity(AngleUnit.DEGREES);
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("L Pos", leftPos.toString());
            telemetry.addData("R Pos", rightPos.toString());
            telemetry.addData("L Vel", leftVel.toString());
            telemetry.addData("R Vel", rightVel.toString());
            telemetry.update();
        }
    }
}
