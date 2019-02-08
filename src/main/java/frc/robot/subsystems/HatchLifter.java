package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.RunHatchLifterWithController;

public class HatchLifter extends Subsystem {

    public static final int HATCH_LIFTER_TALON_ID = -1;
    private final WPI_TalonSRX hatchLifterTalon = new WPI_TalonSRX(HATCH_LIFTER_TALON_ID);
    
    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new RunHatchLifterWithController());
    }
    
    public void set(double speed) {
        hatchLifterTalon.set(speed);
    }
}