package frc.robot.modules;

public class ModuleRealIO implements ModuleIO {

    private final MotorController m_driveMotor;
    private final MotorController m_turningMotor;

    private final Encoder m_driveEncoder;
    private final Encoder m_turningEncoder;

    @Override
    void setDesiredState(SwerveModuleState desiredState) {

        SwerveModuleState optimizedState =
            SwerveModuleState.optimize(desiredState, new Rotation2d(m_turningEncoder.getDistance()));

        m_driveMotor.setVoltage(optimizedState.speedMetersPerSecond);
        m_turningMotor.setVoltage(optimizedState.angle.getRadians());
        
    }
}