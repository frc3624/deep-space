package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class GrabHatchPanel extends Command {
  public GrabHatchPanel() {

  }

  @Override
  protected void initialize() {
    Robot.hatchPanelGrabber.retractPiston();
    Robot.hatchPanelGrabber.openClaw();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
