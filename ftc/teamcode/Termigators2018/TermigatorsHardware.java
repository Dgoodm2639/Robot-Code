package org.firstinspires.ftc.teamcode.Termigators2018;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Daniel Goodman on 10/24/2017.
 */

public class TermigatorsHardware extends OpMode {

    /* Chassis setup wiring
    motor controller 1 (front): motor port 1 = back right wheel
                                motor port 2 = front right wheel
    motor controller 2 (back):  motor port 1 = front left wheel
                                motor port 2 = back left wheel */

    //Declare the robot components
    public DcMotor fleft;
    public DcMotor fright;
    public DcMotor bleft;
    public DcMotor bright;
    public DcMotor vertglyphclaw;
    public Servo jewelarm;
    public Servo glyphclawleft;
    public Servo glyphclawright;
    public ColorSensor colorsense;

    //Set the power with which the glyph claws will rise or fall
    public static final double CLAW_UP_POWER     = -.5 ;
    public static final double CLAW_DOWN_POWER   = .5 ;

    //Code that will be accessed in the Teleop and Autonomous programs
    public void init(HardwareMap hardwareMap) {

        //Set the names that the hardware will be identified with in the configuration
        fleft = hardwareMap.dcMotor.get("fl");
        fright = hardwareMap.dcMotor.get("fr");
        bleft = hardwareMap.dcMotor.get("bl");
        bright = hardwareMap.dcMotor.get("br");
        vertglyphclaw = hardwareMap.dcMotor.get("vg");
        jewelarm = hardwareMap.servo.get("ja");
        glyphclawleft = hardwareMap.servo.get("cl");
        glyphclawright = hardwareMap.servo.get("cr");
        colorsense = hardwareMap.colorSensor.get("cs");

        //Set the motors initial power at 0
        fleft.setPower(0);
        fright.setPower(0);
        bleft.setPower(0);
        bright.setPower(0);
        vertglyphclaw.setPower(0);

        //Set the initial position for the servos
        glyphclawleft.setPosition(.5);
        glyphclawright.setPosition(.5);
        jewelarm.setPosition(.7);

        //Set the direction that each motor will move (reverse automatically turns all positive
        // powers negative and vice versa
        fleft.setDirection(DcMotor.Direction.REVERSE);
        fright.setDirection(DcMotor.Direction.FORWARD);
        bleft.setDirection(DcMotor.Direction.REVERSE);
        bright.setDirection(DcMotor.Direction.FORWARD);
        vertglyphclaw.setDirection(DcMotor.Direction.REVERSE);

        //Tell each motor whether it should be accessing encoder values or not
        fleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        vertglyphclaw.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    //Code to run on initialization
    public void init(){

    }

    //Code to run nonstop
    public void loop() {

    }

    //This is to be used in the autonomous
    //Can easily be called upon an implemented with any values
    //Enc in the name means that an encoder is being used
    //Drives forward the given power and distance (ticks of an encoder)
    public void driveForwardEnc(double power, int ticks){

        //Reset encoders
        fleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set target position of motors
        fleft.setTargetPosition(ticks);
        fright.setTargetPosition(ticks);
        bleft.setTargetPosition(ticks);
        bright.setTargetPosition(ticks);

        //Set motors to run to  position
        fleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bright.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //set the drive power
        driveForward(power);

        //stop motors and change modes back to run using encoders
        stopDriving();
        fleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //Turns clockwise the given power and distance
    public void turnClockwiseEnc(double power, int ticks){

        //Reset encoders
        fleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set target position of motors
        fleft.setTargetPosition(ticks);
        fright.setTargetPosition(ticks);
        bleft.setTargetPosition(ticks);
        bright.setTargetPosition(ticks);

        //Set motors to run to  position
        fleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bright.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //set the drive power
        turnClockwise(power);

        //stop motors and change modes back to run using encoders
        stopDriving();
        fleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //Turns counterclockwise the given power and distance
    public void turnCounterclockEnc(double power, int ticks){

        //Reset encoders
        fleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set target position of motors
        fleft.setTargetPosition(ticks);
        fright.setTargetPosition(ticks);
        bleft.setTargetPosition(ticks);
        bright.setTargetPosition(ticks);

        //Set motors to run to  position
        fleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bright.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //set the drive power
        turnCounterclock(power);

        //stop motors and change modes back to run using encoders
        stopDriving();
        fleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //Moves left the given power and distance
    public void moveLeftEnc(double power, int ticks){

        //Reset encoders
        fleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set target position of motors
        fleft.setTargetPosition(ticks);
        fright.setTargetPosition(ticks);
        bleft.setTargetPosition(ticks);
        bright.setTargetPosition(ticks);

        //Set motors to run to  position
        fleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bright.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //set the drive power
        moveLeft(power);

        //stop motors and change modes back to run using encoders
        stopDriving();
        fleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //Moves right a given power and distance
    public void moveRightEnc(double power, int ticks){

        //Reset encoders
        fleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set target position of motors
        fleft.setTargetPosition(ticks);
        fright.setTargetPosition(-ticks);
        bleft.setTargetPosition(-ticks);
        bright.setTargetPosition(ticks);

        //Set motors to run to  position
        fleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bright.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //set the drive power
        moveRight(power);

        //stop motors and change modes back to run using encoders
        stopDriving();
        fleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //Moves robot forward with any power
    public void driveForward(double power){
        fleft.setPower(power);
        fright.setPower(power);
        bleft.setPower(power);
        bright.setPower(power);
    }

    //Turn robot clockwise at any power
    public void turnClockwise(double power){
        fleft.setPower(power);
        fright.setPower(-power);
        bleft.setPower(power);
        bright.setPower(-power);
    }

    //Turns robot counterclockwise at any power
    public void turnCounterclock(double power){
        fleft.setPower(-power);
        fright.setPower(power);
        bleft.setPower(-power);
        bright.setPower(power);
    }

    //Moves robot left at any power
    public void moveLeft(double power){
        fleft.setPower(-power);
        fright.setPower(power);
        bleft.setPower(power);
        bright.setPower(-power);
    }

    //Moves robot right at any power
    public void moveRight (double power){
        fleft.setPower(power);
        fright.setPower(-power*.333333);
        bleft.setPower(-power);
        bright.setPower(power);
    }

    //Stops the robot from moving
    public void stopDriving(){
        driveForward(0);
    }

    //Moves the jewel arm
    public void moveJewelArm(double pos) { jewelarm.setPosition(pos);}

}
