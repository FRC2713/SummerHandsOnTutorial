package frc.robot;

import com.ctre.phoenix.sensors.Pigeon2;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class SwerveSubsystem extends SubsystemBase {
    
    SwerveModule frontLeft;
    SwerveModule frontRight;
    SwerveModule backLeft;
    SwerveModule backRight;

    Pigeon2 gyro;

    final double MAX_VELOCITY = 16.0; // feet per sec
    final double MAX_ANGULAR_VELOCITY = Units.degreesToRadians(275);

    public final double K_HALF_CHASSIS_LENGTH = Units.inchesToMeters(20.75 / 2);
   
    public final Translation2d FRONT_LEFT_LOC =
        new Translation2d(-K_HALF_CHASSIS_LENGTH, K_HALF_CHASSIS_LENGTH);

    public final Translation2d FRONT_RIGHT_LOC = 
        new Translation2d(K_HALF_CHASSIS_LENGTH, K_HALF_CHASSIS_LENGTH);

    public final Translation2d BACK_LEFT_LOC =
        new Translation2d(-K_HALF_CHASSIS_LENGTH, -K_HALF_CHASSIS_LENGTH);
    
    public final Translation2d BACK_RIGHT_LOC =
        new Translation2d(K_HALF_CHASSIS_LENGTH, -K_HALF_CHASSIS_LENGTH);

    public void setModuleStates(SwerveModuleState[] desiredStates)
    {
        frontLeft.setDesiredState(desiredStates[0]);
        frontRight.setDesiredState(desiredStates[1]);
        backLeft.setDesiredState(desiredStates[2]);
        backRight.setDesiredState(desiredStates[3]);
    }

    public SwerveModuleState[] drive(CommandXboxController driver)
    {
        // describing how the chassis will move
        double xSpeed = driver.getLeftY() * MAX_VELOCITY;
        double ySpeed = driver.getLeftX() * MAX_VELOCITY;
        double rSpeed = driver.getRightX() * MAX_ANGULAR_VELOCITY;
        ChassisSpeeds speeds =
            ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed, ySpeed, rSpeed, 
                Rotation2d.fromDegrees(gyro.getYaw()));

        // convert chassis movement to module movements
        SwerveDriveKinematics swerveKinematics = new SwerveDriveKinematics(
            FRONT_LEFT_LOC,
            FRONT_RIGHT_LOC,
            BACK_LEFT_LOC,
            BACK_RIGHT_LOC
        );
        SwerveModuleState[] states = swerveKinematics.toSwerveModuleStates(speeds);
        
        // solves weird artifacts from differential equations
        SwerveDriveKinematics.desaturateWheelSpeeds(states, MAX_VELOCITY);

        return states;
    }
}
