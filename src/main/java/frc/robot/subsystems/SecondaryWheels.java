package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Wheels used for lifting to level 3
 * @author Kyle Diaz
 */
public class SecondaryWheels extends Subsystem {

    private final static int FRONT_WHEELS_ID;
    private final WPI_TalonSRX frontWheels = new WPI_TalonSRX(FRONT_WHEELS_ID);

    private final static int BACK_WHEELS_ID;
    private final WPI_TalonSRX backWheels = new WPI_TalonSRX(BACK_WHEELS_ID);

    @Override
    public void initDefaultCommand() {

    }

    public void set(double speed) {
        frontWheels.set(speed);
        backWheels.set(speed);
    }
    public void set(ControlMode mode, double value) {
        frontWheels.set(mode, value);
    }
}
