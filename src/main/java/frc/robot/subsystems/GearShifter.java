package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class GearShifter extends Subsystem {
    public enum GearMode
    {
        HIGH(false),
        LOW(true);

        private boolean solenoidState;

        GearMode(boolean solenoidState) {
            this.solenoidState = solenoidState;
        }

        public boolean getSolenoidState() {
            return solenoidState;
        }

        public GearMode getOppositeMode() {
            return (this == HIGH) ? LOW : HIGH;
        }

        @Override
        public String toString()
        {
            return (this == HIGH) ? "HIGH" : "LOW";
        }
    }

    private final Solenoid evoShifters;
    private GearMode currentMode;

  public GearShifter(int pcmChannel, int evoShiftersChannel)
  {
    evoShifters = new Solenoid(pcmChannel, evoShiftersChannel);
    setGearMode(GearMode.LOW);
  }

    public void setGearMode(GearMode mode) {
        currentMode = mode;
        evoShifters.set(mode.getSolenoidState());
    }

    public void switchGears()
    {
        setGearMode(getCurrentMode().getOppositeMode());
    }

    public GearMode getCurrentMode() {
        return currentMode;
    }

    @Override
    public void initDefaultCommand() {
        
    }
}
