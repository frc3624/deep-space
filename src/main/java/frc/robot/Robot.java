package frc.robot;

import static frc.robot.RobotConstants.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.DistanceSensor;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.HatchPanelGrabber;
import frc.robot.subsystems.SecondaryWheels;
import frc.robot.subsystems.SecondaryWheelsPistons;
import frc.robot.subsystems.Vision;

public class Robot extends TimedRobot {

    public static Vision vision = new Vision();
    public static DistanceSensor distanceSensor = new DistanceSensor();

    public static Drive drive = new Drive(DRIVE_LEFT_TALON_1_ID, DRIVE_RIGHT_TALON_1_ID, 
                                            DRIVE_LEFT_TALON_2_ID, DRIVE_RIGHT_TALON_2_ID);

    public static HatchPanelGrabber hatchPanelGrabber = new HatchPanelGrabber(PNEUMATICS_CONTROL_MODULE_ID, 
                                                                                PANEL_GRABBER_REVERSE_CLAW_CHANNEL,
                                                                                PANEL_GRABBER_PISTON_CHANNEL);
    
    public static SecondaryWheels secondaryWheels = new SecondaryWheels(SECONDARY_WHEELS_FRONT_ID);
    public static SecondaryWheelsPistons frontPistons = new SecondaryWheelsPistons(PNEUMATICS_CONTROL_MODULE_ID, FRONT_PISTONS);
    public static SecondaryWheelsPistons backPistons = new SecondaryWheelsPistons(PNEUMATICS_CONTROL_MODULE_ID, BACK_PISTONS);

    public static OI oi = new OI(0);
    Compressor compressor = new Compressor(14);
    @Override
    public void robotInit() {
        compressor.start();
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
    
    private void commonAutoAndTeleopPeriodic() {
        Scheduler.getInstance().run();
    }
}