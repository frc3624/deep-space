package frc.robot.commands.climbing;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;
public class LiftToLevel2 extends Command 
{
    public LiftToLevel2() 
    {
        requires(Robot.frontPistons);
        requires(Robot.backPistons);
    }

    @Override
    protected void initialize() 
    {
        Robot.frontPistons.extend();
        Robot.frontPistons.disableSecondValve();
        Robot.backPistons.extend();
        Robot.backPistons.disableSecondValve();
    }

    @Override
    protected void execute() 
    {
    }

    @Override
    protected boolean isFinished() 
    {
        return true; //We may make this an instant command in the future instead
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
