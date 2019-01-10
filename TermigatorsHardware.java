package org.firstinspires.ftc.teamcode.Termigators2018_2019;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robotics 2 on 10/15/2018.
 */

public class TermigatorsHardware extends OpMode {

    public DcMotor backrightmotor;
    public DcMotor backleftmotor;
    public DcMotor frontrightmotor;
    public DcMotor frontleftmotor;
    public DcMotor climbermotor;
    public DcMotor particleArmMotorCollect;
    public DcMotor particleArmLiftLeft;
    public DcMotor particleArmLiftRight;
    //public Servo clrsensorservo;
    //public Servo partArmInside;
    //public Servo partArmOutside;
    //public ColorSensor ColorSense;
    //public GyroSensor GyroSense;

    double clrSensorServoStartingPos;
    double clrSensorServoCurrentPos;

    public void init(HardwareMap hardwareMap) {
        frontrightmotor = hardwareMap.dcMotor.get("fr");
        frontleftmotor = hardwareMap.dcMotor.get("fl");
        backrightmotor = hardwareMap.dcMotor.get("br");
        backleftmotor = hardwareMap.dcMotor.get("bl");
        climbermotor = hardwareMap.dcMotor.get("cm");
        particleArmMotorCollect = hardwareMap.dcMotor.get("pam");
        particleArmLiftLeft = hardwareMap.dcMotor.get("pall");
        particleArmLiftRight = hardwareMap.dcMotor.get("palr");
        //clrsensorservo = hardwareMap.servo.get("css");

        //partArmInside = hardwareMap.servo.get("pai");
        //partArmOutside = hardwareMap.servo.get("pao");
        //ColorSense = hardwareMap.colorSensor.get("cs");
        //GyroSense = hardwareMap.gyroSensor.get("gs");

        backrightmotor.setPower(0);
        backleftmotor.setPower(0);
        frontleftmotor.setPower(0);
        frontrightmotor.setPower(0);
        climbermotor.setPower(0);
        particleArmLiftLeft.setPower(0);
        particleArmLiftRight.setPower(0);

        //clrSensorServoStartingPos = 1;
        //clrsensorservo.setPosition(clrSensorServoStartingPos);


        frontrightmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontleftmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backleftmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backrightmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        climbermotor.setDirection(DcMotorSimple.Direction.FORWARD);
        particleArmMotorCollect.setDirection(DcMotorSimple.Direction.REVERSE);
        particleArmLiftLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        particleArmLiftRight.setDirection(DcMotorSimple.Direction.REVERSE);

        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        climbermotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        particleArmMotorCollect.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        particleArmLiftLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        particleArmLiftRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



    }

    public void init() {

    }

    public void loop() {

    }

    //This is to be used in the autonomous
    //Can easily be called upon an implemented with any values
    //Enc in the name means that an encoder is being used
    //Drives forward the given power and distance (ticks of an encoder)
    public void driveForwardEnc(double power, int ticks){

        //Reset encoders
        frontleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set target position of motors
        frontleftmotor.setTargetPosition(ticks);
        frontrightmotor.setTargetPosition(ticks);
        backleftmotor.setTargetPosition(ticks);
        backrightmotor.setTargetPosition(ticks);

        //Set motors to run to  position
        frontleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //set the drive power
        driveForward(power);

        while(frontleftmotor.isBusy() && frontrightmotor.isBusy() && backleftmotor.isBusy() && backrightmotor.isBusy()) {

        }

        stopDriving();

        //stop motors and change modes back to run using encoders
        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }

