package frc.robot;

import static frc.robot.RobotConstants.BACK_PISTONS;
import static frc.robot.RobotConstants.BACK_PISTON_TOGGLE;
import static frc.robot.RobotConstants.BACK_ULTRASONIC_SENSOR_ID;
import static frc.robot.RobotConstants.DRIVE_LEFT_TALON_1_ID;
import static frc.robot.RobotConstants.DRIVE_LEFT_TALON_2_ID;
import static frc.robot.RobotConstants.DRIVE_RIGHT_TALON_1_ID;
import static frc.robot.RobotConstants.DRIVE_RIGHT_TALON_2_ID;
import static frc.robot.RobotConstants.EVO_SHIFTER_CHANNEL;
import static frc.robot.RobotConstants.FRONT_PISTONS;
import static frc.robot.RobotConstants.FRONT_PISTON_TOGGLE;
import static frc.robot.RobotConstants.FRONT_ULTRASONIC_SENSOR_ID;
import static frc.robot.RobotConstants.PANEL_GRABBER_PISTON_CHANNEL;
import static frc.robot.RobotConstants.PANEL_GRABBER_REVERSE_CLAW_CHANNEL;
import static frc.robot.RobotConstants.PNEUMATICS_CONTROL_MODULE_ID;
import static frc.robot.RobotConstants.SECONDARY_WHEELS_ID;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.oi.OI;
import frc.robot.subsystems.DistanceSensors;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.GearShifter;
import frc.robot.subsystems.HatchPanelGrabber;
import frc.robot.subsystems.SecondaryWheels;
import frc.robot.subsystems.SecondaryWheelsPistons;
import frc.robot.subsystems.Vision;

public class Robot extends TimedRobot {

    public static Vision vision = new Vision();
    public static DistanceSensors distanceSensor = new DistanceSensors(FRONT_ULTRASONIC_SENSOR_ID,
            BACK_ULTRASONIC_SENSOR_ID);

    public static Drive drive = new Drive(DRIVE_LEFT_TALON_1_ID, DRIVE_RIGHT_TALON_1_ID, DRIVE_LEFT_TALON_2_ID,
            DRIVE_RIGHT_TALON_2_ID);
    public static GearShifter gearShifter = new GearShifter(PNEUMATICS_CONTROL_MODULE_ID, EVO_SHIFTER_CHANNEL);

    public static HatchPanelGrabber hatchPanelGrabber = new HatchPanelGrabber(PNEUMATICS_CONTROL_MODULE_ID, 
                                                                                PANEL_GRABBER_REVERSE_CLAW_CHANNEL,
                                                                                PANEL_GRABBER_PISTON_CHANNEL);
    
    public static SecondaryWheels secondaryWheels = new SecondaryWheels(SECONDARY_WHEELS_ID);
    
    public static SecondaryWheelsPistons frontPistons = new SecondaryWheelsPistons(PNEUMATICS_CONTROL_MODULE_ID, FRONT_PISTONS, FRONT_PISTON_TOGGLE);
    public static SecondaryWheelsPistons backPistons = new SecondaryWheelsPistons(PNEUMATICS_CONTROL_MODULE_ID, BACK_PISTONS, BACK_PISTON_TOGGLE);
    public static int currentLevel = 0;

    public static OI oi = new OI(0, 1);

    public static AHRS ahrs;
    Compressor mainCompressor = new Compressor(14);
    @Override
    public void robotInit() {
        mainCompressor.start();

        ahrs = new AHRS(SerialPort.Port.kUSB);
        //ahrs = new AHRS(SerialPort.Port.kMXP, SerialDataType.kProcessedData, (byte)50);
        ahrs.enableLogging(true);
    }

    @Override
    public void robotPeriodic() {
        mainCompressor.setClosedLoopControl(true);
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
    public void autonomousPeriodic() 
    {
        commonAutoAndTeleopPeriodic();
    }
    
    @Override
    public void teleopInit() 
    {
        
    }

    @Override
    public void teleopPeriodic() 
    {
        commonAutoAndTeleopPeriodic();
    }
    
    /**
     * Our autonomous and teleop code shares a lot, so the shared code is in this method
     */
    private void commonAutoAndTeleopPeriodic() 
    {
        SmartDashboard.putNumber("Front Pistons Level:", frontPistons.getCurrentLevel());
        SmartDashboard.putNumber("Back Pistons Level:", backPistons.getCurrentLevel());
        SmartDashboard.putString("Beak Position:", (hatchPanelGrabber.isOpen()) ? "Open" : "Closed");
        Scheduler.getInstance().run();
    }
}