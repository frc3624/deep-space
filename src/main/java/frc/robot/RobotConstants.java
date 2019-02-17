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

    // HatchLifter Subsystem
    public static final int HATCH_LIFTER_TALON_ID = 3;

    //

    // CargoGrabber Subsystem
    public static final int CARGO_GRABBER_LEFT_WHEELS_ID = -1;
    public static final int CARGO_GRABBER_RIGHT_WHEELS_ID = -1;

    // Pneumatics - Used by multiple subsystems
    public static final int PNEUMATICS_CONTROL_MODULE_ID = 3;

    // HatchPanelGrabber Subsystem
    public static final int PANEL_GRABBER_REVERSE_CLAW_FORWARD_CHANNEL = 0;
    public static final int PANEL_GRABBER_REVERSE_CLAW_REVERSE_CHANNEL = 1;

    public static final int PANEL_GRABBER_BOTTOM_PISTON_FORWARD_CHANNEL = 2;
    public static final int PANEL_GRABBER_BOTTOM_PISTON_REVERSE_CHANNEL = 3;

    public static final int PANEL_GRABBER_TOP_PISTON_FORWARD_CHANNEL = 4;
    public static final int PANEL_GRABBER_TOP_PISTON_REVERSE_CHANNEL = 5;

    // SecondaryWheels Subsystem
    public static final int SECONDARY_WHEELS_FRONT_WHEELS_ID = -1;
    public static final int SECONDARY_WHEELS_BACK_WHEELS_ID = -1;

    // SecondaryWheelsPistons Subsystem
}