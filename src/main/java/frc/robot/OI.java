package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.GrabHatchPanel;
import frc.robot.commands.InsertHatchPanel;
import frc.robot.commands.climbing.LiftToLevel2;
import frc.robot.commands.climbing.LiftToLevel3;
import frc.robot.commands.climbing.RetractPistons;
import frc.robot.commands.gear.SwitchToHighGear;
import frc.robot.commands.gear.SwitchToLowGear;

/**
 * The operator interface class. Must be intitialized AFTER all subsystems.
 */
public class OI 
{
   
    private final GenericHID controller;
    private final JoystickButton insertHatchPanel, grabHatchPanel;
    private final JoystickButton switchToHighGear, switchToLowGear;
    private final JoystickButton lift;
    private final JoystickButton retract;

    public OI(int controllerPort) 
    {
        controller = new XboxController(controllerPort);

        insertHatchPanel = new JoystickButton(controller, 1);
        insertHatchPanel.whenPressed(new InsertHatchPanel());

        grabHatchPanel = new JoystickButton(controller, 2);
        grabHatchPanel.whenPressed(new GrabHatchPanel());

        switchToHighGear = new JoystickButton(controller, 5);
        switchToHighGear.whenPressed(new SwitchToHighGear());
        switchToLowGear = new JoystickButton(controller, 6);
        switchToLowGear.whenPressed(new SwitchToLowGear());

        lift = new JoystickButton(controller, 3);
        lift.whenPressed(new LiftToLevel3(5));

        retract = new JoystickButton(controller, 4);
        retract.whenPressed(new RetractPistons());
    }

    public GenericHID getController() 
    {
        return controller;
    }
}