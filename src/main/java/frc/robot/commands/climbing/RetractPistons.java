package frc.robot.commands.climbing;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RetractPistons extends Command {
  public RetractPistons() {
    requires(Robot.frontPistons);
    requires(Robot.backPistons);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.frontPistons.bottomThing();
    Robot.frontPistons.retract();
    Robot.backPistons.topThing();
    Robot.backPistons.retract();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
