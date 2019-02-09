package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.RunDriveTrain;

public class Drive extends Subsystem {

    public static final int LEFT_DRIVE_TALON_1_ID = 1;
    public static final int RIGHT_DRIVE_TALON_1_ID = 2;
    private final WPI_TalonSRX leftTalon1 = new WPI_TalonSRX(LEFT_DRIVE_TALON_1_ID);
    private final WPI_TalonSRX rightTalon1 = new WPI_TalonSRX(RIGHT_DRIVE_TALON_1_ID);
    private final DifferentialDrive differentialDrive1 = new DifferentialDrive(leftTalon1, rightTalon1);

    public static final int LEFT_DRIVE_TALON_2_ID = 7;
    public static final int RIGHT_DRIVE_TALON_2_ID = 8;
    private final WPI_TalonSRX leftTalon2 = new WPI_TalonSRX(LEFT_DRIVE_TALON_2_ID);
    private final WPI_TalonSRX rightTalon2 = new WPI_TalonSRX(RIGHT_DRIVE_TALON_2_ID);
    private final DifferentialDrive differentialDrive2 = new DifferentialDrive(leftTalon2, rightTalon2);

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new RunDriveTrain());
    }

    public void arcadeDrive(double xSpeed, double zRotation) {
        differentialDrive1.arcadeDrive(xSpeed, zRotation);
        differentialDrive2.arcadeDrive(xSpeed, zRotation);
    }

    public void set(double speed) {
        setLeft(speed);
        setRight(speed);
    }
    
    public void setLeft(double speed) {
        leftTalon1.set(speed);
        leftTalon2.set(speed);
    }
    public void setRight(double speed) {
        rightTalon1.set(speed);
        rightTalon2.set(speed);
    }

}
