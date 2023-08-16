package frc.robot.subsystems.modules;

import edu.wpi.first.math.geometry.Translation2d;

public class ModuleInfo {
  private String name;
  private Translation2d location;

  public ModuleInfo(String name, Translation2d location) {
    this.name = name;
    this.location = location;
  }
}


