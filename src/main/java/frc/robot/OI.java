package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The operator interface class. Must be intitialized AFTER all subsystems.
 */
public class OI {
    
    private final XboxController controller = new XboxController(0);

    public OI() {
        
    }

    public GenericHID getController() {
        return controller;
    }
}