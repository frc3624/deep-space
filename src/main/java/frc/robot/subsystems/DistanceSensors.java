package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

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
        System.out.println("Front: " + frontSensor.getAverageValue());
        System.out.println("Back: " + backSensor.getAverageValue());
    }

    public int getFront()
    {
        return frontSensor.getAverageValue();
    }

    public int getBack() 
    {
        return backSensor.getAverageValue();
    }
}
