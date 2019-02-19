package frc.robot.commands.climbing;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RetractLiftingPistons extends Command {
  public RetractLiftingPistons() {
    requires(Robot.frontPistons);
    requires(Robot.backPistons);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.frontPistons.retract();
    Robot.backPistons.retract();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.backPistons.disableSecondValve();
    Robot.frontPistons.disableSecondValve();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
