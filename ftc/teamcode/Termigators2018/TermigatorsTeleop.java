package org.firstinspires.ftc.teamcode.Termigators2018;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Daniel Goodman on 1/16/2018.
 */

@TeleOp
public class TermigatorsTeleop extends OpMode {

    //Extends what was defined in the hardware
    TermigatorsHardware robot = new TermigatorsHardware();

    //Sets te rate at which the glyph claws will move
    final double MOVE = .0375;

    //States the starting position of te glyph claws
    double GlyphClawPos1 = 0.6;
    double GlyphClawPos2 = 0.525;

    //States the starting position of the jewel arm
    double JewelArmPos = 0.7;

    //Code that will be run when the code is initialized
    @Override
    public void init(){

        //Initialize components defined in the hardware
        robot.init(hardwareMap);

    }

    //Code to be run when the start button is pushed
    @Override
    public void start(){

        //Starting position is set for te jewel arm and glyph claws
        robot.jewelarm.setPosition(.7);
        robot.glyphclawright.setPosition(.6);
        robot.glyphclawleft.setPosition(.525);

    }

    public double servoMin(double pos) {
        //sets the MINIMUM end of the servo range ONLY
        if(pos <= 0.0)
            return 0.0;
        return pos;
    }
    public double servoMax(double pos) {
        //sets the MAXIMUM end of the servo range ONLY
        if(pos >= 1.0)
            return 1.0;
        return pos;
    }
    public double clip(double pos) {
        //checks both ends of servo range this should be the used method.
        return servoMax(servoMin(pos));
    }

    //Code to be run continuously after start
    @Override
    public void loop() {

        double leftstick;
        //Multiply the left stick x values by .35 to lessen the power
        //Invert left stick x value because joy sticks work opposite to to how you push it
        leftstick = -gamepad1.left_stick_x * 0.35;

        //set left stick values to control turning
        robot.fleft.setPower(-leftstick);
        robot.fright.setPower(leftstick);
        robot.bleft.setPower(-leftstick);
        robot.bright.setPower(leftstick);

        //mechanum wheel movements below
        while (gamepad1.x && gamepad1.y){
            //Strafe bot forward and to the left
            robot.fleft.setPower(0);
            robot.fright.setPower(.45);
            robot.bleft.setPower(.45);
            robot.bright.setPower(0);
        }
        while (gamepad1.b && gamepad1.y){
            //Strafe bot foreward andto the right
            robot.fleft.setPower(.45);
            robot.fright.setPower(0);
            robot.bleft.setPower(0);
            robot.bright.setPower(.45);
        }
        while (gamepad1.b && gamepad1.a){
            //Strafe bot backwards and to the right
            robot.fleft.setPower(0);
            robot.fright.setPower(-.45);
            robot.bleft.setPower(-.45);
            robot.bright.setPower(0);
        }
        while(gamepad1.x && gamepad1.a){
            //Strafe bot backwards and to the left
            robot.fleft.setPower(-.45);
            robot.fright.setPower(0);
            robot.bleft.setPower(0);
            robot.bright.setPower(-.45);
        }
        while (gamepad1.dpad_up){
            //Strafe bot foreward
            robot.fleft.setPower(.75);
            robot.fright.setPower(.75);
            robot.bleft.setPower(.75);
            robot.bright.setPower(.75);
        }
        while(gamepad1.dpad_left) {
            //move bot left
            robot.fleft.setPower(-.45);
            robot.fright.setPower(.45);
            robot.bleft.setPower(.45);
            robot.bright.setPower(-.45);
        }
        while (gamepad1.dpad_right){
            // move bot right
            robot.fleft.setPower(.45);
            robot.fright.setPower(-.45);
            robot.bleft.setPower(-.45);
            robot.bright.setPower(.45);
        }
        while (gamepad1.dpad_down){
            //move bot backward
            robot.fleft.setPower(-.75);
            robot.fright.setPower(-.75);
            robot.bleft.setPower(-.75);
            robot.bright.setPower(-.75);
        }
        while (gamepad1.y && !gamepad1.x && !gamepad1.b){
            //move bot foreward
            robot.fleft.setPower(.75);
            robot.fright.setPower(.75);
            robot.bleft.setPower(.75);
            robot.bright.setPower(.75);
        }
        while(gamepad1.x && !gamepad1.a && !gamepad1.y) {
            //move bot left
            robot.fleft.setPower(-.45);
            robot.fright.setPower(.45);
            robot.bleft.setPower(.45);
            robot.bright.setPower(-.45);
        }
        while (gamepad1.b && !gamepad1.y && !gamepad1.a){
            // move bot right
            robot.fleft.setPower(.45);
            robot.fright.setPower(-.45);
            robot.bleft.setPower(-.45);
            robot.bright.setPower(.45);
        }
        while (gamepad1.a && !gamepad1.x && !gamepad1.b){
            //move bot backward
            robot.fleft.setPower(-.75);
            robot.fright.setPower(-.75);
            robot.bleft.setPower(-.75);
            robot.bright.setPower(-.75);
        }

        //move the  glyph claw up or down
        if (gamepad2.dpad_up)
            robot.vertglyphclaw.setPower(robot.CLAW_UP_POWER);
        else if (gamepad2.dpad_down)
            robot.vertglyphclaw.setPower(robot.CLAW_DOWN_POWER);
        else
            robot.vertglyphclaw.setPower(0);

        //Reset the glyph claw positions if A button is pressed
        if (gamepad2.a){

            GlyphClawPos1 = .6;
            GlyphClawPos2 = .525;

        }

        //Use the right trigger and right button to control right glyph claw
        if (gamepad2.right_trigger > .5 && GlyphClawPos1 <= 1) {
            GlyphClawPos1 -= MOVE;
            GlyphClawPos1 = clip(GlyphClawPos1);
        }
        else if (gamepad2.right_bumper && GlyphClawPos1 >= 0) {
            GlyphClawPos1 += MOVE;
            GlyphClawPos1 = clip(GlyphClawPos1);
        }
        //Sets new glyph claw position
        robot.glyphclawright.setPosition(GlyphClawPos1);

        //Use the left trigger and left button to control the left glyph claw
        if (gamepad2.right_trigger > .5 && GlyphClawPos2 >= 0) {
            GlyphClawPos2 += MOVE;
            GlyphClawPos2 = clip(GlyphClawPos2);
        }
        else if (gamepad2.right_bumper && GlyphClawPos2 <= 1) {
            GlyphClawPos2 -= MOVE;
            GlyphClawPos2 = clip(GlyphClawPos2);
        }
        //Sets new glyph claw position
        robot.glyphclawleft.setPosition(GlyphClawPos2);

        //Show the glyph claw positions on the driver phones
        telemetry.addData("Glyph Claw Position Left", GlyphClawPos2);
        telemetry.addData("Glyph Claw Position Right", GlyphClawPos1);
        //Update the telemetry
        telemetry.update();

    }

}
