package frc.robot.oi;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.climbing.LiftBackPistonsToNextLevel;
import frc.robot.commands.climbing.LiftFrontPistonsToNextLevel;
import frc.robot.commands.climbing.RetractBackPistonsToPreviousLevel;
import frc.robot.commands.climbing.RetractFrontPistonsToPreviousLevel;
import frc.robot.commands.climbing.RetractLiftingPistons;
import frc.robot.commands.gear.SwitchGears;
import frc.robot.commands.hatch_panel.InsertHatchPanel;

/**
 * The operator interface class. Must be intitialized AFTER all subsystems.
 */
public class OI {
    public static final int A_BUTTON = 1;
    public static final int B_BUTTON = 2;
    public static final int X_BUTTON = 3;
    public static final int Y_BUTTON = 4;
    public static final int LEFT_BUMPER = 5;
    public static final int RIGHT_BUMPER = 6;

    private XboxController driveController;
    // private XboxController climbController;  

    private Trigger placeHatchPanelButton;
    private JoystickButton switchGearButton;

    private JoystickButton liftFrontPistonButton, retractFrontPistonButton;
    private JoystickButton liftBackPistonButton, retractBackPistonButton;
    private JoystickButton retractBothLiftersButton;

    public OI(int driveControllerPort/*, int climbControllerPort*/) 
    {
        this.driveController = new XboxController(driveControllerPort);
        // this.climbController = new XboxController(climbControllerPort);

        //Drive Mappings
        placeHatchPanelButton = new XboxTriggerThreshold(driveController, Hand.kRight);
        placeHatchPanelButton.whenActive(new InsertHatchPanel());
        
        switchGearButton = new JoystickButton(driveController, RIGHT_BUMPER);
        switchGearButton.whenPressed(new SwitchGears());

        //Climb Controller Mappings
        retractFrontPistonButton = new JoystickButton(driveController, X_BUTTON);
        retractFrontPistonButton.whenPressed(new RetractFrontPistonsToPreviousLevel());

        liftFrontPistonButton = new JoystickButton(driveController, Y_BUTTON);
        liftFrontPistonButton.whenPressed(new LiftFrontPistonsToNextLevel());

        retractBackPistonButton = new JoystickButton(driveController, A_BUTTON);
        retractBackPistonButton.whenPressed(new RetractBackPistonsToPreviousLevel());

        liftBackPistonButton = new JoystickButton(driveController, B_BUTTON);
        liftBackPistonButton.whenPressed(new LiftBackPistonsToNextLevel());

        retractBothLiftersButton = new JoystickButton(driveController, LEFT_BUMPER); //FALLBACK/JULIANA Button
        retractBothLiftersButton.whenPressed(new RetractLiftingPistons());
    }

    public void setDriveMode()
    {
        
    }
    public GenericHID getDriveController() 
    {
        return driveController;
    }

    // public GenericHID getClimbController() 
    // {
    //     return climbController;
    // }
}