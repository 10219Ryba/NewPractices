// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.auto;

import com.pathplanner.lib.path.PathPlannerPath;
import edu.wpi.first.math.geometry.Pose2d;
import org.littletonrobotics.junction.AutoLog;

public interface BuilderIO {
  @AutoLog
  public static class BuilderIOInputs {
    public boolean hasPath = false;
    public Pose2d startingPose = new Pose2d();
    public Pose2d[] pathPoses = new Pose2d[0];
  }

  public static record BuilderAuto(double timestamp, Pose2d startingPose, Pose2d[] pathPoses) {}

  public static record PathPlannerAuto(
      double timestamp, Pose2d startingPose, PathPlannerPath[] paths) {}

  public void updateInputs(BuilderIOInputs inputs);
}
