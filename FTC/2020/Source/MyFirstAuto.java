package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.StopWatch;

@Autonomous(name="My First Auto", group="Auto")

public class MyFirstAuto extends LinearOpMode {

    private final int STATE_RUN_FORWARD1 = 0;
    private final int STATE_RUN_TURN_90  = 1;
    private final int STATE_RUN_FORWARD2 = 2;
    private final int STATE_STOP         = 3;

    private int mState = STATE_RUN_FORWARD1;
//  Add the motors here


    @Override
    public void runOpMode() {
        boolean firstTimeInStop = true;
        telemetry.addData("Status", "Initialized");
        telemetry.update();

//      Find the motors in the map

//      Set the directons

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            switch(mState)
            {
                case(STATE_RUN_FORWARD1):
                    telemetry.addData("State", "Forward1");
//                  Run the motors at 0.5                    
                    
//                  Check the encoders until 2000 ticks
                    {
//                      Stop the motors
//                      Reset Encoders
                        mState = STATE_RUN_TURN_90;
                    }
                    break;
                case(STATE_RUN_TURN_90):
                    telemetry.addData("State", "Turn 90");
//                  Run the left motor at 0.5                    
//                  Run the right motor at -0.5                    

//                  Check the encoders until 2000 ticks
                    {
//                      Stop the motors
//                      Reset Encoders
                        mState = STATE_RUN_FORWARD2;
                    }
                    break;
                case(STATE_RUN_FORWARD2):
                    telemetry.addData("State", "Forward2");
//                  Run the motors at 0.5                    
                    
//                  Check the encoders until 2000 ticks
                    {
                        mState = STATE_STOP;
                    }
                    break;
                case(STATE_STOP):
//                  Set the motors t0 0.0                    
                    if(true == firstTimeInStop)
                    {
                        firstTimeInStop = false;
                        telemetry.addData("State", "Stop");
                    }
                break;
            }
            telemetry.update();
        }
    }
}
