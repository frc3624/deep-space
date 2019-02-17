package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SecondaryWheelsPistons extends Subsystem 
{

    private final Solenoid leftPiston;
    private final Solenoid rightPiston;

    public SecondaryWheelsPistons(int pcmID, int leftPistonChannel, int rightPistonChannel)
    {
        leftPiston = new Solenoid(pcmID, leftPistonChannel);
        rightPiston = new Solenoid(pcmID, rightPistonChannel);
    }

    public void extend() 
    {
        leftPiston.set(true);
        rightPiston.set(true);
    }

    public void retract() 
    {
        leftPiston.set(false);
        rightPiston.set(false);
    }

    @Override
    public void initDefaultCommand() 
    {

    }
    
}
