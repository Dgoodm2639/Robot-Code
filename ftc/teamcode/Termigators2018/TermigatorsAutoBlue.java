package org.firstinspires.ftc.teamcode.Termigators2018;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Daniel Goodman on 1/3/2018.
 */
@Autonomous

public class TermigatorsAutoBlue extends OpMode {

    //Extends what was defined in the hardware
    TermigatorsHardware robot = new TermigatorsHardware();

    //Code to run when the program initializes
    public void init() {

        //Initialize components defined in the hardware
        robot.init(hardwareMap);

        //Set the starting position of the glyph servos
        robot.glyphclawleft.setPosition(.935);
        robot.glyphclawright.setPosition(.075);

    }

    //Code to run when the start button is pressed
    public void start() {

        //Move the jewel arm with the color sensor down to knock over the jewel
        robot.moveJewelArm(.0475);

        //Move the robot to the right
        robot.moveRightEnc(.25, 180);

        //Stop the robot moving for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //If the color sensor detects no jewel (only for troubleshooting)
        if (robot.colorsense.red() == robot.colorsense.blue()) {
            telemetry.addData("No jewel detected", 0);
            telemetry.update();
        }

        //If the color sensor detects a blue jewel
        if (robot.colorsense.blue() > robot.colorsense.red()) {

            //Turn robot clockwise to knock off red jewel
            robot.turnClockwiseEnc(-1, -220);

            //Display message to show that the correct action is preformed
            telemetry.addData("The jewel is red", robot.colorsense.red());
            telemetry.update();

            //Move the jewel arm back up so it does not get in the way
            robot.moveJewelArm(.7);

            //Turn and move the robot into the parking goal
            robot.turnCounterclockEnc(-1, -2000);

            //Set the glyph arm positions for beginning of Teleop period
            robot.glyphclawleft.setPosition(.9);
            robot.glyphclawright.setPosition(.075);

        }
        //If the color sensor detects a red jewel
        else if (robot.colorsense.red() > robot.colorsense.blue()) {

            //Turn robot counterclockwise to knock off red jewel
            robot.turnCounterclockEnc(1, 180);

            //Display message to show that the correct action is preformed
            telemetry.addData("The jewel is blue", robot.colorsense.blue());
            telemetry.update();

            //Move the jewel arm back up so it does not get in the way
            robot.moveJewelArm(.7);

            //Turn and move the robot into the parking goal
            robot.turnCounterclockEnc(-1, -1800);

            //Set the glyph arm positions for beginning of Teleop period
            robot.glyphclawleft.setPosition(.9);
            robot.glyphclawright.setPosition(.075);

        }

    }

    //Code to run continuously
    public void loop(){
        //Nothing to run here
    }

    //Code to run after stop button is pushed
    public void stop(){
        //Nothing to run here
    }

}

