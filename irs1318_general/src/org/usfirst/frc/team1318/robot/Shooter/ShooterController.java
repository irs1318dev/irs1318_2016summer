package org.usfirst.frc.team1318.robot.Shooter;

import org.usfirst.frc.team1318.robot.TuningConstants;
import org.usfirst.frc.team1318.robot.Common.IController;
import org.usfirst.frc.team1318.robot.Common.PIDHandler;
import org.usfirst.frc.team1318.robot.Driver.Driver;
import org.usfirst.frc.team1318.robot.Driver.Operation;

/**
 * Controller for the shooter
 * @author William
 *
 */

public class ShooterController implements IController
{

    private final ShooterComponent shooter;

    private Driver driver;
    private PIDHandler PID;

    public ShooterController(ShooterComponent shooter)
    {
        this.shooter = shooter;

        this.createPIDHandler();
    }

    @Override
    public void update()
    {
        // TODO Auto-generated method stub
        boolean spin = this.driver.getDigital(Operation.ShooterSpin);
        double shooterSpeed = 0.0;

        if (spin)
        {
            shooterSpeed = this.driver.getAnalog(Operation.ShooterSpeed);
        }

        shooter.setShooterSpeed(shooterSpeed);

        boolean extend = false;
        extend = this.driver.getDigital(Operation.ShooterExtendFiringPin);
    }

    @Override
    public void stop()
    {
        // TODO Auto-generated method stub
        shooter.stop();
    }

    @Override
    public void setDriver(Driver driver)
    {
        // TODO Auto-generated method stub
        this.driver = driver;
    }

    public void createPIDHandler()
    {
        this.PID = new PIDHandler(
            TuningConstants.SHOOTER_VELOCITY_PID_KP_DEFAULT,
            TuningConstants.SHOOTER_VELOCITY_PID_KI_DEFAULT,
            TuningConstants.SHOOTER_VELOCITY_PID_KD_DEFAULT,
            TuningConstants.SHOOTER_VELOCITY_PID_KF_DEFAULT,
            TuningConstants.SHOOTER_VELOCITY_PID_KS_DEFAULT,
            -TuningConstants.SHOOTER_MAX_POWER_LEVEL,
            TuningConstants.SHOOTER_MAX_POWER_LEVEL);
    }
}
