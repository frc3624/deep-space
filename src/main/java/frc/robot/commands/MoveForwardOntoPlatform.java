package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveForwardOntoPlatform extends Command {
    public MoveForwardOntoPlatform() {

    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    }

    private static final int TRIGGER_DISTANCE = Integer.MAX_VALUE;
    @Override
    protected boolean isFinished() {
        return Robot.distanceSensor.getFront() < TRIGGER_DISTANCE;
    }

    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
