package frc.robot.oi;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.climbing.LiftToLevel2;
import frc.robot.commands.climbing.RetractBackPistonLevel2;
import frc.robot.commands.climbing.RetractFrontPistonLevel2;
import frc.robot.commands.gear.SwitchGears;
import frc.robot.commands.hatch_panel.InsertHatchPanel;

/**
 * The operator interface class. Must be intitialized AFTER all subsystems.
 */
public class OI {

    private  GenericHID controller;
    private  JoystickButton switchGearsButton;
    private  JoystickButton liftToLevel2Button, liftToLevel3Button;
    private JoystickButton retractFrontPistonsButton, retractBackPistonsButton;
    private  JoystickButton retractLiftingPistonsButton;
    private  JoystickButton insertHatchPanel;
    private  XboxTriggerThreshold enableBackLiftersTrigger, enableFrontLiftersTrigger;
    private  NotTriggered disableBackLiftersTrigger, disableFrontLiftersTrigger;

    public OI(int controllerPort) 
    {
        this.controller = new XboxController(controllerPort);

        insertHatchPanel = new JoystickButton(controller, 1);
        insertHatchPanel.whenPressed(new InsertHatchPanel());

        // liftToLevel3Button = new JoystickButton(controller, 2);
        // liftToLevel3Button.whenPressed(new LiftToLevel3(0));
        // liftToLevel2Button = new JoystickButton(controller, 3);
        // liftToLevel2Button.whenPressed(new ClimbToLevel2());
        liftToLevel2Button = new JoystickButton(controller, 3);
        liftToLevel2Button.whenPressed(new LiftToLevel2());

        retractFrontPistonsButton = new JoystickButton(controller, 4);
        retractFrontPistonsButton.whenPressed(new RetractFrontPistonLevel2());

        retractBackPistonsButton = new JoystickButton(controller, 2);
        retractBackPistonsButton.whenPressed(new RetractBackPistonLevel2());

        // retractLiftingPistonsButton = new JoystickButton(controller, 4);
        // retractLiftingPistonsButton.whenPressed(new RetractLiftingPistons());

        switchGearsButton = new JoystickButton(controller, 6);
        switchGearsButton.whenPressed(new SwitchGears());
        
        //UGLY - Change later if we have the time. I now understand why previous years' code looks awful.
        // Command runBackLifter = new RunBackLifter();
        // enableBackLiftersTrigger = new XboxTriggerThreshold((XboxController) controller, Hand.kLeft);
        // enableBackLiftersTrigger.whenActive(runBackLifter);
        // disableBackLiftersTrigger = new NotTriggered(enableBackLiftersTrigger);
        // disableBackLiftersTrigger.cancelWhenActive(runBackLifter);

        // Command runFrontLifter = new RunFrontLifter();
        // enableFrontLiftersTrigger = new XboxTriggerThreshold((XboxController) controller, Hand.kRight);
        // enableFrontLiftersTrigger.whenActive(runFrontLifter);
        // disableFrontLiftersTrigger = new NotTriggered(enableFrontLiftersTrigger);
        // disableFrontLiftersTrigger.cancelWhenActive(runFrontLifter);
    }

    public GenericHID getController() 
    {
        return controller;
    }
}