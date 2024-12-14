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

    Servo rightServoDomain;
    Servo leftServoDomain;

    DcMotor upLeft;
    DcMotor upRight;

    //Declaration of ticks for hanging
    double hangTicks = 5281.1;
    double hangTarget;


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
        upSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightServoDomain = hardwareMap.servo.get("rightServoDomain");
        leftServoDomain = hardwareMap.servo.get("leftServoDomain");

        waitForStart();
        rightServoDomain.setPosition(0.3);
        leftServoDomain.setPosition(0.7);
        //Change numbers
        drive(1, 0, -535, 0);
        drive(1, 1070, 0, 0);
        full(0.2);
        sleep(500);
        drive(1,310,0,0);
        sleep(200);

        full(0.1);
        sleep(700);
        rightServoDomain.setPosition(0);
        leftServoDomain.setPosition(1);

        drive(1, -1200, 0, 0);
        drive(1, 0, 2493, 0);
        sleep(100);
    }

    public void drive(double power, int forward, int strafe, int turn) {
        //Set modes for motors
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set modes for motors



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
        hangTarget = hangTicks * turnage;
        upSlider.setTargetPosition((int) hangTarget);
        upSlider.setPower(.45);
        upSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    /*public void full2(double turnage) {
        hangTarget = hangTicks * turnage;
        upRight.setTargetPosition((int) hangTarget);
        upRight.setPower(.75);
        upRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }*/

}

