package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The operator interface class. Must be intitialized AFTER all subsystems.
 */
public class OI 
    {

    
    private final GenericHID controller;

    public OI(int controllerPort) 
    {
        controller = new XboxController(controllerPort);
    }

    public GenericHID getController() 
    {
        return controller;
    }
}