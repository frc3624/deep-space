/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.oi;

import java.util.EnumSet;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * Add your docs here.
 */
public class DPadTrigger extends Trigger {
  
    public enum DPadDirection
    {
        NONE(-1),
        UP(0 * 45), //0
        UP_RIGHT(1 * 45), //45
        RIGHT(2 * 45), //90
        DOWN_RIGHT(3 * 45), //135
        DOWN(4 * 45), //180
        DOWN_LEFT(5 * 45), //225
        LEFT(6 * 45), //270
        UP_LEFT(7 * 45); //315

        private int angle;

        DPadDirection(int angle)
        {
            this.angle = angle;
        }

        public int getAngle()
        {
            return angle;
        }
    }

    private GenericHID controller;
    private EnumSet<DPadDirection> directions;

    /**
     * Sets up the trigger for a specified controller and directions
     * @param controller - the controller which the D-Pad is being testing on
     * @param directions - the directions which will activate this trigger. This is an enumset so that multiple directipns can activate the trigger.
     */
    public DPadTrigger(GenericHID controller, EnumSet<DPadDirection> directions)
    {
        this.controller = controller;
        this.directions = directions;
    }

    @Override
    public boolean get() {
        for (DPadDirection direction : directions)
        {
            if(direction.getAngle() == controller.getPOV())
            {
                return true;
            }
        }

        return false;
    }
}
