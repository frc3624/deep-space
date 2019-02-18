package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SecondaryWheelsPistons extends Subsystem 
{

    private final Solenoid mainPiston;
    private final Solenoid togglePiston;

    public SecondaryWheelsPistons(int pcmID, int mainChannel, int toggleChannel)
    {
        mainPiston = new Solenoid(pcmID, mainChannel);
        togglePiston = new Solenoid(pcmID, toggleChannel);
    }

    public void extend() 
    {
        mainPiston.set(true);
    }

    public void retract() 
    {
        mainPiston.set(false);
    }

    public void topThing() {
        togglePiston.set(true);
    }
    public void bottomThing() {
        togglePiston.set(false);
    }

    @Override
    public void initDefaultCommand() 
    {

    }
    
}
