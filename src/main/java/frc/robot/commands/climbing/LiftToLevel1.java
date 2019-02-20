package frc.robot.commands.climbing;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;
public class LiftToLevel1 extends Command 
{
    public LiftToLevel1() 
    {
        requires(Robot.frontPistons);
        requires(Robot.backPistons);
    }

    @Override
    protected void initialize() 
    {
        Robot.frontPistons.enableLevel1Valve();
        Robot.frontPistons.disableLevel2Valve();
        Robot.backPistons.enableLevel1Valve();
        Robot.backPistons.disableLevel2Valve();
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
