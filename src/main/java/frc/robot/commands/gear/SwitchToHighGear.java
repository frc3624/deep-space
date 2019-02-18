/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.gear;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.GearShifter.GearMode;

public class SwitchToHighGear extends InstantCommand {
  public SwitchToHighGear() {
    requires(Robot.gearShifter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("high gear");
    Robot.gearShifter.setGear(GearMode.HIGH);
  }
}
