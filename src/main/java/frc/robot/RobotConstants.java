package frc.robot;

public final class RobotConstants 
{
    private RobotConstants() {
    }

    // Drive Subsystem
    public static final int DRIVE_LEFT_TALON_1_ID = 1;
    public static final int DRIVE_RIGHT_TALON_1_ID = 2;

    public static final int DRIVE_LEFT_TALON_2_ID = 7;
    public static final int DRIVE_RIGHT_TALON_2_ID = 8;

    // SecondaryWheels Subsystem
    public static final int SECONDARY_WHEELS_ID = 3;

    //Ultrasonic Sensor
    public static final int FRONT_ULTRASONIC_SENSOR_ID = 0;
    public static final int BACK_ULTRASONIC_SENSOR_ID = 1;

    // Pneumatics - Used by multiple subsystems
    public static final int PNEUMATICS_CONTROL_MODULE_ID = 14;

    // GearShifter Subsystem
    public static final int EVO_SHIFTER_CHANNEL = 0;

    // HatchPanelGrabber Subsystem
    public static final int PANEL_GRABBER_REVERSE_CLAW_CHANNEL = 1;
    public static final int PANEL_GRABBER_PISTON_CHANNEL = 2;

    // SecondaryWheelsPistons Subsystem
    public static final int FRONT_PISTONS = 3;
    public static final int FRONT_PISTON_TOGGLE = 5;
    public static final int BACK_PISTONS = 4;
    public static final int BACK_PISTON_TOGGLE = 6;
}