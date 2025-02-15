package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DistanceSensors extends Subsystem {

    private final AnalogInput frontSensor;
    private final AnalogInput backSensor;

    public DistanceSensors(int frontDistanceSensorID, int backDistanceSensorID)
    {
        frontSensor = new AnalogInput(frontDistanceSensorID);
        frontSensor.setAccumulatorInitialValue(0);

        backSensor = new AnalogInput(backDistanceSensorID);
        backSensor.setAccumulatorInitialValue(0);
    }

    public void resetSensors()
    {
        frontSensor.initAccumulator();
        backSensor.initAccumulator();
    }
    @Override
    public void initDefaultCommand() 
    {

    }

    @Override
    public void periodic() 
    {
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
