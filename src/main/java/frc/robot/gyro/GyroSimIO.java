package frc.robot.gyro;

public class GyroSimIO implements GyroIO {
    
    public GyroSimIO() {
        // in sim, the gyro doesn't do anything and we assume that the robot's heading can be perfectly calculated by encoders
    }
}
