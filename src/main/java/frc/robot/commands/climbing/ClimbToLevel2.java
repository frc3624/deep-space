package frc.robot.commands.climbing;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class ClimbToLevel2 extends CommandGroup 
{
	/**
	 * Add your docs here.
	 */
	public ClimbToLevel2() 
	{
		addSequential(new LiftToLevel1());
		addSequential(new WaitCommand("Wait for Lift", 5));
		addSequential(new RetractFrontPistonLevel2());
		addSequential(new WaitCommand("Wait for retracting front pistons", 2));
		addSequential(new DriveOntoPlatform());
		addSequential(new RetractBackPistonLevel2());
	}
}
