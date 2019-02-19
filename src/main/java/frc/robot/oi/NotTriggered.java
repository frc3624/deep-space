/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.oi;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * Returns true when another trigger is NOT triggered
 */
public class NotTriggered extends Trigger 
{
  private final Trigger trigger;

  public NotTriggered(Trigger trigger)
  {
    this.trigger = trigger;
  }

  @Override
  public boolean get() 
  {
    return !trigger.get();
  }
}
