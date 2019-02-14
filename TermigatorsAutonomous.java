package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;
import java.util.Locale;

import static android.os.SystemClock.sleep;

@Autonomous

public class TermigatorsAutonomous extends LinearOpMode {

    TermigatorsHardware robot = new TermigatorsHardware();
    private ElapsedTime runtime = new ElapsedTime();

    public static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    public static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    public static final String VUFORIA_KEY = "AZIRgYb/////AAABmRokpzO4lUh/uk8GzfuxDgoPRCSSshd06gO7cDVZl/EZ/TG3IiV6Pq23JNj/xwZgtwIvIQg2+CcrAdWvaQ95t6zSeDrVoI7nNeOYrR69YgPgMPb3DVIA9cXFNtrqjRy8fzNLnuBgsQNVOV+aJyiBVgyeAjQPcxAFDBK2WvA+g2r1Ixdj9G+ZrPSU5GjIn9eGBnvDZul72lN8jjc1OVCZeAuehLqNJKBf+xzG4NcYNqSFKCvnhlmmJZZCR5zHF8nfIKtIq0vYlVtLQJRyR0h4sSSjj5nvMjzwXrNMdKeeS/SjZZ/2Dtwink1mtDwAPyO69hLCmrAEdVXaM4vWWVh4rJ3uIPGE4xY1wzCzc7lS+eYn";
    public VuforiaLocalizer vuforia;
    public TFObjectDetector tfod;


    private int goldMineralX = -1;

    @Override
    public void runOpMode() {


        //initialize information that comes from hardware

            robot.init(hardwareMap);

            //initVuforia();

            if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
                //initTfod();
            } else {
                telemetry.addData("Sorry!", "This device is not compatible with TFOD");
            }

            robot.markerLeft.setPosition(0.77);
            robot.markerRight.setPosition(0.4);

        telemetry.addData("It workin'", "1");
        telemetry.update();

            robot.stopDriving();

        waitForStart();

        if (opModeIsActive()) {

            robot.driveForwardEnc(0.25, -400);
            robot.moveRightEnc(0.25, 800);
            if (tfod != null) {
                tfod.activate();
            } else {
                telemetry.addData("Oh no! sUm TiNg wOnG!", "1");
                telemetry.update();
            }
            /*while (goldMineralX >= 400 || goldMineralX <= 200) {
                robot.moveLeft(0.1);
                if (tfod != null) {
                    // getUpdatedRecognitions() will return null if no new information is available since
                    // the last time that call was made.
                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null) {
                        telemetry.addData("# Object Detected", updatedRecognitions.size());
                        goldMineralX = -1;
                        for (Recognition recognition : updatedRecognitions) {
                            if (recognition.getLabel().equals(LABEL_GOLD_MINERAL)) {
                                goldMineralX = (int) recognition.getLeft();
                            }
                        }
                    }
                } else {
                    telemetry.addData("Oh no! sUm TiNg wOnG!", "2");
                    telemetry.update();
                }
                telemetry.addData("Rubik's cube lookinass found", "False");
                telemetry.update();
                //sleep(1000);
            }

            telemetry.addData("Rubik's cube lookinass found", "True");
            telemetry.update();

*/
            robot.driveForwardEnc(0.25, -800);

            //crash

            robot.driveForwardEnc(0.25, 400);

            telemetry.addData("The End", "True");
            telemetry.update();


        /*while(robot.rangeSensorFar.getDistance(DistanceUnit.CM) > 20) {
            robot.moveLeft(0.5);
        }

        robot.turnClockwiseEnc(0.1, 360);

        robot.driveForwardEnc(0.25, 720);

        robot.markerLeft.setPosition(0.36);
        robot.markerRight.setPosition(0.78);

        sleep(5000);

        robot.markerLeft.setPosition(0.77);
        robot.markerRight.setPosition(0.4);*/





    /*@Override
    public void loop() {
        telemetry.addData("You're in the loop-de-loop! ", true);
        telemetry.update();
    }*/
        }


    }

//    public void initVuforia() {
//        /*
//         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
//         */
//        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
//
//        parameters.vuforiaLicenseKey = VUFORIA_KEY;
//        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
//
//        //  Instantiate the Vuforia engine
//        vuforia = ClassFactory.getInstance().createVuforia(parameters);
//
//        robot.init(hardwareMap);
//        // Loading trackables is not necessary for the Tensor Flow Object Detection engine.
//    }
//
//    /*
//     * Initialize the Tensor Flow Object Detection engine.
//     */
//    public void initTfod() {
//        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
//                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
//        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
//        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_GOLD_MINERAL);
//        tfodParameters.minimumConfidence = 0.40; //set the minimum confidnce for detection
//    }

}
