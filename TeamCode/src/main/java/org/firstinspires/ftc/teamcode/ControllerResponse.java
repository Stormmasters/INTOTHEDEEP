package org.firstinspires.ftc.teamcode;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

import static java.lang.Math.sqrt;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ControllerResponse extends OpMode {
    double leftStick;
    double rightStick;
    double LX, LY, RX, sensitivity = 0.5, wristPosition = 0.5;
    DcMotor BL, FL, FR, BR, S1, S2;
    Servo Intake, Wrist, HangArm;
    CRServo Arm;

    @Override
    public void init() {
        BL = hardwareMap.dcMotor.get("leftBack");
        FL = hardwareMap.dcMotor.get("leftFront");
        FR = hardwareMap.dcMotor.get("rightFront");
        BR = hardwareMap.dcMotor.get("rightBack");
        S1 = hardwareMap.dcMotor.get("par1");
        S2 = hardwareMap.dcMotor.get("par0");

        S1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        S2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        S1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        S2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        S1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        S2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        FL.setDirection(REVERSE);

        Intake = hardwareMap.get(Servo.class, "claw");
        Arm = hardwareMap.get(CRServo.class, "shoulder");
        Wrist = hardwareMap.get(Servo.class, "wrist");
        HangArm = hardwareMap.get(Servo.class, "hangArm");

        Wrist.setPosition(wristPosition); // Initialize wrist position

    }

    @Override
    public void loop() {

        leftStick = sqrt(gamepad1.left_stick_y) + sqrt(gamepad1.left_stick_x);
        rightStick = sqrt(gamepad1.right_stick_y) + sqrt(gamepad1.right_stick_x);

        telemetry.addData("Left Stick", leftStick);
        telemetry.addData("Right Stick", rightStick);
        telemetry.update();
    }
}