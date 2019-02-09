package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Level3LifterWheels extends Subsystem {
    
    //public static final int LEVEL_3_LIFTER_TALON_ID = -1;
    //private final WPI_TalonSRX level3LifterTalon = new WPI_TalonSRX(LEVEL_3_LIFTER_TALON_ID);
    
    @Override
    public void initDefaultCommand() {

    }

    public void set(double speed) {
        //level3LifterTalon.set(speed);
    }
    
}