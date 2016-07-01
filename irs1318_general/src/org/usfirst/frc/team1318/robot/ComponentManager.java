package org.usfirst.frc.team1318.robot;

import org.usfirst.frc.team1318.robot.Compressor.CompressorComponent;
import org.usfirst.frc.team1318.robot.DriveTrain.DriveTrainComponent;
import org.usfirst.frc.team1318.robot.General.PositionManager;
import org.usfirst.frc.team1318.robot.General.PowerManager;
import org.usfirst.frc.team1381.robot.Shooter.ShooterComponent;

public class ComponentManager
{
    private CompressorComponent compressorComponent;
    private DriveTrainComponent driveTrainComponent;
    private ShooterComponent shooterComponent;

    //Corbin was lazy
    private PowerManager powerManager;
    private PositionManager positionManager;

    public ComponentManager()
    {
        this.compressorComponent = new CompressorComponent();
        this.driveTrainComponent = new DriveTrainComponent();
        this.shooterComponent = new ShooterComponent();

        this.powerManager = new PowerManager();
        this.positionManager = new PositionManager(this.driveTrainComponent);
    }

    public CompressorComponent getCompressor()
    {
        return this.compressorComponent;
    }

    public DriveTrainComponent getDriveTrain()
    {
        return this.driveTrainComponent;
    }

    public ShooterComponent getShooter()
    {
        return this.shooterComponent;
    }

    public PowerManager getPowerManager()
    {
        return this.powerManager;
    }

    public PositionManager getPositionManager()
    {
        return this.positionManager;
    }
}
