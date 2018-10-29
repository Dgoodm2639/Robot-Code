package org.firstinspires.ftc.teamcode.NewPhoneCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Robotics 2 on 2/13/2018.
 */

@TeleOp
public class TestBotTele extends OpMode {

    TestBotHardware robot = new TestBotHardware();

    public void init(){

        robot.init(hardwareMap);

    }

    @Override
    public void init_loop(){

    }

    @Override
    public void start(){


    }

    @Override
    public void loop(){
        double leftstick_y;
        //double rightstick_y;
        /*double leftstick_x;
        //double rightstick_x;
        double r;
        double robotAngle;
        double rightX;*/

        leftstick_y = -gamepad1.left_stick_y * 0.55;
        //rightstick_x = -gamepad1.right_stick_y * 0.55;
        /*leftstick_x = -gamepad1.left_stick_x * 0.55;
        //rightstick_y = -gamepad1.right_stick_y * 0.55;

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

        /*robot.frontleftmotor.setPower(leftstick);
        robot.frontrightmotor.setPower(rightstick);
        robot.backleftmotor.setPower(leftstick);
        robot.backrightmotor.setPower(rightstick);*/

        //backrightmotor.setPower(leftstick_y);
    }

    @Override
    public void stop(){

    }

}
