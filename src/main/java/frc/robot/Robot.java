// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.littletonrobotics.junction.LoggedRobot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.modules.ModuleRealIO;
import frc.robot.modules.ModuleSimIO;

public class Robot extends LoggedRobot {
  public static final XboxController joysticks = new XboxController(0);


  public static boolean isSimulation = true;

  public static SwerveSubsystem drivetrain;

  public void robotInit() {
    if (isSimulation) {
      drivetrain = new SwerveSubsystem(new ModuleSimIO(), new ModuleSimIO(), new ModuleSimIO(), new ModuleSimIO());
    } else {
      // drivetrain = new SwerveSubsystem(
      //   new ModuleRealIO(0, 0, 0, 0, 0, 0), 
      //   new ModuleRealIO(0, 0, 0, 0, 0, 0), 
      //   new ModuleRealIO(0, 0, 0, 0, 0, 0), 
      //   new ModuleRealIO(0, 0, 0, 0, 0, 0));
    }
  }  
}
