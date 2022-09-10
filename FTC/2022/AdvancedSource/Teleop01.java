package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp(name="Robot: Teleop Tank", group="Robot")
public class Teleop01 extends OpMode{

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotorEx leftMotor1 = null;
    private DcMotorEx leftMotor2 = null;
    private DcMotorEx rightMotor1 = null;
    private DcMotorEx rightMotor2 = null;

    double clawOffset = 0;

    public static final double NORMAL_SPEED   =  0.75 ;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        leftMotor1  = hardwareMap.get(DcMotorEx.class, "leftmotor1");
        leftMotor2  = hardwareMap.get(DcMotorEx.class, "leftmotor2");
        rightMotor1 = hardwareMap.get(DcMotorEx.class, "rightmotor1");
        rightMotor2 = hardwareMap.get(DcMotorEx.class, "rightmotor2");

        leftMotor1.setDirection(DcMotor.Direction.FORWARD);
        leftMotor2.setDirection(DcMotor.Direction.FORWARD);
        rightMotor1.setDirection(DcMotor.Direction.REVERSE);
        rightMotor2.setDirection(DcMotor.Direction.REVERSE);

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

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double left = 0;
        double right = 0;

        // Run wheels in tank mode (note: The joystick goes negative when pushed forward, so negate it)
        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;

        if(!gamepad1.y)
        {
            left *= NORMAL_SPEED;
            right *= NORMAL_SPEED;
        }

        leftMotor1.setPower(left);
        leftMotor2.setPower(left);
        rightMotor1.setPower(right);
        rightMotor2.setPower(right);

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

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        leftMotor1.setPower(0.0);
        leftMotor2.setPower(0.0);
        rightMotor1.setPower(0.0);
        rightMotor2.setPower(0.0);
    }
}
