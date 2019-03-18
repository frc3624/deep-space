/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;


//Probably dead unless we shift course drastically
/**
 * Add your docs here.
 */
public class MotorGrabberShifter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private final WPI_TalonSRX coilTalon;

    public MotorGrabberShifter(int talonID)
    {
        coilTalon = new WPI_TalonSRX(talonID);
    }

    @Override
    public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    }

    public static final double CURRENT_LIMIT = Integer.MAX_VALUE;
    public boolean isOverCurrent()
    {
        return coilTalon.getOutputCurrent() >= CURRENT_LIMIT;
    }
}
