package org.usfirst.frc.team1318.robot.Shooter;

import org.usfirst.frc.team1318.robot.ElectronicsConstants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;

public class ShooterComponent
{
    private final Talon shooterMotor;
    private final DoubleSolenoid firingPin;
    private final Encoder shooterEncoder;

    public ShooterComponent()
    {
        this.shooterMotor = new Talon(ElectronicsConstants.SHOOTER_MOTOR_CHANNEL);
        this.firingPin = new DoubleSolenoid(ElectronicsConstants.SHOOTER_FIRING_PIN_CHANNEL_A,
            ElectronicsConstants.SHOOTER_FIRING_PIN_CHANNEL_B);
        this.shooterEncoder = new Encoder(ElectronicsConstants.SHOOTER_ENCODER_CHANNEL_A,
            ElectronicsConstants.SHOOTER_ENCODER_CHANNEL_B);
    }

    public void setMotorSpeed(double speed)
    {
        this.shooterMotor.set(speed);
    }

    public double getMotorSpeed()
    {
        return this.shooterEncoder.get();
    }

    // True extends, false retracts
    public void extendFiringPin(boolean extend)
    {
        if (extend)
        {
            this.firingPin.set(Value.kForward);
        }
        else
        {
            this.firingPin.set(Value.kReverse);
        }
    }

    public void stop()
    {
        this.shooterMotor.set(0.0);
        this.firingPin.set(Value.kOff);
    }
}
