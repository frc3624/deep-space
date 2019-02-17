package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SecondaryWheelsPistons extends Subsystem 
{

    private final DoubleSolenoid leftPiston;
    private final DoubleSolenoid rightPiston;

    public SecondaryWheelsPistons(int pcmID, 
                                    int leftPistonForwardSolenoidID, int leftPistonReverseSolenoidID,
                                    int rightPistonForwardSolenoidID, int rightPistonReverseSolenoidID) 
    {
        leftPiston = new DoubleSolenoid(pcmID, leftPistonForwardSolenoidID, leftPistonReverseSolenoidID);
        rightPiston = new DoubleSolenoid(pcmID, rightPistonForwardSolenoidID, rightPistonReverseSolenoidID);
    }

    public void extend() 
    {
        leftPiston.set(Value.kForward);
        rightPiston.set(Value.kForward);
    }

    public void retract() 
    {
        leftPiston.set(Value.kReverse);
        rightPiston.set(Value.kReverse);
    }

    @Override
    public void initDefaultCommand() 
    {

    }
    
}
