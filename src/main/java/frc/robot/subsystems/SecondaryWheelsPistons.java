/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SecondaryWheelsPistons extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private final DoubleSolenoid leftPiston;
    private final DoubleSolenoid rightPiston;

    public SecondaryWheelsPistons(int forward1, int reverse1, int forward2, int reverse2) {
        leftPiston = new DoubleSolenoid(forward1, reverse1);
        rightPiston = new DoubleSolenoid(forward2, reverse2);
    }

    @Override
    public void initDefaultCommand() {

    }

    public void extend() {
        leftPiston.set(Value.kForward);
        rightPiston.set(Value.kForward);
    }

    public void retract() {
        leftPiston.set(Value.kReverse);
        rightPiston.set(Value.kReverse);
    }
}
