package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="State Machine 01", group="zJim Test")

public class StateMachine01 extends LinearOpMode {

    private final int STATE_RUN_FORWARD1 = 0;
    private final int STATE_RUN_TURN_90  = 1;
    private final int STATE_RUN_FORWARD2 = 2;
    private final int STATE_STOP         = 3;

    private int mState = STATE_RUN_FORWARD1;

    @Override
    public void runOpMode() {
        long count = 0;
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            switch(mState)
            {
                case(STATE_RUN_FORWARD1):
                    telemetry.addData("State", "Forward1");
                    if(count > 200000)
                    {
                        count = 0;
                        mState = STATE_RUN_TURN_90;
                    }
                    break;
                case(STATE_RUN_TURN_90):
                    telemetry.addData("State", "Turn 90");
                    if(count > 200000)
                    {
                        count = 0;
                        mState = STATE_RUN_FORWARD2;
                    }
                    break;
                case(STATE_RUN_FORWARD2):
                    telemetry.addData("State", "Forward2");
                    if(count > 200000)
                    {
                        count = 0;
                        mState = STATE_STOP;
                    }
                    break;
                case(STATE_STOP):
                    telemetry.addData("State", "Stop");
                break;
            }
            count++;
            telemetry.update();
        }
    }
}
