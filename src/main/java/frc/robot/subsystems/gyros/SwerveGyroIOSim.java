package frc.robot.subsystems.gyros;

import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.util.MotionHandler.MotionMode;

public class SwerveGyroIOSim implements SwerveGyroIO {

  @Override
  public void updateInputs(SwerveGyroInputs inputs) {
    inputs.gyroCompassHeading = 0;
    inputs.gyroPitchPosition = 0;
    inputs.previousgyroPitchPosition = 0;
    inputs.gyroRollPosition = 0;
    inputs.gyroYawPosition =
        SwerveSubsystem.resetGyroVal == null ? 0 : SwerveSubsystem.resetGyroVal.getDegrees();
  }

  public void zeroGyro() {}

  @Override
  public void resetGyro(Rotation2d rotation2d) {
    SwerveSubsystem.resetGyroVal = rotation2d;
  }
}

