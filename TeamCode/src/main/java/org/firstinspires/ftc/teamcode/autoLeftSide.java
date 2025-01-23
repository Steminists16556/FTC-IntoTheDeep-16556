package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class autoLeftSide extends LinearOpMode {
    DcMotor backLeft;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor frontRight;

    Servo rightServoDomain;
    Servo leftServoDomain;

    @Override
    public void runOpMode() {
        backLeft = hardwareMap.dcMotor.get("backLeft");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        frontRight = hardwareMap.dcMotor.get("frontRight");

        //Hardware mapping for lifting slider
        //upSlider = hardwareMap.dcMotor.get("upSlider");
        //upSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightServoDomain = hardwareMap.servo.get("rightServoDomain");
        leftServoDomain = hardwareMap.servo.get("leftServoDomain");


        waitForStart();
        rightServoDomain.setPosition(0.5);
        leftServoDomain.setPosition(0.5);
        //Change numbers as needed
        drive(1, 0, 0, 0);
        //sleep(100);
        //Edit turn
        drive(1, 0, -1000, 0);
        //sleep(100);
        /*
        drive(1, 0, 0, 350);
        //sleep(100);
        drive(1, 10, 0, 0);
        //sleep(100);
        rightServoDomain.setPosition(0);
        leftServoDomain.setPosition(1);
        //sleep(100);
        rightServoDomain.setPosition(0.3);
        leftServoDomain.setPosition(0.7);
        drive(1, 150, 0, 0);
        //sleep(100);
        drive(1, 1000, 0, 0);
        sleep(100);
        //Edit turn
        drive(1, 0, 20, 350);*/

    }

    public void drive(double power, int forward, int strafe, int turn) {
        //Set modes for motors
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Change motor power as needed
        backLeft.setPower(power*.6);
        frontLeft.setPower(power*.6);
        backRight.setPower(power*.6);
        frontRight.setPower(power*.6);

        backRight.setTargetPosition(forward + strafe - turn);
        frontRight.setTargetPosition(forward - strafe - turn);
        backLeft.setTargetPosition(-forward + strafe - turn);
        frontLeft.setTargetPosition(-forward - strafe - turn);

        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (backLeft.isBusy() && frontLeft.isBusy() && frontRight.isBusy() && backRight.isBusy()) {

        }
        sleep(100);
    }
}
