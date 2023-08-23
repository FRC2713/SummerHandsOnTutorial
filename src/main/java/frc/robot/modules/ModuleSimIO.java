package frc.robot.modules;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;

public class ModulSimIO implements ModuleIO {

    private final FlywheelSim drivePhysics;
    private final FlywheelSim turnPhysics;

    @Override
    void setDesiredState(SwerveModuleState desiredState) {
        double simulatedAngle = 0.0; /// NOT FINAL, UNNAS HAS TO FIGURE THIS OUT

        SwerveModuleState optimizedState =
            SwerveModuleState.optimize(desiredState, simulatedAngle);

        drivePhysics.setInputVoltage(optimizedState.speedMetersPerSecond);
        turnPhysics.setInputVoltage(optimizedState.angle.getRadians());
    }
}