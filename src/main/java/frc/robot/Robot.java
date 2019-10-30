package frc.robot;

import static frc.robot.RobotConstants.BACK_PISTONS_FIRST_LEVEL_CHANNEL;
import static frc.robot.RobotConstants.BACK_PISTON_SECOND_LEVEL_CHANNEL;
import static frc.robot.RobotConstants.BACK_ULTRASONIC_SENSOR_ID;
import static frc.robot.RobotConstants.DRIVE_LEFT_TALON_1_ID;
import static frc.robot.RobotConstants.DRIVE_LEFT_TALON_2_ID;
import static frc.robot.RobotConstants.DRIVE_RIGHT_TALON_1_ID;
import static frc.robot.RobotConstants.DRIVE_RIGHT_TALON_2_ID;
import static frc.robot.RobotConstants.EVO_SHIFTER_CHANNEL;
import static frc.robot.RobotConstants.FRONT_PISTONS_FIRST_LEVEL_CHANNEL;
import static frc.robot.RobotConstants.FRONT_PISTON_SECOND_LEVEL_CHANNEL;
import static frc.robot.RobotConstants.FRONT_ULTRASONIC_SENSOR_ID;
import static frc.robot.RobotConstants.GRABBER_SHIFTER_CHANNEL;
import static frc.robot.RobotConstants.PANEL_GRABBER_PISTON_CHANNEL;
import static frc.robot.RobotConstants.PANEL_GRABBER_REVERSE_CLAW_CHANNEL;
import static frc.robot.RobotConstants.PNEUMATICS_CONTROL_MODULE_ID;
import static frc.robot.RobotConstants.SECONDARY_WHEELS_ID;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.oi.OI;
import frc.robot.subsystems.DistanceSensors;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.GearShifter;
import frc.robot.subsystems.GearShifter.GearMode;
import frc.robot.subsystems.HatchPanelGrabber;
import frc.robot.subsystems.LiftingPistons;
import frc.robot.subsystems.PneumaticGrabberShifter;
import frc.robot.subsystems.SecondaryWheels;
import frc.robot.subsystems.Vision;

public class Robot extends TimedRobot {

    public static Vision vision = new Vision();

    public static DistanceSensors distanceSensors = new DistanceSensors(FRONT_ULTRASONIC_SENSOR_ID,
            BACK_ULTRASONIC_SENSOR_ID);

    public static Drive drive = new Drive(DRIVE_LEFT_TALON_1_ID, DRIVE_LEFT_TALON_2_ID, DRIVE_RIGHT_TALON_1_ID,
            DRIVE_RIGHT_TALON_2_ID);
    public static GearShifter gearShifter = new GearShifter(PNEUMATICS_CONTROL_MODULE_ID, EVO_SHIFTER_CHANNEL);

    public static HatchPanelGrabber hatchPanelGrabber = new HatchPanelGrabber(PNEUMATICS_CONTROL_MODULE_ID,
            PANEL_GRABBER_REVERSE_CLAW_CHANNEL, PANEL_GRABBER_PISTON_CHANNEL);

    public static LiftingPistons frontLiftingPistons = new LiftingPistons(PNEUMATICS_CONTROL_MODULE_ID,
            FRONT_PISTONS_FIRST_LEVEL_CHANNEL, FRONT_PISTON_SECOND_LEVEL_CHANNEL);
    public static LiftingPistons backLiftingPistons = new LiftingPistons(PNEUMATICS_CONTROL_MODULE_ID,
            BACK_PISTONS_FIRST_LEVEL_CHANNEL, BACK_PISTON_SECOND_LEVEL_CHANNEL);
    public static SecondaryWheels secondaryWheels = new SecondaryWheels(SECONDARY_WHEELS_ID, backLiftingPistons);

    public static PneumaticGrabberShifter pneumaticGrabberShifter = new PneumaticGrabberShifter(PNEUMATICS_CONTROL_MODULE_ID, GRABBER_SHIFTER_CHANNEL);
    //public static Compressor compressor = new Compressor(PNEUMATICS_CONTROL_MODULE_ID);

    public static OI oi = new OI(0);

    @Override
    public void robotInit() {
    }

    @Override
    public void robotPeriodic() {
        updateDashboard();
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    public void resetAllSolenoids()
    {
        pneumaticGrabberShifter.raiseGrabber();
        frontLiftingPistons.fullyRetract();
        backLiftingPistons.fullyRetract();
        gearShifter.setGearMode(GearMode.LOW);
        hatchPanelGrabber.retractPiston();
        hatchPanelGrabber.openBeak();
    }

    @Override
    public void autonomousInit() 
    {
        resetAllSolenoids();
    }

    @Override
    public void autonomousPeriodic() 
    {
        commonAutoAndTeleopPeriodic();
    }
    
    @Override
    public void teleopInit() 
    {
        boolean fmsIsAttached = DriverStation.getInstance().isFMSAttached();
        if(!fmsIsAttached) //So that solenoids are not reset when sandstorm ends
        {
            resetAllSolenoids();
        }
    }

    @Override
    public void teleopPeriodic() 
    {
        commonAutoAndTeleopPeriodic();       
    }
    
    @Override
    public void testInit()
    {

    }

    @Override
    public void testPeriodic()
    {
        
    }
    /**
     * Our autonomous and teleop code shares a lot, so the shared code is in this method
     */
    private void commonAutoAndTeleopPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    public void updateDashboard()
    {
        SmartDashboard.putString("Front Pistons Level:", Integer.toString(frontLiftingPistons.getCurrentLevel().getNumericalLevel()));
        SmartDashboard.putString("Back Pistons Level:", Integer.toString(backLiftingPistons.getCurrentLevel().getNumericalLevel()));
        SmartDashboard.putString("Beak Position:", hatchPanelGrabber.getCurrentMode().toString());
        SmartDashboard.putString("Gear Mode", gearShifter.getCurrentMode().toString());
        SmartDashboard.putString("Grabber Position", pneumaticGrabberShifter.getCurrentMode().toString());
        SmartDashboard.putNumber("Front Ultrasonic Sensor", distanceSensors.getFront());
        SmartDashboard.putNumber("Back Ultrasonic Sensor", distanceSensors.getBack());
    }
}