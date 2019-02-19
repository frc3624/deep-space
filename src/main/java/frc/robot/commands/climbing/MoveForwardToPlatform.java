package frc.robot.commands.climbing;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.SecondaryWheels;
import frc.robot.subsystems.SecondaryWheelsPistons;

public class MoveForwardToPlatform extends Command 
{
    private final double speed;
    public MoveForwardToPlatform(double speed)
    {
        requires(Robot.secondaryWheels);
        requires(Robot.drive);
        speed = Math.min(Math.max(speed, -1), 1);
        this.speed = speed;
    }

    @Override
    protected void initialize() 
    {
    }

    @Override
    protected void execute() 
    {
        Robot.secondaryWheels.set(speed);
        double smallMotorRPM = DriverStation.getInstance().getBatteryVoltage() * SecondaryWheels.KV_RATING * speed;
        double speed = smallMotorRPM * Math.PI * SecondaryWheels.WHEEL_RADIUS * 2;
        double sign = this.speed / (this.speed == 0 ? 1 : Math.abs(speed));
        Robot.drive.set(ControlMode.Velocity, speed);
    }

    @Override
    protected boolean isFinished() 
    {
        return Robot.distanceSensor.frontIsOnPlatform();
    }

    @Override
    protected void end() 
    {
    }

    @Override
    protected void interrupted() 
    {
    }
}
