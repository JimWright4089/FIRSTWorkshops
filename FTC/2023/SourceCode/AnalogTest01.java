package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;

@TeleOp(name = "Analog", group = "Sensor")

public class AnalogTest01 extends OpMode
{
    private AnalogInput sensor=null;

    @Override
    public void init() {
        sensor  = hardwareMap.get(AnalogInput.class, "analogThingy");
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        double value = sensor.getVoltage();
        String strValue = Double.toString(value);
        telemetry.addData("Analog", strValue);
        telemetry.update();
    }

    @Override
    public void stop() {
    }
}
