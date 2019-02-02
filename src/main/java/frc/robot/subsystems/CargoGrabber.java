package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class CargoGrabber extends Subsystem {

    private WPI_TalonSRX leftWheels = new WPI_TalonSRX(-1);
    private WPI_TalonSRX rightWheels = new WPI_TalonSRX(-1);

    @Override
    public void initDefaultCommand() {

    }
    
    public void set(double speed) {
        
    }

}