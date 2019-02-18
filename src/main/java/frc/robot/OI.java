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
    private final JoystickButton hatchGrabberToggle;
    private final JoystickButton switchToHighGear, switchToLowGear;

    public OI(int controllerPort) 
    {
        controller = new XboxController(controllerPort);

        hatchGrabberToggle = new JoystickButton(controller, 1);
        hatchGrabberToggle.whenPressed(new InsertHatchPanel());

        switchToHighGear = new JoystickButton(controller, 5);
        switchToLowGear = new JoystickButton(controller, 6);
    }

    public GenericHID getController() 
    {
        return controller;
    }
}