package frc.robot.commands.climbing;

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

    @Override
    protected void interrupted() {
    }
}
