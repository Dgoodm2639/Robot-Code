package org.firstinspires.ftc.teamcode.RocketLeague;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robotics 2 on 2/13/2018.
 */

public class TestBotHardware extends OpMode {

    public DcMotor frontleftmotor;
    public DcMotor frontrightmotor;
    public DcMotor backleftmotor;
    public DcMotor backrightmotor;


    public void init(HardwareMap hardwareMap){

        frontleftmotor = hardwareMap.dcMotor.get("frlt");
        backleftmotor = hardwareMap.dcMotor.get("balt");
        frontrightmotor = hardwareMap.dcMotor.get("frrt");
        backrightmotor = hardwareMap.dcMotor.get("bart");

        frontleftmotor.setPower(0);
        frontleftmotor.setPower(0);
        backrightmotor.setPower(0);
        backleftmotor.setPower(0);


        frontleftmotor.setDirection(DcMotor.Direction.FORWARD);
        frontrightmotor.setDirection(DcMotor.Direction.REVERSE);
        backleftmotor.setDirection(DcMotor.Direction.FORWARD);
        backrightmotor.setDirection(DcMotor.Direction.REVERSE);

        frontleftmotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }

    public void init(){

    }

    public void loop(){

    }

}
