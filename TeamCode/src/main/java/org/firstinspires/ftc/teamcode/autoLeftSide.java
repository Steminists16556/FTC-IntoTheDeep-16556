package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class autoLeftSide extends LinearOpMode {
    DcMotor backLeft;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor frontRight;

    @Override
    public void runOpMode() {
        // Hardware mapping for chassis motors
        backLeft = hardwareMap.dcMotor.get("backLeft");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        /*backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);*/

        waitForStart();
        //Change numbers as needed
        drive(1, 1000, 0, 0);
        sleep(100);
        drive(1, 0, -3572, 0);
        sleep(100);
        drive(1, 0, -3572, 0);
        sleep(100);
        drive(1, 0, -3572, 0);
        sleep(100);
        drive(1, -200, 0, 0);
        sleep(100);
        /*drive(1, 0, -6522, 0);
        sleep(100);
        drive(1, -1786, 0, 0);*/

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

        sleep(300);
    }
}
