package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class driveChassis extends OpMode {
    //Hardware declarations for chassis motors
    DcMotor backLeft;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor frontRight;
    //Hardware declarations for horizontal extension
    //DcMotor horizontalSlider;
    //Hardware declarations for vertical extension

    DcMotor verticalSlider;
    //Hardware declarations for servos
    Servo rightServoDomain;
    Servo leftServoDomain;
    Servo rightServoRange;
    Servo leftServoRange;


    public void init() {
        // Hardware mapping for chassis motors
        backLeft = hardwareMap.dcMotor.get("backLeft");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        //Hardware mapping for slider motor
        //horizontalSlider = hardwareMap.dcMotor.get("horizontalSlider");
        //Hardware mapping for arm motor
        verticalSlider = hardwareMap.dcMotor.get("verticalSlider");
        //Hardware mapping for servo motors
        rightServoDomain = hardwareMap.servo.get("rightServoDomain");
        leftServoDomain = hardwareMap.servo.get("leftServoDomain");
        rightServoRange = hardwareMap.servo.get("rightServoRange");
        leftServoRange = hardwareMap.servo.get("leftServoRange");
    }

    public void loop() {
        //Code for chassis
        double forward = gamepad1.left_stick_y;
        double strafe = gamepad1.right_stick_x;
        double turn = 0.7 * gamepad1.left_stick_x;

        //Code for slider to extend
        //double out = 0.5 * gamepad2.right_stick_y;
        double up = 0.8 * gamepad2.right_stick_y;

        //Power for chassis
        backLeft.setPower(forward + strafe - turn);
        frontLeft.setPower(forward - strafe - turn);
        backRight.setPower(-forward + strafe - turn);
        frontRight.setPower(-forward - strafe - turn);

        //Power for horizontal extension
        //horizontalSlider.setPower(out);

        //Power for vertical extension
        verticalSlider.setPower(up);

        //Servos for opening and closing the claw
        //Left Bumper for opening claw

        if (gamepad2.left_bumper) {
            rightServoDomain.setPosition(0);
            leftServoDomain.setPosition(1);
        }

        //Right Bumper for closing claw
        if (gamepad2.right_bumper) {
            rightServoDomain.setPosition(0.06);
            leftServoDomain.setPosition(0.7);
        }

        //Servos for moving the claw up and down
        //Servos for lifting claw
        /*if (gamepad2.x) {
            rightServoRange.setPosition(0);
            leftServoRange.setPosition(0);
        }
        */
        //Servos for setting claw straight
        if (gamepad2.a) {
            rightServoRange.setPosition(1);
            leftServoRange.setPosition(0);
        }

        //Servos for lowering claw
        if (gamepad2.b) {
            rightServoRange.setPosition(0.7);
            leftServoRange.setPosition(0.3);
        }
    }
}
