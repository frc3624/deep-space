package frc.robot;

import static frc.robot.RobotConstants.*;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
<<<<<<< HEAD
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.HatchPanelGrabber;
import frc.robot.subsystems.Vision;
=======
import frc.robot.subsystems.*;
>>>>>>> fda95249e39f027c6e55a1d686f36a63d4878da3

public class Robot extends TimedRobot {

    public static Vision vision = new Vision();
<<<<<<< HEAD
=======
    public static DistanceSensor distanceSensor = new DistanceSensor();
>>>>>>> fda95249e39f027c6e55a1d686f36a63d4878da3

    public static Drive drive = new Drive(DRIVE_LEFT_TALON_1_ID, DRIVE_RIGHT_TALON_1_ID, 
                                            DRIVE_LEFT_TALON_2_ID, DRIVE_RIGHT_TALON_2_ID);

<<<<<<< HEAD
    public static HatchPanelGrabber hatchPanelGrabber = new HatchPanelGrabber(PNEUMATICS_CONTROL_MODULE_ID, 
                                                                                PANEL_GRABBER_REVERSE_CLAW_CHANNEL,
                                                                                PANEL_GRABBER_PISTON_CHANNEL);
=======
    public static HatchPanelGrabber hatchPanelGrabber = new HatchPanelGrabber(PNEUMATICS_CONTROL_MODULE_ID,
                                                                                PANEL_GRABBER_REVERSE_CLAW_FORWARD_CHANNEL, PANEL_GRABBER_REVERSE_CLAW_REVERSE_CHANNEL,
                                                                                PANEL_GRABBER_BOTTOM_PISTON_FORWARD_CHANNEL, PANEL_GRABBER_BOTTOM_PISTON_REVERSE_CHANNEL,
                                                                                PANEL_GRABBER_TOP_PISTON_FORWARD_CHANNEL, PANEL_GRABBER_TOP_PISTON_REVERSE_CHANNEL);
    
>>>>>>> fda95249e39f027c6e55a1d686f36a63d4878da3
    public static OI oi = new OI(0);

    @Override
    public void robotInit() {
        
    }

    @Override
    public void robotPeriodic() {

    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {
        commonAutoAndTeleopPeriodic();
    }
    
    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() {
        commonAutoAndTeleopPeriodic();
    }
    
    /**
     * Our autonomous and teleop code shares a lot, so the shared code is in this method
     */
    private void commonAutoAndTeleopPeriodic() {
        Scheduler.getInstance().run();
    }
}