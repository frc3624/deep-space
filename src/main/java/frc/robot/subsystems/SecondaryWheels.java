package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.DriveSecondaryWheels;

/**
 * Wheels used for lifting to level 3
 * @author Kyle Diaz
 */
public class SecondaryWheels extends Subsystem 
{

    public final static double KV_RATING = 50; // RPM/V
    public final static double WHEEL_RADIUS = 4; // inches

    private final WPI_TalonSRX wheels;

    public SecondaryWheels(int talonID) 
    {
        wheels = new WPI_TalonSRX(talonID);
    }

    public void set(double speed) 
    {
        set(ControlMode.Current, speed);
    }

    public void set(ControlMode mode, double value) 
    {
        //This if statement is not working. Fix at competition?
        if (Robot.backPistons.getCurrentLevel() != 0)
        {
            wheels.set(mode, value);
        }
    }

    @Override
    public void initDefaultCommand() 
    {
        setDefaultCommand(new DriveSecondaryWheels());
    }
}
