package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ToggleHatchGrabber extends Command {
    public ToggleHatchGrabber() {
        requires(Robot.hatchPanelGrabber);
    }

    @Override
    protected void initialize() {
        System.out.println("Hi :)");
        if (Robot.hatchPanelGrabber.isOpen()) {
            Robot.hatchPanelGrabber.retract();
            Robot.hatchPanelGrabber.closeClaw();
        } else {
            Robot.hatchPanelGrabber.openClaw();
            Robot.hatchPanelGrabber.push();
        }
    }

    @Override
    protected void execute() {
    }

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
