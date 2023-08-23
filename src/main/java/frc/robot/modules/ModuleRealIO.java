package frc.robot.modules;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class ModuleRealIO implements ModuleIO {

    private final MotorController m_driveMotor; // represents a real motor
    private final MotorController m_turningMotor;

    private final Encoder m_driveEncoder; // represents a real encoder
    private final Encoder m_turningEncoder;

    // Default wpi constructor just so that we can use MotorController as an example without red lines
    public ModuleRealIO(
        int driveMotorChannel,
        int turningMotorChannel,
        int driveEncoderChannelA,
        int driveEncoderChannelB,
        int turningEncoderChannelA,
        int turningEncoderChannelB) {
      m_driveMotor = new PWMSparkMax(driveMotorChannel);
      m_turningMotor = new PWMSparkMax(turningMotorChannel);
  
      m_driveEncoder = new Encoder(driveEncoderChannelA, driveEncoderChannelB);
      m_turningEncoder = new Encoder(turningEncoderChannelA, turningEncoderChannelB);
    }

    // setting a motor's voltage
    @Override
    public void setDriveVoltage(double volts) {
        m_driveMotor.setVoltage(volts);
    }

    // setting a motor's voltage
    @Override
    public void setTurnVoltage(double volts) {
        m_turningMotor.setVoltage(volts);
    }

    @Override
    public void updateInputs(ModuleInputs inputs) {
        // TODO Auto-generated method stub
        
    }

}