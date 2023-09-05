package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "LIDAR Lite V4 Test", group = "Tests")
public class LIDARLiteV4Test extends LinearOpMode
{
    private LIDARLiteV4 lidar;

    public void runOpMode() throws InterruptedException
    {
        lidar = hardwareMap.get(LIDARLiteV4.class, "lidarv4");

        waitForStart();

        while(opModeIsActive())
        {
            telemetry.addData("Distance", lidar.getDistance());
            telemetry.update();
            idle();
        }
    }
}
