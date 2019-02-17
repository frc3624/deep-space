package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchPanelGrabber extends Subsystem 
{

    private final DoubleSolenoid reverseClaw;
    private DoubleSolenoid leftPiston;
    private DoubleSolenoid rightPiston;
    
    public HatchPanelGrabber(int pcmID,
                                int reverseClawForwardID, int reverseClawReverseID,
                                int bottomPistonForwardID, int bottomPistonReverseID,
                                int topPistonForwardID, int topPistonReverseID) 
    {
        reverseClaw = new DoubleSolenoid(pcmID, reverseClawForwardID, reverseClawReverseID);
        leftPiston = new DoubleSolenoid(pcmID, bottomPistonForwardID, bottomPistonReverseID);
        rightPiston = new DoubleSolenoid(pcmID, topPistonForwardID, topPistonReverseID);
    }
    @Override
    public void initDefaultCommand() 
    {


    }

    public void push() 
    {

        leftPiston.set(Value.kForward);
        rightPiston.set(Value.kForward);
    }
    public void retract() 
    {

        leftPiston.set(Value.kReverse);
        rightPiston.set(Value.kReverse);
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