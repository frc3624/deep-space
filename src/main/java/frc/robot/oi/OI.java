package frc.robot.oi;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
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

    private final XboxController driveController;
    private final XboxController climbController;  

    private final JoystickButton placeHatchPanelButton;
    private final JoystickButton switchGearButton;

    private final JoystickButton liftFrontPistonButton, retractFrontPistonButton;
    private final JoystickButton liftBackPistonButton, retractBackPistonButton;
    private final JoystickButton retractBothLiftersButton;
    public OI(int driveControllerPort, int climbControllerPort) 
    {
        this.driveController = new XboxController(driveControllerPort);
        this.climbController = new XboxController(climbControllerPort);

        //Drive Controller Mappings
        placeHatchPanelButton = new JoystickButton(driveController, A_BUTTON);
        placeHatchPanelButton.whenPressed(new InsertHatchPanel());
        
        switchGearButton = new JoystickButton(driveController, RIGHT_BUMPER);
        switchGearButton.whenPressed(new SwitchGears());

        //Climb Controller Mappings
        retractFrontPistonButton = new JoystickButton(climbController, X_BUTTON);
        retractFrontPistonButton.whenPressed(new RetractFrontPistonsToPreviousLevel());

        liftFrontPistonButton = new JoystickButton(climbController, Y_BUTTON);
        liftFrontPistonButton.whenPressed(new LiftFrontPistonsToNextLevel());

        retractBackPistonButton = new JoystickButton(climbController, A_BUTTON);
        retractBackPistonButton.whenPressed(new RetractBackPistonsToPreviousLevel());

        liftBackPistonButton = new JoystickButton(climbController, B_BUTTON);
        liftBackPistonButton.whenPressed(new LiftBackPistonsToNextLevel());

        retractBothLiftersButton = new JoystickButton(climbController, LEFT_BUMPER); //FALLBACK/JULIANA Button
        retractBothLiftersButton.whenPressed(new RetractLiftingPistons());
    }

    public GenericHID getDriveController() 
    {
        return driveController;
    }

    public GenericHID getClimbController() 
    {
        return climbController;
    }
}