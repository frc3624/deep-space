package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;

public class HatchPanelGrabber extends Subsystem {

    public static final int REVERSE_CLAW_FORWARD_CHANNEL = 0;
    public static final int REVERSE_CLAW_REVERSE_CHANNEL = 1;
    private final DoubleSolenoid reverseClaw = new DoubleSolenoid(Robot.PNEUMATICS_CONTROL_MODULE_ID, 
                                                                    REVERSE_CLAW_FORWARD_CHANNEL, REVERSE_CLAW_REVERSE_CHANNEL);

    public static final int BOTTOM_PISTON_FORWARD_CHANNEL = 2;
    public static final int BOTTOM_PISTON_REVERSE_CHANNEL = 3;
    private DoubleSolenoid bottomPiston = new DoubleSolenoid(Robot.PNEUMATICS_CONTROL_MODULE_ID, 
                                                                BOTTOM_PISTON_FORWARD_CHANNEL, BOTTOM_PISTON_REVERSE_CHANNEL);
    public static final int TOP_PISTON_FORWARD_CHANNEL = 4;
    public static final int TOP_PISTON_REVERSE_CHANNEL = 5;
    private DoubleSolenoid topPiston = new DoubleSolenoid(Robot.PNEUMATICS_CONTROL_MODULE_ID, 
                                                                TOP_PISTON_FORWARD_CHANNEL, TOP_PISTON_REVERSE_CHANNEL);

    @Override
    public void initDefaultCommand() {

    }

    public void push() {
        bottomPiston.set(Value.kForward);
        topPiston.set(Value.kForward);
    }
    public void retract() {
        bottomPiston.set(Value.kReverse);
        topPiston.set(Value.kReverse);
    }

    public void openClaw() {
        reverseClaw.set(Value.kForward);
    }
    public void closeClaw() {
        reverseClaw.set(Value.kReverse);
    }

}