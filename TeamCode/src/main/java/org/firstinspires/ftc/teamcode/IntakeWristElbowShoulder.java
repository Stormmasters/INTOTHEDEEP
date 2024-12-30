package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class IntakeWristElbowShoulder extends OpMode {
    private DcMotor Shoulder;
    private Servo Elbow;
    private Servo Wrist;
    private Servo Intake;

    @Override
    public void init() {
        Shoulder = hardwareMap.get(DcMotor.class, "Shoulder");
        Elbow = hardwareMap.get(Servo.class, "Elbow");
        Wrist = hardwareMap.get(Servo.class, "Wrist");
        Intake = hardwareMap.get(Servo.class, "Intake");
    }

    @Override
    public void loop() {
        //Sets power for the shoulder
        Shoulder.setPower(-gamepad2.left_stick_y/1.5);

        //Makes the elbow turn 90 degrees
        if(gamepad2.a) {
            Elbow.setPosition(0.5);
        } else {
            Elbow.setPosition(0);
        }

        //Makes the wrist turn 90 degrees
        if(gamepad2.x) {
            Wrist.setPosition(0.25);
        } else {
            Wrist.setPosition(0);
        }

        Intake.setPosition(-gamepad2.right_stick_y + 0.5);

        telemetry.addData("Shoulder Power", Shoulder.getPower());
        telemetry.addData("Elbow Position", Elbow.getPosition());
        telemetry.addData("Wrist Position", Wrist.getPosition());
        telemetry.addData("Intake Position", Intake.getPosition());
        telemetry.update();
    }
}