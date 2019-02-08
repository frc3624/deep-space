package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.CargoGrabber;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.HatchLifter;
import frc.robot.subsystems.Level3LifterWheels;

public class Robot extends TimedRobot {

    public static final int PNEUMATICS_CONTROL_MODULE_ID = 3; //Placed in the robot class because it is used by multiple subsystems

    public static Drive drive;
    public static Level3LifterWheels level3LifterWheels;
    public static CargoGrabber cargoGrabber;
    public static HatchLifter hatchLifter;
    public static OI oi;

    @Override
    public void robotInit() {
        initializeSubsystemsAndOI();
    }

    private void initializeSubsystemsAndOI() {
        drive = new Drive();
        level3LifterWheels = new Level3LifterWheels();
        cargoGrabber = new CargoGrabber();
        hatchLifter = new HatchLifter();
        oi = new OI();
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

    }
    
    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}