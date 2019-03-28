/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class PneumaticGrabberShifter extends Subsystem {
    
    public enum GrabberMode
    {
        UP(false),
        DOWN(true);

        private boolean value;
        GrabberMode(boolean value)
        {
            this.value = value;
        }

        public boolean getValue()
        {
            return value;
        }

        public GrabberMode getOppositeMode()
        {
            return (this == UP) ? DOWN : UP;
        }

        @Override
        public String toString()
        {
            return (this == UP) ? "UP" : "DOWN";
        }
    }
    
    /**
     * Add your docs here.
     */
    private final Solenoid shifterPistonSolenoid;
    private GrabberMode currentMode;
    public PneumaticGrabberShifter(int pcmID, int shifterPistonChannel) 
    {
        shifterPistonSolenoid = new Solenoid(pcmID, shifterPistonChannel);
        setMode(GrabberMode.UP);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void raiseGrabber()
    {
        setMode(GrabberMode.UP);
    }

    public void dropGrabber()
    {
        setMode(GrabberMode.DOWN);
    }

    public GrabberMode getCurrentMode()
    {
        return currentMode;
    }

    public void setMode(GrabberMode mode)
    {
        this.currentMode = mode;
        shifterPistonSolenoid.set(mode.getValue());
    }
}
