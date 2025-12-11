// Copyright (c) 2025 FRC 10219
// https://github.com/Team10219
// Probably code stolen from 6328
 
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
