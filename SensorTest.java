package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;

@Autonomous

public class SensorTest extends OpMode{

    TermigatorsHardware robot = new TermigatorsHardware();

    public void init()
    {

        robot.init(hardwareMap);

    }

    public void start() {

    }

    @Override
    public void loop() {
        telemetry.addData("Ultrasonic", robot.rangeSensorFar.rawUltrasonic());

        if(robot.rangeSensorFar.getDistance(DistanceUnit.CM) > 1000) {
            telemetry.addData("Optical", "Too Far");
        } else {
            telemetry.addData("Optical", "%.2f cm", robot.rangeSensorFar.getDistance(DistanceUnit.CM));
        }
        telemetry.update();
    }


}
