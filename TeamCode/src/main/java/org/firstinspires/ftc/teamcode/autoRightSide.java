package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class autoRightSide extends LinearOpMode {
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
        //Change numbers
        drive(1, 2000, 0, 0);
        /*
        sleep(100);
        drive(1, 0, -1000, 0);
        sleep(100);
        drive(1, -400, 0, 0);
        drive(1, 400,0, 0);
        sleep(100);
        drive(1, 0, 1000, 0);
        sleep(100);
        drive(1, -400, 0, 0);
        sleep(100);
*/
    }

    public void drive(double power, int forward, int strafe, int turn) {
        // 2000 ticks = 

        //Set modes for motors
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //If needed change set power number
        backLeft.setPower(power * .5);
        frontLeft.setPower(power * .5);
        backRight.setPower(power * .5);
        frontRight.setPower(power * .5);

        backRight.setTargetPosition(forward + strafe - turn);
        frontRight.setTargetPosition(forward - strafe - turn);
        backLeft.setTargetPosition(-forward + strafe - turn);
        frontLeft.setTargetPosition(-forward - strafe - turn);

        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }
}