package frc.robot.subsystems;

import java.util.*;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DistanceSensor extends Subsystem {

    @Override
    public void initDefaultCommand() {

    }

<<<<<<< HEAD
  @Override
  public void periodic() 
  {
    
  }
=======
    private final AnalogInput ultrasonicSensor = new AnalogInput(0);

    @Override
    public void periodic() {

    }

    public int get() {
        return ultrasonicSensor.getAverageValue();
    }
>>>>>>> fda95249e39f027c6e55a1d686f36a63d4878da3
}
