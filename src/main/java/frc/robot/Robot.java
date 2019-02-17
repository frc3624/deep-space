package frc.robot;

import static frc.robot.RobotConstants.*;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {

    public static Vision vision = new Vision();
    public static DistanceSensor distanceSensor = new DistanceSensor();

    public static Drive drive = new Drive(DRIVE_LEFT_TALON_1_ID, DRIVE_RIGHT_TALON_1_ID, 
                                            DRIVE_LEFT_TALON_2_ID, DRIVE_RIGHT_TALON_2_ID);

    public static HatchPanelGrabber hatchPanelGrabber = new HatchPanelGrabber(PNEUMATICS_CONTROL_MODULE_ID,
                                                                                PANEL_GRABBER_REVERSE_CLAW_FORWARD_CHANNEL, PANEL_GRABBER_REVERSE_CLAW_REVERSE_CHANNEL,
                                                                                PANEL_GRABBER_BOTTOM_PISTON_FORWARD_CHANNEL, PANEL_GRABBER_BOTTOM_PISTON_REVERSE_CHANNEL,
                                                                                PANEL_GRABBER_TOP_PISTON_FORWARD_CHANNEL, PANEL_GRABBER_TOP_PISTON_REVERSE_CHANNEL);
    
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