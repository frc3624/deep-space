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
        openClaw();

        pistonSolenoid = new Solenoid(pcmID, pistonChannel);
        retractPiston();
    }

    @Override
    public void initDefaultCommand() 
    {

    }

    public void extendPiston() 
    {
        pistonSolenoid.set(true);
    }
    
    public void retractPiston() 
    {
        pistonSolenoid.set(false);
    }

    public void openClaw() 
    {
        reverseClaw.set(false);
    }

    public void closeClaw() 
    {
        reverseClaw.set(true);
    }

    public boolean isOpen() 
    {
        return !reverseClaw.get();
    }

}