package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class OtherIntake extends OpMode{
    private Servo SecondIntake;
    private boolean isToggled = false;
    private boolean previousButtonState = false;

    @Override
    public void init() {
        SecondIntake = hardwareMap.get(Servo.class, "SecondIntake");
    }

    @Override
    public void loop() {
        boolean currentButtonState = gamepad1.right_bumper;

        if (currentButtonState && !previousButtonState) {
            isToggled = !isToggled;

            if (isToggled) {
                SecondIntake.setPosition(0.5);
            } else {
                SecondIntake.setPosition(0);
            }
        }

        previousButtonState = currentButtonState;

    }
}
