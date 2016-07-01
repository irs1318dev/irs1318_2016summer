package org.usfirst.frc.team1318.robot.Shooter;

import org.usfirst.frc.team1318.robot.Common.IController;
import org.usfirst.frc.team1318.robot.Driver.Driver;
import org.usfirst.frc.team1318.robot.Driver.Operation;

public class ShooterController implements IController
{
    private final ShooterComponent shooter;
    private Driver driver;

    public ShooterController(ShooterComponent shooter)
    {
        this.shooter = shooter;
    }

    @Override
    public void update()
    {
        double shooterSpeed = 0.0;

        if (this.driver.getDigital(Operation.ShooterSpin))
        {
            shooterSpeed = this.driver.getAnalog(Operation.ShooterSpeed);
        }

        this.shooter.setMotorSpeed(shooterSpeed);

        if (this.driver.getDigital(Operation.ShooterFiringPinRetract))
        {
            this.shooter.extendFiringPin(false);
        }
        else if (this.driver.getDigital(Operation.ShooterFiringPinExtend))
        {
            this.shooter.extendFiringPin(true);
        }

    }

    @Override
    public void stop()
    {
        this.shooter.stop();
    }

    @Override
    public void setDriver(Driver driver)
    {
        this.driver = driver;
    }
}
