package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchPanelGrabber extends Subsystem 
{

    private final DoubleSolenoid reverseClaw;
    private DoubleSolenoid bottomPiston;
    private DoubleSolenoid topPiston;
    
    public HatchPanelGrabber(int pcmID,
                                int reverseClawForwardID, int reverseClawReverseID,
                                int bottomPistonForwardID, int bottomPistonReverseID,
                                int topPistonForwardID, int topPistonReverseID) 
    {
        reverseClaw = new DoubleSolenoid(pcmID, reverseClawForwardID, reverseClawReverseID);
        bottomPiston = new DoubleSolenoid(pcmID, bottomPistonForwardID, bottomPistonReverseID);
        topPiston = new DoubleSolenoid(pcmID, topPistonForwardID, topPistonReverseID);
    }
    @Override
    public void initDefaultCommand() 
    {


    }

    public void push() 
    {

        bottomPiston.set(Value.kForward);
        topPiston.set(Value.kForward);
    }
    public void retract() 
    {

        bottomPiston.set(Value.kReverse);
        topPiston.set(Value.kReverse);
    }

    public void openClaw() 
    {

        reverseClaw.set(Value.kForward);
    }
    public void closeClaw() 
    {

        reverseClaw.set(Value.kReverse);
    }

}