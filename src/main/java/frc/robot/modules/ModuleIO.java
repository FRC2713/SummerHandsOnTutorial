package frc.robot.modules;

import org.littletonrobotics.junction.AutoLog;

// an interface -- 
//      a contract that says "anything that implements me agrees to have this functionality"
// IO -- inputs & outputs
//      any ModuleIO maintains a set of inputs and can produce outputs

public interface ModuleIO {

    // the list of inputs that I maintain 
    @AutoLog
    public class ModuleInputs {
        public double driveVoltage = 0.0;
        public double driveCurrent = 0.0;
        public double drivePositionMeters = 0.0;

        public double azimuthVoltage = 0.0;
        public double azimuthCurrent = 0.0;
        public double azimuthPositionDegrees = 0.0;
    }

    // "contract starts here"

    void updateInputs(ModuleInputs inputs);

    void setDriveVoltage(double volts);

    void setTurnVoltage(double volts);

}
