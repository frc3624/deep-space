/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.ShipLevel;

/**
 * An example command.  You can replace me with your own command.
 */
public class AlignAndInsertHatchPanel extends CommandGroup {

    public AlignAndInsertHatchPanel(ShipLevel level) {
        addSequential(new AlignWithSide());
        addSequential(new LiftToHatchLevel(ShipLevel.TOP));
    }

}