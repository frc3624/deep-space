package frc.robot.subsystems;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Vision extends Subsystem
{

    @Override
    public void initDefaultCommand()
    {


    }

    private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    /*
     * These variable names are undescritive, but they correspond with table
     * entries, so Im keeping them like that
     */
    // Target visual
    private NetworkTableEntry tv = table.getEntry("tx");
    // Horizontal offset
    private NetworkTableEntry tx = table.getEntry("tx");
    // Vertical offset
    private NetworkTableEntry ty = table.getEntry("ty");
    // Target area
    private NetworkTableEntry ta = table.getEntry("ta");

    @Override
    public void periodic()
    {
        tv = table.getEntry("tv");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
    }

    public double getHorizontalOffset()
    {
        return tx.getDouble(0.0);
    }
    private double EPSILON = .1;
    public boolean isHorizontallyAligned()
    {
        return Math.abs(tx.getDouble(0.0)) < EPSILON;
    }
    public double getVerticalOffset()
    {
        return ty.getDouble(0.0);
    }
    public boolean isVerticallyAligned()
    {
        return Math.abs(ty.getDouble(0.0)) < EPSILON;
    }

    public boolean hasTargetVisual()
    {
        return tv.getBoolean(false);
    }

    private Mode mode = table.getEntry("camMode").getDouble(0) == 0 ? Mode.VISION : Mode.DRIVER;
    
    private enum Mode
    {
        VISION(0),
        DRIVER(1);

        private double value;
        Mode(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }
    public void visionMode()
    {
        mode = Mode.VISION;
        table.getEntry("camMode").setDouble(mode.getValue());
    }

    public void driverMode()
    {
        mode = Mode.DRIVER;
        table.getEntry("camMode").setDouble(mode.getValue());
    }

    private Thread usbCameraThread;

    public Thread getUSBCameraThread()
    {
        return usbCameraThread;
    }

    public void setUpUSBCamera()
    {
        usbCameraThread = new Thread(() -> {
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
		usbCameraThread.setDaemon(true);
		usbCameraThread.start();
    }
}