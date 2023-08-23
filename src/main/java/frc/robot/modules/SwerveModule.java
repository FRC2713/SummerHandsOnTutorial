package frc.robot.modules;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.modules.ModuleInputsAutoLogged;

public class SwerveModule {

  private final ModuleIO io;
  private final ModuleInputsAutoLogged inputs = new ModuleInputsAutoLogged();

  public String moduleName;

  private SwerveModuleState desiredState;

  public SwerveModule(ModuleIO io, String moduleName) {
   this.io = io;
   this.moduleName = moduleName;
  }

  public void periodic() {
      // every tick, make sure that the module's inputs get updated based on the ones that are automatically sent to the logger
     this.io.updateInputs(inputs);
  }

  /**
   * Returns the current state of the module.
   *
   * @return The current state of the module.
   */
  public SwerveModuleState getState() {
    return desiredState;
  }

  /**
   * Returns the current position of the module.
   *
   * @return The current position of the module.
   */
  public SwerveModulePosition getPosition() {
    return new SwerveModulePosition(
        inputs.drivePositionMeters, Rotation2d.fromDegrees(inputs.azimuthPositionDegrees));
  }

  /**
   * Sets the desired state for the module.
   *
   * @param desiredState Desired state with speed and angle.
   */
  public void setDesiredState(SwerveModuleState desiredState) {
    this.desiredState =
       SwerveModuleState.optimize(desiredState, Rotation2d.fromDegrees(inputs.azimuthPositionDegrees));
  }
}
