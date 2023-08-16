package frc.robot.subsystems.gyros;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.AutoLog;

public interface SwerveGyroIO {

  @AutoLog
  public static class SwerveGyroInputs {
    public double gyroYawPosition = 0.0;
    public double gyroPitchPosition = 0.0;
    public double previousgyroPitchPosition = 0.0;
    public double gyroRollPosition = 0.0;
    public double gyroCompassHeading = 0.0;
  }

  /**
   * Updates input values with the given SwerveInputs instance.
   *
   * @param inputs SwerveInputs instance
   */
  public void updateInputs(SwerveGyroInputs inputs);

  /**
   * Sets the gyro to the given rotation.
   *
   * @param rotation2d The desired rotation
   */
  public void resetGyro(Rotation2d rotation2d);

  public void zeroGyro();
}
