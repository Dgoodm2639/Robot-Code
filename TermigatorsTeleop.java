package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Robotics 2 on 10/15/2018.
 */
@TeleOp
public class TermigatorsTeleop extends OpMode{

    TermigatorsHardware robot = new TermigatorsHardware();

    //initialize information that comes from hardware
    @Override
    public void init() {

        robot.init(hardwareMap);

        //robot.clrsensorservo.setPosition(robot.clrSensorServoStartingPos);

        //robot.clrSensorServoCurrentPos = 1;

    }

    @Override
    public void loop() {

        //initialize variables
        double r;
        double robotAngle;
        //double rightX;
        double climberliftpower;
        double partArmMotorPower;
        double clrSensorServoMoveParameter;

        //used for pivoting
        float v5 = -gamepad1.right_trigger;
        float v6 = -gamepad1.left_trigger;

        //set up values for 360 degree motion
        r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
        final double v1 = r * Math.cos(robotAngle) ;//+ rightX;
        final double v2 = r * Math.sin(robotAngle) ;//- rightX;
        final double v3 = r * Math.sin(robotAngle) ;//+ rightX;
        final double v4 = r * Math.cos(robotAngle) ;//- rightX;

        //send motors the values from above
        robot.frontleftmotor.setPower(v2);
        robot.frontrightmotor.setPower(v1);
        robot.backleftmotor.setPower(v4);
        robot.backrightmotor.setPower(v3);

        //A botton used to close the climber
        if(gamepad2.a == true){

            robot.climberStopper.setPosition(0);
        }

        //B button used to open the climber
        if(gamepad2.b == true){

            robot.climberStopper.setPosition(0.4);
        }


        if(gamepad1.b == true){ //marker servos down

            robot.markerLeft.setPosition(0.36);
            robot.markerRight.setPosition(0.78);

        }
        if(gamepad1.a == true){ //marker servos up

            robot.markerLeft.setPosition(0.77); //gucci
            robot.markerRight.setPosition(0.4); //gucci
        }

        //right trigger used to pivot clockwise
        if(gamepad1.right_trigger > 0){

            robot.frontrightmotor.setPower(-v5 * 0.5); //Aidan added the * 0.5 because the turning was a little bit fast
            robot.frontleftmotor.setPower(v5 * 0.5);
            robot.backrightmotor.setPower(-v5 * 0.5);
            robot.backleftmotor.setPower(v5 * 0.5);

        }
        //left trigger ued to pivot counterclockwise
        if(gamepad1.left_trigger > 0){

            robot.frontrightmotor.setPower(v6 * 0.5);
            robot.frontleftmotor.setPower(-v6 * 0.5);
            robot.backrightmotor.setPower(v6 * 0.5);
            robot.backleftmotor.setPower(-v6 * 0.5);

        }

        //use right stick to lift and lower robot
        climberliftpower = -gamepad1.right_stick_y/2;
        if(gamepad1.right_stick_y > .25 || gamepad1.right_stick_y < -.25){
            robot.climbermotor.setPower(climberliftpower);
        } else {
            robot.climbermotor.setPower(0);
        }

        //set power used to collect particles
        partArmMotorPower = .8;

        //left bumper and right bumper used to collect and deposit particles
        if(gamepad2.left_bumper){
            robot.particleArmMotorCollect.setPower(partArmMotorPower);
        }
        else if(gamepad2.right_bumper) {
            robot.particleArmMotorCollect.setPower(-partArmMotorPower);
        }
        else {
            robot.particleArmMotorCollect.setPower(0);
        }

        //left stick used to collect and deposit particles
        if(gamepad2.left_stick_y > .5)
        {
            robot.particleArmMotorCollect.setPower(.5);
        }
        else if(gamepad2.left_stick_y < -.5)
        {
            robot.particleArmMotorCollect.setPower(-.5);
        }
        else
        {
            robot.particleArmMotorCollect.setPower(0);
        }

        //right stick used to move collector up and down
        if(gamepad2.right_stick_y > .5)
        {
            robot.particleArmLiftLeft.setPower(.35);
            robot.particleArmLiftRight.setPower(.35);
        }
        else if (gamepad2.right_stick_y < -.5)
        {
            robot.particleArmLiftLeft.setPower(-.35);
            robot.particleArmLiftRight.setPower(-.35);
        }
        else
        {
            robot.particleArmLiftLeft.setPower(0);
            robot.particleArmLiftRight.setPower(0);
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

        //telemetry data
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
