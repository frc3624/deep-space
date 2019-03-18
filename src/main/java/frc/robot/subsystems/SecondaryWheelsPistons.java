package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SecondaryWheelsPistons extends Subsystem 
{
    private final Solenoid mainPiston;
    private final Solenoid secondValve;
    private int currentLevel;
    
    public SecondaryWheelsPistons(int pcmID, int mainChannel, int toggleChannel)
    {
        currentLevel = 0;
        mainPiston = new Solenoid(pcmID, mainChannel);
        secondValve = new Solenoid(pcmID, toggleChannel);
    }

    public int getCurrentLevel()
    {
        return currentLevel;
    }

    public void nextLevel()
    {
        if(currentLevel == 0)
        {
            liftToLevel1();
        }
        else if (currentLevel == 1)
        {
            liftToLevel2();
        }
    }

    public void previousLevel()
    {
        if (currentLevel == 1)
        {
            fullyRetract();
        }
        else if (currentLevel == 2)
        {
            liftToLevel1();
        }
    }

    public void fullyRetract()
    {
        currentLevel = 0;
        disableLevel1Valve();
        disableLevel2Valve();
    }

    public void liftToLevel1()
    {
        currentLevel = 1;
        enableLevel1Valve();
        disableLevel2Valve();
    }

    public void liftToLevel2()
    {
        // currentLevel = 2;
        // enableLevel1Valve();
        // enableLevel2Valve();
    }

    public void enableLevel1Valve() 
    {
        mainPiston.set(true);
    }

    public void disableLevel1Valve() 
    {
        mainPiston.set(false);
    }

    public void enableLevel2Valve() {
        secondValve.set(true);
    }

    public void disableLevel2Valve() {
        secondValve.set(false);
    }

    @Override
    public void initDefaultCommand() 
    {

    }
    
}
