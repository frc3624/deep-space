package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchPanelGrabber extends Subsystem {

    private DoubleSolenoid reverseClaw = new DoubleSolenoid(3, 0, 1);

    private DoubleSolenoid bottomPiston = new DoubleSolenoid(3, 2, 3);
    private DoubleSolenoid topPiston = new DoubleSolenoid(3, 4, 5);

    @Override
    public void initDefaultCommand() {

    }

    public void push() {
        bottomPiston.set(Value.kForward);
        bottomPiston.set(Value.kForward);
    }
    public void retract() {
        bottomPiston.set(Value.kReverse);
        bottomPiston.set(Value.kReverse);
    }

    public void openClaw() {
        reverseClaw.set(Value.kForward);
    }
    public void closeClaw() {
        reverseClaw.set(Value.kReverse);
    }

}