package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Vision extends Subsystem {

    @Override
    public void initDefaultCommand() {

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
    public void periodic() {
        tv = table.getEntry("tv");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
    }

    public double getHorizontalOffset() {
        return tx.getDouble(0.0);
    }
    private double EPSILON = .1;
    public boolean isHorizontallyAligned() {
        return Math.abs(tx.getDouble(0.0)) < EPSILON;
    }
    public double getVerticalOffset() {
        return ty.getDouble(0.0);
    }
    public boolean isVerticallyAligned() {
        return Math.abs(ty.getDouble(0.0)) < EPSILON;
    }

    public boolean hasTargetVisual() {
        return tv.getBoolean(false);
    }

    private double VISION_MODE = 0, DRIVER_MODE = 1;
    public void visionMode() {
        table.getEntry("camMode").setDouble(VISION_MODE);
    }
    public void driverMode() {
        table.getEntry("camMode").setDouble(DRIVER_MODE);
    }

}