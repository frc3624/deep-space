package frc.robot.commands.climbing;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class RetractLiftingPistons extends InstantCommand {
  public RetractLiftingPistons() {
    requires(Robot.frontPistons);
    requires(Robot.backPistons);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.frontPistons.fullyRetract();
    Robot.backPistons.fullyRetract();
  }
}

