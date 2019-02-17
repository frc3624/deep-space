/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class GearShifters extends Subsystem {
  public enum GearMode
  {
    HIGH(true),
    LOW(false);

    private boolean solenoidState;

    GearMode(boolean solenoidState)
    {
      this.solenoidState = solenoidState;
    }

    public boolean getSolenoidState()
    {
      return solenoidState;
    }

    public GearMode getOppositeMode()
    {
      return (this == HIGH) ? LOW : HIGH;
    }
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final Solenoid evoShifters;
  private GearMode currentMode;

  public GearShifters(int evoShiftersChannel)
  {
    evoShifters = new Solenoid(evoShiftersChannel);
    setGear(GearMode.LOW);
  }

  public void setGear(GearMode mode)
  {
    currentMode = mode;
    evoShifters.set(mode.getSolenoidState());
  }

  public GearMode getCurrentMode()
  {
    return currentMode;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
