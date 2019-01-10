package org.firstinspires.ftc.teamcode.Termigators2018_2019;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous

public class TermigatorsAutonomous extends OpMode{

    TermigatorsHardware robot = new TermigatorsHardware();

    public void init()
    {

        robot.init(hardwareMap);

    }

    public void start() {

        /*robot.driveForwardEnc(-50, 1440/4);
        robot.clrsensorservo.setPosition(.15);
        if(robot.ColorSense.red() > 25){
            telemetry.addData("ColorSenorValue", robot.ColorSense.red());
            telemetry.update();
            robot.driveForwardEnc(50, 1440/8);
            robot.driveForwardEnc(-50, 1440/8);
            //telemetry.addData("Step Two:", 1);
            //telemetry.update();
        } else {
            robot.moveLeftEnc(50, 1440 * 5 / 4);
            if (robot.ColorSense.red() > 25) {
                robot.driveForwardEnc(50, 1440 / 8);
                robot.driveForwardEnc(-50, 1440 / 8);
                telemetry.addData("Step Three:", 1);
                telemetry.update();
            } else {
                robot.moveRightEnc(50, 1440 * 5 / 2);
                robot.driveForwardEnc(50, 1440 / 8);
                robot.driveForwardEnc(-50, 1440 / 8);
                telemetry.addData("Step Four:", 1);
                telemetry.update();
                )}*/

        robot.moveLeftEnc(50, 1440);
        robot.moveRightEnc(50, 1440);




    }

    @Override
    public void loop() {

    }


}
