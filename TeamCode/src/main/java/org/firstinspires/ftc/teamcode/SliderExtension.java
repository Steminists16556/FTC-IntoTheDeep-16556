/*package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class SliderExtension extends LinearOpMode {

    private DcMotor verticalSlider;

    private int[] ticks = {0, 500, 1000, 1500, 2000};

    private int currentTickIndex = 0;

    @Override
    public void runOpMode() {
        verticalSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        verticalSlider.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad2.dpad_up) {
                moveToNextTickForward();
            }

            if (gamepad2.dpad_down) {
                moveToNextTickBackward();
            }

            telemetry.addData("Motor Position", verticalSlider.getCurrentPosition());
            telemetry.addData("Current Tick Index", currentTickIndex);
            telemetry.update();

            private void moveToNextTickFoward () {
                if (currentTickIndex < ticks.length - 1) {
                    currentTickIndex++;
                    verticalSlider.setTargetPosition(ticks[currentTickIndex]);
                    verticalSlider.setPower(0.5);

                    while (verticalSlider.isBusy() && opModeIsActive()) {
                        telemetry.addData("moving to", "Tick" + currentTickIndex);
                        telemetry.update();
                    }
                    verticalSlider.setPower(0);
                }
            }

            if (currentTickIndex > 0) {
                currentTickIndex--;
                verticalSlider.setTargetPosition(ticks[currentTickIndex]);
                verticalSlider.setPower(0.5);

                while (verticalSlider.isBusy() && opModeIsActive()) {
                    telemetry.addData("moving to", "Tick" + currentTickIndex);
                    telemetry.update();
                }
                verticalSlider.setPower(0);
            }
        }
    }


}*/
