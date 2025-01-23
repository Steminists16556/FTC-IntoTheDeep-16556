package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class autoRightSide extends LinearOpMode {
    DcMotor backLeft;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor frontRight;

    DcMotor upSlider;
    //DcMotor extendSlider;

    Servo rightServoDomain;
    Servo leftServoDomain;

    Servo rightServoRange;
    Servo leftServoRange;

    DcMotor upLeft;
    DcMotor upRight;

    //Declaration of ticks for hanging
    double liftTicks = 5281.1;
    double liftTarget;

    @Override
    public void runOpMode() {
        // Hardware mapping for chassis motors
        backLeft = hardwareMap.dcMotor.get("backLeft");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        frontRight = hardwareMap.dcMotor.get("frontRight");

        //Hardware mapping for hanging motors
        upRight = hardwareMap.dcMotor.get("upRight");
        upLeft = hardwareMap.dcMotor.get("upLeft");

        //Hardware mapping for lifting slider
        upSlider = hardwareMap.dcMotor.get("upSlider");

        //Hardware mapping for extending slider
        /*extendSlider = hardwareMap.dcMotor.get("extendSlider");
        extendSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); */

        //Hardware mapping for servos to open & close claw
        rightServoDomain = hardwareMap.servo.get("rightServoDomain");
        leftServoDomain = hardwareMap.servo.get("leftServoDomain");

        //Hardware mapping for servos to raise & lower claw
        rightServoRange = hardwareMap.servo.get("rightServoRange");
        leftServoRange = hardwareMap.servo.get("leftServoRange");

        // Set zero power behaviour



        waitForStart();
        //Set claw to starting position
        //Closed
        rightServoDomain.setPosition(0.5);
        leftServoDomain.setPosition(0.5);

        //Strafe robot to the right
        drive(1, 0, -535, 0);

        //Move robot forward
        drive(1, 1100, 0, 0);

        //Raise slider
        full(0.2);
        sleep(500);

        //Lower claw to set the angle straight
        rightServoRange.setPosition(0.3);
        leftServoRange.setPosition(0.7);
        sleep(500);


        //Move robot forward to reach low chamber
        drive(1,350,0,0);
        sleep(500);

        //Lower slider
        full(-0.03);
        sleep(500);

        //Raise Claw - Set claw straight
        rightServoDomain.setPosition(0.7);
        leftServoDomain.setPosition(0.3);
        sleep(500);

        drive(1, -1600, 0, 0);
        drive(1, 0, 2500, 0);
        sleep(100);
    }

    public void drive(double power, int forward, int strafe, int turn) {
        //Set modes for motors
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        /*backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);/*

        //Set modes for motors
        upSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        upSlider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //If needed change set power number
        backLeft.setPower(power * .5);
        frontLeft.setPower(power * .5);
        backRight.setPower(power * .5);
        frontRight.setPower(power * .5);
        /*upSlider.setPower(power * .6);
        upLeft.setPower(power * .6);
        upRight.setPower(power * .6);*/

        backRight.setTargetPosition(forward + strafe - turn);
        frontRight.setTargetPosition(forward - strafe - turn);
        backLeft.setTargetPosition(-forward + strafe - turn);
        frontLeft.setTargetPosition(-forward - strafe - turn);

        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       // upSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (backLeft.isBusy() && frontLeft.isBusy() && frontRight.isBusy() && backRight.isBusy()) {

        }

        sleep(200);
    }

    public void full(double turnage) {
        liftTarget = liftTicks * turnage;
        upSlider.setTargetPosition((int) liftTarget);
        upSlider.setPower(.45);
        upSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

}

