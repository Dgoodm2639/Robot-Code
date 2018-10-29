package org.firstinspires.ftc.teamcode.Termigators2018_2019;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robotics 2 on 10/15/2018.
 */

public class TermigatorsHardware extends OpMode {

    public DcMotor backrightmotor;
    public DcMotor backleftmotor;
    public DcMotor frontrightmotor;
    public DcMotor frontleftmotor;

    public void init(HardwareMap hardwareMap) {
        frontrightmotor = hardwareMap.dcMotor.get("fr");
        frontleftmotor = hardwareMap.dcMotor.get("fl");
        backrightmotor = hardwareMap.dcMotor.get("br");
        backleftmotor = hardwareMap.dcMotor.get("bl");

        backrightmotor.setPower(0);
        backleftmotor.setPower(0);
        frontleftmotor.setPower(0);
        frontrightmotor.setPower(0);


        frontrightmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontleftmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backleftmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backrightmotor.setDirection(DcMotorSimple.Direction.FORWARD);

        frontleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



    }

    public void init() {

    }

    public void loop() {

    }
}

// Vuforia Key: ATyodfX/////AAABmYI5C3jMqUFjlJKjjNCJUck829Nv0kQB6RURZJyoxg+GHoThNC2uT2GW+vPFdmRUR+XVUPT5ZnX3SScwWFLGSyf3jS72VWnPipkS2zIvatT0LG8SlioUYxVKGsBu2U1sa5Mky1KyGR399Ocn9jhf2XwnecXivrTeMRxT081d7vRWyu0ZoKqjvkxHCGZiebi2ZHVL1B3n1fLpUkHE2an08NOK8du+zIbccZZWTul+TmO0dcBp/G3wCsmNBZKvStyrMsNBUxwW3V3Z/j/uDErAbLgAbCBZsXiAR7xF3+DPMBznoGKiZejqMwrfx/dA7QEHwN6LY/RbZF+YICkdAA7vuq6dJYntn4UzvLafoBhjLA7P