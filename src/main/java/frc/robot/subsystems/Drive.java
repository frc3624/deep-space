package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.RunDriveTrain;

public class Drive extends Subsystem
{
    private final WPI_TalonSRX leftTalon1;
    private final WPI_TalonSRX rightTalon1;
    private final DifferentialDrive differentialDrive1;

    private final WPI_TalonSRX leftTalon2;
    private final WPI_TalonSRX rightTalon2;
    private final DifferentialDrive differentialDrive2;

    public Drive(int leftTalon1ID, int rightTalon1ID, int leftTalon2ID, int rightTalon2ID) 
    {
        leftTalon1 = new WPI_TalonSRX(leftTalon1ID);
        rightTalon1 = new WPI_TalonSRX(rightTalon1ID);
        differentialDrive1 = new DifferentialDrive(leftTalon1, rightTalon1);

        leftTalon2 = new WPI_TalonSRX(leftTalon2ID);
        rightTalon2 = new WPI_TalonSRX(rightTalon2ID);
        differentialDrive2 = new DifferentialDrive(leftTalon2, rightTalon2);
    }

    @Override
    public void initDefaultCommand() 
    {
        setDefaultCommand(new RunDriveTrain());
    }

    public void arcadeDrive(double xSpeed, double zRotation) 
    {
        differentialDrive1.arcadeDrive(xSpeed, zRotation);
        differentialDrive2.arcadeDrive(xSpeed, zRotation);
    }

    public void set(double speed) 
    {
        setLeft(speed);
        setRight(speed);
    }
    
    public void set(ControlMode mode, double value) 
    {
        setLeft(mode, value);
        setRight(mode, value);
    }
    
    public void setLeft(double speed) 
    {
        leftTalon1.set(speed);
        leftTalon2.set(speed);
    }

    public void setLeft(ControlMode mode, double value) 
    {
        leftTalon1.set(mode, value);
        leftTalon2.set(mode, value);
    }

    public void setRight(double speed) 
    {
        rightTalon1.set(speed);
        rightTalon2.set(speed);
    }

    public void setRight(ControlMode mode, double value) 
    {
        rightTalon1.set(mode, value);
        rightTalon2.set(mode, value);
    }

}
