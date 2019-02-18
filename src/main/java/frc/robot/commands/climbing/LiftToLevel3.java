/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climbing;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class LiftToLevel3 extends TimedCommand {
  /**
   * Add your docs here.
   */
  public LiftToLevel3(double timeout) {
    super(timeout);
    requires(Robot.frontPistons);
    requires(Robot.backPistons);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("First step");
    Robot.frontPistons.extend();
    Robot.backPistons.extend();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Called once after timeout
  @Override
  protected void end() {
    System.out.println("Second stop");
    Robot.frontPistons.topThing();
    Robot.frontPistons.topThing();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
