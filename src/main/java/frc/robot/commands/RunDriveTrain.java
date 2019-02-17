package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class RunDriveTrain extends Command 
{


    public RunDriveTrain() 
    {

        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() 
    {

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() 
    {

        GenericHID controller = Robot.oi.getController();
        Robot.drive.arcadeDrive(controller.getY(Hand.kLeft), -controller.getX(Hand.kLeft));
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() 
    {

        return false;
        
    }

    // Called once after isFinished returns true
    @Override
    protected void end() 
    {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() 
    {

    }
    
}
