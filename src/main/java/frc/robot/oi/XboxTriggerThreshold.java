/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.oi;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * Add your docs here.
 */
public class XboxTriggerThreshold extends Trigger 
{
  public static final double DEFAULT_THRESHOLD = 0.6;
  private final Hand hand;
  private final XboxController controller;
  private final double activationThreshold;

  public XboxTriggerThreshold(XboxController controller, Hand triggerHand)
  {
    this(controller, triggerHand, DEFAULT_THRESHOLD);
  }

  public XboxTriggerThreshold(XboxController controller, Hand hand, double activationThreshold)
  {
    this.controller = controller;
    this.hand = hand;
    this.activationThreshold = activationThreshold;
  }

  @Override
  public boolean get()
  {
    return controller.getTriggerAxis(hand) > activationThreshold;
  }
}
