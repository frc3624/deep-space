package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive extends Subsystem {

    private WPI_TalonSRX talon1 = new WPI_TalonSRX(1);
    private WPI_TalonSRX talon2 = new WPI_TalonSRX(2);
    private DifferentialDrive ddrive1 = new DifferentialDrive(talon1, talon2);

    private WPI_TalonSRX talon3 = new WPI_TalonSRX(3);
    private WPI_TalonSRX talon4 = new WPI_TalonSRX(4);
    private DifferentialDrive ddrive2 = new DifferentialDrive(talon3, talon4);

    @Override
    public void initDefaultCommand() {

    }

    public void arcadeDrive(double xSpeed, double zRotation) {
        ddrive1.arcadeDrive(xSpeed, zRotation);
        ddrive2.arcadeDrive(xSpeed, zRotation);
    }
    public void setLeft(double speed) {
        talon1.set(speed);
        talon3.set(speed);
    }
    public void setRight(double speed) {
        talon2.set(speed);
        talon4.set(speed);
    }

}
