/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climbing;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class RetractFrontPistonsToPreviousLevel extends InstantCommand {
  /**
   * Add your docs here.
   */
  public RetractFrontPistonsToPreviousLevel() {
    super();
    requires(Robot.frontPistons);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    System.out.println("Retracting Front Level: " + Robot.frontPistons.getCurrentLevel());
    Robot.frontPistons.previousLevel();
    System.out.println("New Front Level: " + Robot.frontPistons.getCurrentLevel());
  }

}
