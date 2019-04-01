package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class LiftingPistons extends Subsystem 
{
    public enum LiftingPistonLevel 
    {
      ZERO(0, false, false),
      ONE(1, true, false),
      TWO(2, false, false); //Both values set to false in case this is accidentally activated

      private final int numericalLevel;
      private final boolean mainValvePosition;
      private final boolean secondValvePosition;

      LiftingPistonLevel(int numericalLevel, boolean mainValvePosition, boolean secondValvePosition)
      {
        this.numericalLevel = numericalLevel;
        this.mainValvePosition = mainValvePosition;
        this.secondValvePosition = secondValvePosition;
      }

      public int getNumericalLevel()
      {
        return numericalLevel;
      }

      public LiftingPistonLevel nextLevel()
      {
        switch(this)
        {
          case ZERO:
            return ONE;
          // case ONE:
          //   return TWO;
          default:
            return this;
        }
      }

      public LiftingPistonLevel previousLevel()
      {
        switch(this)
        {
          case ONE:
            return ZERO;
          case TWO:
            return ONE;
          default:
            return this;
        }
      }

      public boolean getMainValvePosition()
      {
        return mainValvePosition;
      }

      public boolean getSecondValvePosition()
      {
        return secondValvePosition;
      }
    }

    private Solenoid mainLeftValve;
    private Solenoid mainRightValve;

    private Solenoid secondLeftValve;
    private Solenoid secondRightValve;
    private LiftingPistonLevel currentLevel;

    public LiftingPistons(int pcmID, int mainChannel, int toggleChannel)
    {
        mainLeftValve = new Solenoid(pcmID, mainChannel);
        mainRightValve = mainLeftValve;

        secondLeftValve = new Solenoid(pcmID, toggleChannel);
        secondRightValve = secondLeftValve;
        setLevel(LiftingPistonLevel.ZERO);
    }

    public LiftingPistons(int pcmID, int mainLeftChannel, int toggleLeftChannel, int mainRightChannel, int toggleRightChannel)
    {
        mainLeftValve = new Solenoid(pcmID, mainLeftChannel);
        mainRightValve = new Solenoid(pcmID, mainRightChannel);

        secondLeftValve = new Solenoid(pcmID, toggleLeftChannel);
        secondRightValve = new Solenoid(pcmID, toggleRightChannel);
        setLevel(LiftingPistonLevel.ZERO);
    }

    public LiftingPistonLevel getCurrentLevel()
    {
        return currentLevel;
    }

    public void setLevel(LiftingPistonLevel level)
    {
      setMainValves(level.getMainValvePosition());
      setSecondValves(level.getSecondValvePosition());
      this.currentLevel = level;
    }

    public void nextLevel()
    {
        setLevel(currentLevel.nextLevel());
    }

    public void previousLevel()
    {
        setLevel(currentLevel.previousLevel());
    }

    public void fullyRetract()
    {
        setLevel(LiftingPistonLevel.ZERO);
    }

    public void liftToLevel1()
    {
        setLevel(LiftingPistonLevel.ONE);
    }

    public void liftToLevel2()
    {
        setLevel(LiftingPistonLevel.TWO);
    }

    private void setMainValves(boolean value) 
    {
        mainLeftValve.set(value);
        mainRightValve.set(value);
    }

    private void setSecondValves(boolean value) 
    {
        secondLeftValve.set(value);
        secondRightValve.set(value);
    }

    @Override
    public void initDefaultCommand() 
    {

    }

}
