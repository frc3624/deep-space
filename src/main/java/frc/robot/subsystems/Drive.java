package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.commands.RunDriveTrain;

public class Drive extends Subsystem
{
    private final WPI_TalonSRX leftTalon1;
    private final WPI_TalonSRX leftTalon2;
    private final SpeedControllerGroup leftSpeedControllerGroup;

    private final WPI_TalonSRX rightTalon1;
    private final WPI_TalonSRX rightTalon2;
    private final SpeedControllerGroup rightSpeedControllerGroup;

    private final DifferentialDrive differentialDrive;

    public Drive(int leftTalon1ID, int leftTalon2ID, int rightTalon1ID, int rightTalon2ID) 
    {
        leftTalon1 = new WPI_TalonSRX(leftTalon1ID);
        leftTalon2 = new WPI_TalonSRX(leftTalon2ID);
        leftSpeedControllerGroup = new SpeedControllerGroup(leftTalon1, leftTalon2);
        // leftSpeedControllerGroup = new SpeedControllerGroup(leftTalon1);
        // leftSpeedControllerGroup = new SpeedControllerGroup(leftTalon2);

        rightTalon1 = new WPI_TalonSRX(rightTalon1ID);
        rightTalon2 = new WPI_TalonSRX(rightTalon2ID);
        rightSpeedControllerGroup = new SpeedControllerGroup(rightTalon1, rightTalon2);
        // rightSpeedControllerGroup = new SpeedControllerGroup(rightTalon1);
        // rightSpeedControllerGroup = new SpeedControllerGroup(rightTalon2);

        differentialDrive = new DifferentialDrive(leftSpeedControllerGroup, rightSpeedControllerGroup);
        
        setCurrentControls(leftTalon1, leftTalon2, rightTalon1, rightTalon2);
    }

    public void setCurrentControls(WPI_TalonSRX... talons)
    {

        for(WPI_TalonSRX currentTalon : talons)
        {
            currentTalon.configContinuousCurrentLimit(30, 0);
            currentTalon.configPeakCurrentLimit(35, 0);
            currentTalon.configPeakCurrentDuration(10, 0);
            currentTalon.enableCurrentLimit(true);
        }

    }
    @Override
    public void initDefaultCommand() 
    {
        setDefaultCommand(new RunDriveTrain(Robot.oi.getDriveController()));
    }

    public void arcadeDrive(double xSpeed, double zRotation) 
    {
        differentialDrive.arcadeDrive(xSpeed, zRotation);
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

    public int getLeftReading()
    {
        return leftTalon1.getSelectedSensorPosition();
    }

    public int getRightReading()
    {
        return rightTalon1.getSelectedSensorPosition();
    }

    public void resetLeftReading()
    {
        leftTalon1.setSelectedSensorPosition(0);
    }

    public void resetRightReading()
    {
        rightTalon1.setSelectedSensorPosition(0);
    }
}
