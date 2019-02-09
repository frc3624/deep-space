package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {

    public static final int PNEUMATICS_CONTROL_MODULE_ID = 3; //Placed in the Robot class because it is used by multiple subsystems

    public static Vision vision = new Vision();

    public static Drive drive = new Drive();
    public static SecondaryWheels secondaryWheels = new SecondaryWheels();
    public static CargoGrabber cargoGrabber = new CargoGrabber();
    public static HatchLifter hatchLifter = new HatchLifter();

    public static OI oi = new OI();

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