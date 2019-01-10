package org.firstinspires.ftc.teamcode.Termigators2018_2019;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Robotics 2 on 10/15/2018.
 */
@TeleOp
public class TermigatorsTeleOp extends OpMode{

    TermigatorsHardware robot = new TermigatorsHardware();

    @Override
    public void init() {

        robot.init(hardwareMap);

        //robot.clrsensorservo.setPosition(robot.clrSensorServoStartingPos);

        robot.clrSensorServoCurrentPos = 1;

    }

    @Override
    public void loop() {

        double r;
        double robotAngle;
        //double rightX;
        double climberliftpower;
        double partArmMotorPower;
        double clrSensorServoMoveParameter;

        float v5 = -gamepad1.right_trigger;
        float v6 = -gamepad1.left_trigger;

        //robot.clrSensorServoCurrentPos = 1;

        r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
        //rightX = gamepad1.right_stick_x;
        final double v1 = r * Math.cos(robotAngle) ;//+ rightX;
        final double v2 = r * Math.sin(robotAngle) ;//- rightX;
        final double v3 = r * Math.sin(robotAngle) ;//+ rightX;
        final double v4 = r * Math.cos(robotAngle) ;//- rightX;

        robot.frontleftmotor.setPower(v3);
        robot.frontrightmotor.setPower(v4);
        robot.backleftmotor.setPower(v1);
        robot.backrightmotor.setPower(v2);

        if(gamepad1.right_trigger > 0){

            robot.frontrightmotor.setPower(-v5);
            robot.frontleftmotor.setPower(v5);
            robot.backrightmotor.setPower(-v5);
            robot.backleftmotor.setPower(v5);

        }
        if(gamepad1.left_trigger > 0){

            robot.frontrightmotor.setPower(v6);
            robot.frontleftmotor.setPower(-v6);
            robot.backrightmotor.setPower(v6);
            robot.backleftmotor.setPower(-v6);

        }

        climberliftpower = -gamepad1.right_stick_y/2;
        if(gamepad1.right_stick_y > .25 || gamepad1.right_stick_y < -.25){
            robot.climbermotor.setPower(climberliftpower);
        } else {
            robot.climbermotor.setPower(0);
        }

        partArmMotorPower = .2;

        if(gamepad2.left_bumper){
            robot.particleArmMotorCollect.setPower(partArmMotorPower);
        }
        else if(gamepad2.right_bumper) {
            robot.particleArmMotorCollect.setPower(-partArmMotorPower);
        }
        else {
            robot.particleArmMotorCollect.setPower(0);
        }



        clrSensorServoMoveParameter = .05;

        //if(robot.clrsensorservo.getPosition() <=0)
        //{
          //  robot.clrsensorservo.setPosition(1);
        //}

        /*if(gamepad2.y){
            robot.clrSensorServoCurrentPos = robot.clrSensorServoCurrentPos - clrSensorServoMoveParameter;
            robot.clrsensorservo.setPosition(robot.clrSensorServoCurrentPos);
        } else if (gamepad2.a) {
            robot.clrSensorServoCurrentPos = robot.clrSensorServoCurrentPos + clrSensorServoMoveParameter;
            robot.clrsensorservo.setPosition(robot.clrSensorServoCurrentPos);
        } //else {
        //    robot.clrsensorservo.setPosition(clrSensorServoCurrentPos);
        //}*/

        telemetry.addData("Left Trigger", gamepad1.left_trigger);
        telemetry.addData("Right Trigger", gamepad1.right_trigger);
        telemetry.addData("PartArmPower", robot.particleArmMotorCollect.getPower());
        //telemetry.addData("Color Sensor Servo Pos", robot.clrsensorservo.getPosition());
        //telemetry.addData("Color Sensor Value Red", robot.ColorSense.red());
        //telemetry.addData("Color Sensor Value Blue", robot.ColorSense.blue());
        //telemetry.addData("Color Sensor Value Green", robot.ColorSense.green());
        telemetry.update();


    }

}