package org.firstinspires.ftc.teamcode.Termigators2018_2019;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Robotics 2 on 10/15/2018.
 */

public class TermigatorsTeleOp extends OpMode{

    TermigatorsHardware robot = new TermigatorsHardware();

    @Override
    public void init() {

        robot.init(hardwareMap);

    }

    @Override
    public void loop() {

        double leftstick_y;
        double leftstick_x;
        double r;
        double robotAngle;
        double rightX;

        r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
        rightX = gamepad1.right_stick_x;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;

        robot.frontleftmotor.setPower(v1);
        robot.frontrightmotor.setPower(v2);
        robot.backleftmotor.setPower(v3);
        robot.backrightmotor.setPower(v4);

    }

}
