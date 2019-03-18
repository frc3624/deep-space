package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchPanelGrabber extends Subsystem 
{
    public enum BeakPositionMode
    {
        OPEN(false),
        CLOSED(true);

        private boolean value;
        BeakPositionMode(boolean value)
        {
            this.value = value;
        }

        public boolean getValue()
        {
            return value;
        }

        public BeakPositionMode getOpposite()
        {
            return (this == OPEN) ? CLOSED : OPEN;
        }

        @Override
        public String toString()
        {
            return (this == OPEN) ? "OPEN" : "CLOSED";
        }
    }

    private final Solenoid reverseBeakSolenoid;
    private Solenoid pistonSolenoid;
    private BeakPositionMode currentPosition;

    public HatchPanelGrabber(int pcmID, int reverseClawChannel, int pistonChannel)    
    {
        reverseBeakSolenoid = new Solenoid(pcmID, reverseClawChannel);
        openBeak();

        pistonSolenoid = new Solenoid(pcmID, pistonChannel);
        retractPiston();
    }

    @Override
    public void initDefaultCommand() 
    {

    }

    public void setPosition(BeakPositionMode position)
    {
        this.currentPosition = position;
        this.reverseBeakSolenoid.set(position.getValue());
    }

    public BeakPositionMode getCurrentMode()
    {
        return currentPosition;
    }
    
    public void extendPiston() 
    {
        pistonSolenoid.set(true);
    }
    
    public void retractPiston() 
    {
        pistonSolenoid.set(false);
    }
    
    public void openBeak() 
    {
        setPosition(BeakPositionMode.OPEN);
    }

    public void closeBeak() 
    {
        setPosition(BeakPositionMode.CLOSED);
    }
}