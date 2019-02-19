package frc.robot.commands.hatch_panel;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class GrabHatchPanel extends InstantCommand {
  
  public GrabHatchPanel() 
  {
    requires(Robot.hatchPanelGrabber);
  }

  @Override
  protected void initialize() {
    Robot.hatchPanelGrabber.retractPiston();
    Robot.hatchPanelGrabber.openClaw();
  }
}
