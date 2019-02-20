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
public class RetractBackPistonsToPreviousLevel extends InstantCommand {
  /**
   * Add your docs here.
   */
  public RetractBackPistonsToPreviousLevel() {
    super();
    requires(Robot.backPistons);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    System.out.println("Retracting Back Level: " + Robot.backPistons.getCurrentLevel());
    Robot.backPistons.previousLevel();
    System.out.println("New Back Level: " + Robot.backPistons.getCurrentLevel());
  }

}
