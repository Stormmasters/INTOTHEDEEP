package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ServoTest extends OpMode{
    private Servo IntakeWheel;
    private Servo Wrist;

    @Override
    public void init() {
        IntakeWheel = hardwareMap.get(Servo.class, "IntakeWheel");
        Wrist = hardwareMap.get(Servo.class, "Wrist");
    }

    @Override
    public void loop() {
        if(!gamepad1.right_bumper) {
            IntakeWheel.setPosition(0.5);
        } else {
            IntakeWheel.setPosition(0.3);
        }
        if(!gamepad1.left_bumper) {
            IntakeWheel.setPosition(0.5);
        } else {
            IntakeWheel.setPosition(0.8);
        }
    }
}
