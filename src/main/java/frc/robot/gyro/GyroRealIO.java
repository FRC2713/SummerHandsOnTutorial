package frc.robot.gyro;

import com.ctre.phoenix.sensors.Pigeon2;

public class GyroRealIO implements GyroIO {
    private final Pigeon2 pigeon;

    public GyroRealIO() {
        this.pigeon = new Pigeon2(0);
    }

    public void updateInputs(GyroIOInputs inputs) {
        double[] measurmentDegrees = new double[3];
        pigeon.getYawPitchRoll(measurmentDegrees);

        inputs.rollPositionDeg = measurmentDegrees[1];
        inputs.pitchPositionDeg = -measurmentDegrees[2];
        inputs.yawPositionDeg = measurmentDegrees[0];
      }
}
