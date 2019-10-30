package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DriveSecondaryWheels;

/**
 * Wheels used for lifting to level 3
 * @author Kyle Diaz
 */
public class SecondaryWheels extends Subsystem 
{

    public static final double KV_RATING = 50; // RPM/V
    public static final double WHEEL_CIRCUMFERENCE = 4; // inches

    private final WPI_TalonSRX wheels;
    private final LiftingPistons liftingPistons;

    public SecondaryWheels(int talonID, LiftingPistons liftingPistons) 
    {
        wheels = new WPI_TalonSRX(talonID);
        this.liftingPistons = liftingPistons;
    }

    public void set(double speed) 
    {
        if (liftingPistons.getCurrentLevel() != LiftingPistons.LiftingPistonLevel.ZERO)
        {
            wheels.set(speed);
        }
        else
        {
            wheels.set(0);
        }
    }

    public void set(ControlMode mode, double value) 
    {
        if (liftingPistons.getCurrentLevel() != LiftingPistons.LiftingPistonLevel.ZERO)
        {
            wheels.set(mode, value);
        }
        else
        {
            wheels.set(0);
        }
    }

    @Override
    public void initDefaultCommand() 
    {
        setDefaultCommand(new DriveSecondaryWheels());
    }
}
