package org.firstinspires.ftc.teamcode.RocketLeague;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Termigators2018.TermigatorsHardware;

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
        double leftstick;
        double rightstick;
        leftstick = -gamepad1.left_stick_y * 0.55;
        rightstick = -gamepad1.right_stick_y * 0.55;

        robot.frontleftmotor.setPower(leftstick);
        robot.frontrightmotor.setPower(rightstick);
        robot.backleftmotor.setPower(leftstick);
        robot.backrightmotor.setPower(rightstick);
    }

    @Override
    public void stop(){

    }

}
