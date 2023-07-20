package frc.robot;

import com.ctre.phoenix.sensors.Pigeon2;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class SwerveSubsystem extends SubsystemBase {
    
    SwerveModule frontLeft;
    SwerveModule frontRight;
    SwerveModule backLeft;
    SwerveModule backRight;

    Pigeon2 gyro;

    public void setModuleStates(SwerveModuleState[] desiredStates)
    {
        frontLeft.setDesiredState(desiredStates[0]);
        frontRight.setDesiredState(desiredStates[1]);
        backLeft.setDesiredState(desiredStates[2]);
        backRight.setDesiredState(desiredStates[3]);
    }

    public SwerveModuleState[] drive(CommandXboxController driver)
    {


        return null;
    }


}
