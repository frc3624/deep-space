package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.InsertHatchPanel;

/**
 * The operator interface class. Must be intitialized AFTER all subsystems.
 */
public class OI 
    {

    
    private final GenericHID controller;
    private final JoystickButton button1;

    public OI(int controllerPort) 
    {
        controller = new XboxController(controllerPort);
        
        button1 = new JoystickButton(controller, 1);
        button1.whenPressed(new InsertHatchPanel());
    }

    public GenericHID getController() 
    {
        return controller;
    }
}