package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class GearShifter extends Subsystem {
    public enum GearMode
    {
        HIGH(true),
        LOW(false);

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
    }

    private final Solenoid evoShifters;
    private GearMode currentMode;

  public GearShifter(int pcmChannel, int evoShiftersChannel)
  {
    evoShifters = new Solenoid(pcmChannel, evoShiftersChannel);
    setGear(GearMode.LOW);
  }

    public void setGear(GearMode mode) {
        currentMode = mode;
        evoShifters.set(mode.getSolenoidState());
    }

    public GearMode getCurrentMode() {
        return currentMode;
    }

    @Override
    public void initDefaultCommand() {
        
    }
}