    //Turns clockwise the given power and distance
    public void turnClockwiseEnc(double power, int ticks){

        //Reset encoders
        frontleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set target position of motors
        frontleftmotor.setTargetPosition(ticks);
        frontrightmotor.setTargetPosition(ticks);
        backleftmotor.setTargetPosition(ticks);
        backrightmotor.setTargetPosition(ticks);

        //Set motors to run to  position
        frontleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //set the drive power
        turnClockwise(power);

        while(frontleftmotor.isBusy() && frontrightmotor.isBusy() && backleftmotor.isBusy() && backrightmotor.isBusy()) {

        }

        stopDriving();

        //stop motors and change modes back to run using encoders
        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    //Turns counterclockwise the given power and distance
    public void turnCounterclockEnc(double power, int ticks){

        //Reset encoders
        frontleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set target position of motors
        frontleftmotor.setTargetPosition(ticks);
        frontrightmotor.setTargetPosition(ticks);
        backleftmotor.setTargetPosition(ticks);
        backrightmotor.setTargetPosition(ticks);

        //Set motors to run to  position
        frontleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //set the drive power
        turnCounterclock(power);

        while(frontleftmotor.isBusy() && frontrightmotor.isBusy() && backleftmotor.isBusy() && backrightmotor.isBusy()) {

        }

        stopDriving();

        //stop motors and change modes back to run using encoders
        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //Moves left the given power and distance
    public void moveLeftEnc(double power, int ticks) {

        //Reset encoders
        frontleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set target position of motors
        frontleftmotor.setTargetPosition(ticks);
        frontrightmotor.setTargetPosition(ticks);
        backleftmotor.setTargetPosition(ticks);
        backrightmotor.setTargetPosition(ticks);

        //Set motors to run to  position
        frontleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //set the drive power
        moveLeft(power);

        while(frontleftmotor.isBusy() && frontrightmotor.isBusy() && backleftmotor.isBusy() && backrightmotor.isBusy()) {

        }

        stopDriving();

        //stop motors and change modes back to run using encoders
        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //Moves right a given power and distance
    public void moveRightEnc(double power, int ticks){

        //Reset encoders
        frontleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set target position of motors
        frontleftmotor.setTargetPosition(ticks);
        frontrightmotor.setTargetPosition(-ticks);
        backleftmotor.setTargetPosition(-ticks);
        backrightmotor.setTargetPosition(ticks);

        //Set motors to run to  position
        frontleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //set the drive power
        moveRight(power);

        while(frontleftmotor.isBusy() && frontrightmotor.isBusy() && backleftmotor.isBusy() && backrightmotor.isBusy()) {

        }

        //stop motors and change modes back to run using encoders
        stopDriving();
        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //Moves robot forward with any power
    public void driveForward(double power){
        frontleftmotor.setPower(power);
        frontrightmotor.setPower(power);
        backleftmotor.setPower(power);
        backrightmotor.setPower(power);
    }

    //Turn robot clockwise at any power
    public void turnClockwise(double power){
        frontleftmotor.setPower(power);
        frontrightmotor.setPower(-power);
        backleftmotor.setPower(power);
        backrightmotor.setPower(-power);
    }

    //Turns robot counterclockwise at any power
    public void turnCounterclock(double power){
        frontleftmotor.setPower(-power);
        frontrightmotor.setPower(power);
        backleftmotor.setPower(-power);
        backrightmotor.setPower(power);
    }

    //Moves robot left at any power
    public void moveLeft(double power){
        frontleftmotor.setPower(power); //-
        frontrightmotor.setPower(power);
        backleftmotor.setPower(power);
        backrightmotor.setPower(power);//-
    }

    //Moves robot right at any power
    public void moveRight (double power){
        frontleftmotor.setPower(power);
        frontrightmotor.setPower(power);//-
        backleftmotor.setPower(power);//-
        backrightmotor.setPower(power);
    }

    //Stops the robot from moving
    public void stopDriving(){
        driveForward(0);
    }




}

// Vuforia Key: ATyodfX/////AAABmYI5C3jMqUFjlJKjjNCJUck829Nv0kQB6RURZJyoxg+GHoThNC2uT2GW+vPFdmRUR+XVUPT5ZnX3SScwWFLGSyf3jS72VWnPipkS2zIvatT0LG8SlioUYxVKGsBu2U1sa5Mky1KyGR399Ocn9jhf2XwnecXivrTeMRxT081d7vRWyu0ZoKqjvkxHCGZiebi2ZHVL1B3n1fLpUkHE2an08NOK8du+zIbccZZWTul+TmO0dcBp/G3wCsmNBZKvStyrMsNBUxwW3V3Z/j/uDErAbLgAbCBZsXiAR7xF3+DPMBznoGKiZejqMwrfx/dA7QEHwN6LY/RbZF+YICkdAA7vuq6dJYntn4UzvLafoBhjLA7P