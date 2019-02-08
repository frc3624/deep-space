package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class CargoGrabber extends Subsystem {


    public static final int LEFT_CARGO_GRABBER_WHEELS_ID = -1;
    public static final int RIGHT_CARGO_GRABBER_WHEELS_ID = -1;
    private final WPI_TalonSRX leftWheels = new WPI_TalonSRX(LEFT_CARGO_GRABBER_WHEELS_ID);
    private final WPI_TalonSRX rightWheels = new WPI_TalonSRX(RIGHT_CARGO_GRABBER_WHEELS_ID);

    @Override
    public void initDefaultCommand() {

    }
    
    public void set(double speed) {
        leftWheels.set(speed);
        rightWheels.set(speed);
    }

}