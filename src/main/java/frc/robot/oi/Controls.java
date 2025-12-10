// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.oi;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.util.AllianceFlipUtil;

public class Controls implements ControlsI {
  private CommandXboxController controller;
  private static Controls instance = null;
  private static int port;

  public Controls(int port) {
    Controls.port = port;
    controller = new CommandXboxController(port);
  }

  public static Controls getInstance() {
    if (instance == null) {
      instance = new Controls(port);
    }
    return instance;
  }

  @Override
  public double getForward() {
    return AllianceFlipUtil.shouldFlip() ? controller.getLeftY() : -controller.getLeftY();
  }

  @Override
  public double getStrafe() {
    return AllianceFlipUtil.shouldFlip() ? controller.getLeftX() : -controller.getLeftX();
  }

  @Override
  public double getTurn() {
    return -controller.getRightX();
  }

  @Override
  public Trigger resetGyro() {
    return controller.start();
  }
}
