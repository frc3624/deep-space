package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Wheels used for lifting to level 3
 * @author Kyle Diaz
 */
public class SecondaryWheels extends Subsystem 
{

    private final WPI_TalonSRX wheels;

    public SecondaryWheels(int talonID) 
    {
        wheels = new WPI_TalonSRX(talonID);
    }

    public void setWheels(double speed) 
    {
        wheels.set(speed);
    }
    public void setWheels(ControlMode mode, double value) 
    {
        wheels.set(mode, value);
    }

    @Override
    public void initDefaultCommand() 
    {

    }
}
