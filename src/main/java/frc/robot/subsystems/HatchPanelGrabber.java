package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchPanelGrabber extends Subsystem 
{

    private final Solenoid reverseClaw;
    private Solenoid pistonSolenoid;
    
    public HatchPanelGrabber(int pcmID, int reverseClawChannel, int pistonChannel)    
    {
        reverseClaw = new Solenoid(pcmID, reverseClawChannel);
        pistonSolenoid = new Solenoid(pcmID, pistonChannel);
    }

    @Override
    public void initDefaultCommand() 
    {


    }

    public void push() 
    {
        
    }
    
    public void retract() 
    {

    }

    public void openClaw() 
    {
        reverseClaw.set(false);
    }

    public void closeClaw() 
    {
        reverseClaw.set(true);
    }

}