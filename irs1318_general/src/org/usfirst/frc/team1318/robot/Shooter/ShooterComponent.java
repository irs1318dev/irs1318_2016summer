package org.usfirst.frc.team1318.robot.Shooter;

import org.usfirst.frc.team1318.robot.ElectronicsConstants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Talon;

/**
 * Component for shooter, includes a talon and a poker to shoot the ball
 * @author William
 *
 */

// firing pin == fp
public class ShooterComponent
{
    private final DoubleSolenoid fp;
    private final Talon talon;

    public ShooterComponent()
    {
        this.fp = new DoubleSolenoid(ElectronicsConstants.FIRING_PIN_CHANNEL_A, ElectronicsConstants.FIRING_PIN_CHANNEL_B);
        this.talon = new Talon(ElectronicsConstants.SHOOTER_TALON_CHANNEL);
    }

    public void setShooterSpeed(double speed)
    {
        this.talon.set(speed);
    }

    /**
     * Extends or retracts the firing pin
     * 
     * @param extend - true extends, false retracts
     */
    public void extendFiringPin(boolean extend)
    {
        if (extend)
        {
            this.fp.set(Value.kForward);
        }
        else
        {
            this.fp.set(Value.kReverse);
        }
    }

    public void stop()
    {
        this.fp.set(Value.kOff);
        this.talon.set(0.0);
    }
}
