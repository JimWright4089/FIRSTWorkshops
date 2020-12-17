package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="Encoder Test 02", group="zJim Test")

public class EncoderTest02 extends OpMode
{

// Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotorEx leftMotor1 = null;
    private DcMotorEx leftMotor2 = null;
    private DcMotorEx rightMotor1 = null;
    private DcMotorEx rightMotor2 = null;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        leftMotor1  = hardwareMap.get(DcMotorEx.class, "leftMotor1");
        leftMotor2  = hardwareMap.get(DcMotorEx.class, "leftMotor2");
        rightMotor1 = hardwareMap.get(DcMotorEx.class, "rightMotor1");
        rightMotor2 = hardwareMap.get(DcMotorEx.class, "rightMotor2");

        leftMotor1.setDirection(DcMotor.Direction.REVERSE);
        leftMotor2.setDirection(DcMotor.Direction.REVERSE);
        rightMotor1.setDirection(DcMotor.Direction.FORWARD);
        rightMotor2.setDirection(DcMotor.Direction.FORWARD);

        leftMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        leftMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
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

    @Override
    public void stop() {
        leftMotor1.setPower(0.0);
        leftMotor2.setPower(0.0);
        rightMotor1.setPower(0.0);
        rightMotor2.setPower(0.0);
    }
}
