package frc.robot.commands.climbing;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveForwardToPlatform extends Command 
{
    public MoveForwardToPlatform() 
    {
        requires(Robot.secondaryWheels);
    }

    @Override
    protected void initialize() 
    {
    }

    @Override
    protected void execute() 
    {
        Robot.secondaryWheels.set(1);
    }

    @Override
    protected boolean isFinished() 
    {
        return Robot.distanceSensor.frontIsOnPlatform();
    }

    @Override
    protected void end() 
    {
    }

    @Override
    protected void interrupted() 
    {
    }
}
