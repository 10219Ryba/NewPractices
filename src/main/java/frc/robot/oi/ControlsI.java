// Copyright (c) 2025 FRC 10219
// https://github.com/Team10219
// Probably code stolen from 6328
 
package frc.robot.oi;

import edu.wpi.first.wpilibj2.command.button.Trigger;

public interface ControlsI {
  public double getForward();

  public double getStrafe();

  public double getTurn();

  public Trigger resetGyro();
}
