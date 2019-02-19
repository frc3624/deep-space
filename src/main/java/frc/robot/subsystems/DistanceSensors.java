package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DistanceSensors extends Subsystem {

    private final AnalogInput frontSensor;
    private final AnalogInput backSensor;

    public DistanceSensors(int frontDistanceSensorID, int backDistanceSensorID)
    {
        frontSensor = new AnalogInput(frontDistanceSensorID);
        backSensor = new AnalogInput(backDistanceSensorID);
    }

    @Override
    public void initDefaultCommand() 
    {

    }

    @Override
    public void periodic() 
    {
        SmartDashboard.putNumber("Front Ultrasonic Sensor", getFront());
        SmartDashboard.putNumber("Back Ultrasonic Sensor", getBack());
    }

    public int getFront()
    {
        return frontSensor.getAverageValue();
    }

    public int getBack() 
    {
        return backSensor.getAverageValue();
    }

    public static final int FRONT_IS_ON_PLATFORM_THRESHOLD = Integer.MIN_VALUE;
    public boolean frontIsOnPlatform()
    {
        return getFront() < FRONT_IS_ON_PLATFORM_THRESHOLD;
    }

    public static final int BACK_IS_ON_PLATFORM_THRESHOLD = Integer.MIN_VALUE;
    public boolean backIsOnPlatform()
    {
        return getBack() < BACK_IS_ON_PLATFORM_THRESHOLD;
    }
}
