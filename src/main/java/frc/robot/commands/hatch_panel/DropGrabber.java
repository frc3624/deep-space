/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.hatch_panel;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class DropGrabber extends InstantCommand {
    /**
     * Add your docs here.
     */
    public DropGrabber() {
        requires(Robot.pneumaticGrabberShifter);
    }

    // Called once when the command executes
    @Override
    protected void initialize()
    {
        Robot.pneumaticGrabberShifter.dropGrabber();
    }
}
