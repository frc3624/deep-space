package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Vision extends Subsystem
{

    @Override
    public void initDefaultCommand()
    {


    }

    private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    /*
     * These variable names are undescritive, but they correspond with table entries, so Im keeping them like that
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

}