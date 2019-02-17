package frc.robot;

import static frc.robot.RobotConstants.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.HatchPanelGrabber;
import frc.robot.subsystems.Vision;

public class Robot extends TimedRobot {

    public static Vision vision = new Vision();

    public static Drive drive = new Drive(DRIVE_LEFT_TALON_1_ID, DRIVE_RIGHT_TALON_1_ID, 
                                            DRIVE_LEFT_TALON_2_ID, DRIVE_RIGHT_TALON_2_ID);

    public static HatchPanelGrabber hatchPanelGrabber = new HatchPanelGrabber(PNEUMATICS_CONTROL_MODULE_ID, 
                                                                                PANEL_GRABBER_REVERSE_CLAW_CHANNEL,
                                                                                PANEL_GRABBER_PISTON_CHANNEL);
    public static OI oi = new OI(0);

    Compressor c = new Compressor(14); //TEMP
    @Override
    public void robotInit() {
        c.start();
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