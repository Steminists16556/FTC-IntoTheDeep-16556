package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class driveChassis extends OpMode {

//Hardware declarations for chassis motors
    DcMotor backLeft;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor frontRight;

//Hardware declarations for the arm motors
    DcMotor upSlider;
    DcMotor verticalSlider;

//Hardware declarations for servos
    Servo rightServoDomain;
    Servo leftServoDomain;
    Servo rightServoRange;
    Servo leftServoRange;

    double upTicks = 5281.1;
    double upTarget;


    public void init() {

//Hardware declarations for servos
        backLeft = hardwareMap.dcMotor.get("backLeft");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        frontRight = hardwareMap.dcMotor.get("frontRight");

//Hardware mapping for arm motors
        verticalSlider = hardwareMap.dcMotor.get("verticalSlider");
        //verticalSlider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        upSlider = hardwareMap.dcMotor.get("upSlider");
        //upSlider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //upSlider.setMode(DcMotor.RunMode.RESET_ENCODERS);
        upSlider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

// Hardware mapping for servo motors
        rightServoDomain = hardwareMap.servo.get("rightServoDomain");
        leftServoDomain = hardwareMap.servo.get("leftServoDomain");
        rightServoRange = hardwareMap.servo.get("rightServoRange");
        leftServoRange = hardwareMap.servo.get("leftServoRange");
    }

    //Start of loop
    public void loop() {

//Code for chassis
        double forward = gamepad1.left_stick_y;
        double strafe = gamepad1.right_stick_x;
        double turn = 0.7 * gamepad1.left_stick_x;

//Code for slider to extend
        double up = -0.5 * gamepad2.left_stick_y;
        double out = 0.8 * gamepad2.right_stick_y;


//Power for chassis
        backLeft.setPower(forward + strafe - turn);
        frontLeft.setPower(forward - strafe - turn);
        backRight.setPower(-forward + strafe - turn);
        frontRight.setPower(-forward - strafe - turn);

        //Power for horizontalSlider
        //horizontalSlider.setPower(out);

//Power for verticalSlider
        verticalSlider.setPower(out);
        upSlider.setPower(up);

        /*
        //Encoder defining for verticalSlider
        double sliderTicks = 860.32;
        double sliderTarget;


        //Encoder for verticalSlider
        verticalSlider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        verticalSlider.setDirection(DcMotorSimple.Direction.REVERSE);
        verticalSlider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        verticalSlider.setMode(DcMotor.RunMode.RESET_ENCODERS);
*/
//Encoder mapping for up motor
        //origin
       /* if(gamepad2.dpad_down) {
            full(0.2);
        }

        //go into the submersable
        if(gamepad2.dpad_up) {
            full(0.5);
        }

        //reach high chamber and basket
        if(gamepad2.dpad_right) {
            full(0.8);
        }

        telemetry.addData("Motor arm ticks: ", upSlider.getCurrentPosition());

*/

        //Servos for opening and closing the claw
        //Left Bumper for opening claw
        if (gamepad2.left_bumper) {
            rightServoDomain.setPosition(0);
            leftServoDomain.setPosition(1);
        }

        //Right Bumper for closing claw
        if (gamepad2.right_bumper) {
            rightServoDomain.setPosition(0.3);
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
        if (gamepad2.b) {
            rightServoRange.setPosition(0.5);
            //rightServoRange.setDirection(Servo.Direction.REVERSE);
            leftServoRange.setPosition(0.5);
            //rightServoRange.setDirection(Servo.Direction.REVERSE);
        }

        //Servos for raising claw
        /*if (gamepad2.y) {
            rightServoRange.setPosition(0.7);
            leftServoRange.setPosition(0.3);
        }*/

        //Servos for lowering claw
        if (gamepad2.a) {
            rightServoRange.setPosition(0.3);
            leftServoRange.setPosition(0.7);
        }

    }
    /*
    //End of loop
    public void max (double turnage) {
        slider = sliderTicks*turnage;
        verticalSlider.setTargetPosition((int)sliderTarget);
        verticalSlider.setPower(1);
        verticalSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void begin(){
        verticalSlider.setTargetPosition(0);
        verticalSlider.setPower(1);
        verticalSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
*/
//Ticks for the motor that goes up
   /* public void full (double turnage) {
        upTarget = upTicks*turnage;
        upSlider.setTargetPosition((int)upTarget);
        upSlider.setPower(.75);
        upSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
*/


}
