package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class AlignWithSide extends Command 
{

    public AlignWithSide() 
    {
        requires(Robot.drive);
    }

    @Override
    protected void initialize() 
    {

    }

    @Override
    protected void execute() 
    {

    }

    @Override
    protected boolean isFinished() 
    {
        return Robot.vision.hasTargetVisual() && Robot.vision.isHorizontallyAligned() && Robot.vision.isVerticallyAligned();
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
