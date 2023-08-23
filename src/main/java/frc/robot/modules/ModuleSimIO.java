package frc.robot.modules;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;

public class ModuleSimIO implements ModuleIO {

    private final FlywheelSim drivePhysics = new FlywheelSim(DCMotor.getNEO(1), 6.75, 0.025);
    private final FlywheelSim turnPhysics  = new FlywheelSim(DCMotor.getNEO(1), 150.0 / 7.0, 0.004);

    // it will be useful later on to keep track of the 
    // last voltage value we sent to the physics
    private double appliedDriveVoltage = 0.0;
    private double appliedTurnVoltage = 0.0;

    private final double loopPeriodSec = 0.02;
    private final double wheelDiameterInches = 4;

    @Override
    public void setDriveVoltage(double volts) {
        appliedDriveVoltage = volts;
        drivePhysics.setInputVoltage(volts);
    }

    @Override
    public void setTurnVoltage(double volts) {
        appliedTurnVoltage = volts;
        turnPhysics.setInputVoltage(volts);
    }

    @Override
    public void updateInputs(ModuleInputs inputs) {        
        drivePhysics.update(loopPeriodSec);
        turnPhysics.update(loopPeriodSec);
        
        // Update the distance the drive motor has spun in meters
        inputs.driveVoltage = appliedDriveVoltage;
        inputs.drivePositionMeters =
            drivePhysics.getAngularVelocityRPM() * Math.PI * Units.inchesToMeters(wheelDiameterInches) / 60 * loopPeriodSec;

        // Update the angle that the azimuth motor is positioned at in degrees
        inputs.azimuthVoltage = appliedTurnVoltage;
        inputs.azimuthPositionDegrees = 
            Units.radiansToDegrees(turnPhysics.getAngularVelocityRadPerSec() * loopPeriodSec);

        // Other
        inputs.driveCurrent = drivePhysics.getCurrentDrawAmps();
        inputs.azimuthCurrent = turnPhysics.getCurrentDrawAmps();

    }


}