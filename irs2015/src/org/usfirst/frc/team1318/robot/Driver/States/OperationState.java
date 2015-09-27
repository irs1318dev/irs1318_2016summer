package org.usfirst.frc.team1318.robot.Driver.States;

import org.usfirst.frc.team1318.robot.Driver.Descriptions.AnalogOperationDescription;
import org.usfirst.frc.team1318.robot.Driver.Descriptions.DigitalOperationDescription;
import org.usfirst.frc.team1318.robot.Driver.Descriptions.OperationDescription;

import edu.wpi.first.wpilibj.Joystick;

public abstract class OperationState
{
    private final OperationDescription description;

    protected OperationState(OperationDescription description)
    {
        this.description = description;
    }

    protected OperationDescription getDescription()
    {
        return this.description;
    }

    /**
     * Sets whether the current operation is being interrupted by a macro
     * @param enable value of true indicates that we are interrupted
     */
    public abstract void setInterrupt(boolean enable);

    /**
     * Update the operation state based on the driver and co-driver joysticks 
     * @param driver joystick to update from
     * @param coDriver joystick to update from
     */
    public abstract void update(Joystick driver, Joystick coDriver);

    /**
     * Create the state corresponding to the description
     * @param description to use for creating the state
     * @return state corresponding to the description
     */
    public static OperationState createFromDescription(OperationDescription description)
    {
        if (description instanceof AnalogOperationDescription)
        {
            return new AnalogOperationState((AnalogOperationDescription)description);
        }
        else if (description instanceof DigitalOperationDescription)
        {
            return new DigitalOperationState((DigitalOperationDescription)description);
        }

        throw new RuntimeException("unknown type of description " + description.getClass().getName());
    }
}