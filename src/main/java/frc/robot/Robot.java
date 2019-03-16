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

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.oi.OI;
import frc.robot.subsystems.DistanceSensors;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.GearShifter;
import frc.robot.subsystems.GearShifter.GearMode;
import frc.robot.subsystems.HatchPanelGrabber;
import frc.robot.subsystems.SecondaryWheels;
import frc.robot.subsystems.SecondaryWheelsPistons;
import frc.robot.subsystems.Vision;

public class Robot extends TimedRobot {

    public static Vision vision = new Vision();
    public static DistanceSensors distanceSensor = new DistanceSensors(FRONT_ULTRASONIC_SENSOR_ID,
            BACK_ULTRASONIC_SENSOR_ID);

    public static Drive drive = new Drive(DRIVE_LEFT_TALON_1_ID, DRIVE_LEFT_TALON_2_ID, DRIVE_RIGHT_TALON_1_ID,
            DRIVE_RIGHT_TALON_2_ID);
    public static GearShifter gearShifter = new GearShifter(PNEUMATICS_CONTROL_MODULE_ID, EVO_SHIFTER_CHANNEL);

    public static HatchPanelGrabber hatchPanelGrabber = new HatchPanelGrabber(PNEUMATICS_CONTROL_MODULE_ID,
            PANEL_GRABBER_REVERSE_CLAW_CHANNEL, PANEL_GRABBER_PISTON_CHANNEL);
    
    public static SecondaryWheels secondaryWheels = new SecondaryWheels(SECONDARY_WHEELS_ID);
    
    public static SecondaryWheelsPistons frontPistons = new SecondaryWheelsPistons(PNEUMATICS_CONTROL_MODULE_ID, FRONT_PISTONS, FRONT_PISTON_TOGGLE);
    public static SecondaryWheelsPistons backPistons = new SecondaryWheelsPistons(PNEUMATICS_CONTROL_MODULE_ID, BACK_PISTONS, BACK_PISTON_TOGGLE);
    public static int currentLevel = 0;

    public static OI oi = new OI(0);

    public static AHRS ahrs;
    Compressor mainCompressor = new Compressor(14);
    @Override
    public void robotInit() {
        mainCompressor.start();

        ahrs = new AHRS(SerialPort.Port.kUSB);
        //ahrs = new AHRS(SerialPort.Port.kMXP, SerialDataType.kProcessedData, (byte)50);
        ahrs.enableLogging(true);
        // setUpCamera();
    }


    @Override
    public void robotPeriodic() {
        mainCompressor.setClosedLoopControl(true);
    }

    @Override
    public void disabledInit() {
        resetAllSolenoids();
    }

    @Override
    public void disabledPeriodic() {

    }

    public void resetAllSolenoids()
    {
        frontPistons.fullyRetract();
        backPistons.fullyRetract();
        gearShifter.setGearMode(GearMode.LOW);
        hatchPanelGrabber.retractPiston();
        hatchPanelGrabber.openClaw();
    }

    @Override
    public void autonomousInit() 
    {
        resetAllSolenoids();
        // drive.resetLeftReading();
        // drive.resetRightReading();
    }

    @Override
    public void autonomousPeriodic() 
    {
        commonAutoAndTeleopPeriodic();
    }
    
    @Override
    public void teleopInit() 
    {
        resetAllSolenoids();
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
        SmartDashboard.putString("Front Pistons Level:", Integer.toString(frontPistons.getCurrentLevel()));
        SmartDashboard.putString("Back Pistons Level:", Integer.toString(backPistons.getCurrentLevel()));
        SmartDashboard.putString("Beak Position:", (hatchPanelGrabber.isOpen()) ? "Open" : "Closed");
        // SmartDashboard.putString("Left Encoder Reading:", Integer.toString(drive.getLeftReading()));
        // SmartDashboard.putString("Right Encoder Reading:", Integer.toString(drive.getRightReading()));
        SmartDashboard.putString("Gear Mode", gearShifter.getCurrentMode().toString());
        Scheduler.getInstance().run();
    }

    public static Thread visionThread;
    public static void setUpCamera()
    {
        visionThread = new Thread(() -> {
			// Get the UsbCamera from CameraServer
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setResolution(640, 480);

			// Get a CvSink. This will capture Mats from the camera
			CvSink cvSink = CameraServer.getInstance().getVideo();
			// Setup a CvSource. This will send images back to the Dashboard
			CvSource outputStream = CameraServer.getInstance().putVideo("Rectangle", 640, 480);

			Mat mat = new Mat();

			while (!Thread.interrupted()) {
				// Tell the CvSink to grab a frame from the camera and put it
				// in the source mat.  If there is an error notify the output.
				if (cvSink.grabFrame(mat) == 0) {
					// Send the output the error.
					outputStream.notifyError(cvSink.getError());
					// skip the rest of the current iteration
					continue;
				}
				// Put a rectangle on the image
				Imgproc.rectangle(mat, new Point(100, 100), new Point(400, 400),
						new Scalar(255, 255, 255), 5);
				// Give the output stream a new image to display
				outputStream.putFrame(mat);
			}
		});
		visionThread.setDaemon(true);
		visionThread.start();
    }
}