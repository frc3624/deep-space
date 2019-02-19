/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.hatch_panel;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class InsertHatchPanel extends Command {
  private Timer tm;
  private int currentState;
  private boolean beakWasOpened;

  public InsertHatchPanel() {
    requires(Robot.hatchPanelGrabber);
    currentState = 0;
    tm = new Timer();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    currentState = 0;
    tm.start();
    if (Robot.hatchPanelGrabber.isOpen())
    {
      Robot.hatchPanelGrabber.closeClaw();
      beakWasOpened = false;
    }
    else
    {
      Robot.hatchPanelGrabber.openClaw();
      beakWasOpened = true;
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Not the best code. Change it when there's time. Maybe split into separate commands
    if ((currentState == 0 && tm.get() > .5) || (currentState == 2 && tm.get() > .1))
    {
      ++currentState;
      Robot.hatchPanelGrabber.extendPiston();
      tm.reset();
    }
    else if ((currentState == 1 || currentState == 3) && tm.get() > .1)
    {
      ++currentState;
      Robot.hatchPanelGrabber.retractPiston();
      tm.reset();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return currentState == 4 || beakWasOpened;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {      
    Robot.hatchPanelGrabber.retractPiston();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
