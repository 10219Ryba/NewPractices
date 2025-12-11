// Copyright (c) 2025 FRC 10219
// https://github.com/Team10219
// Probably code stolen from 6328
 
package frc.robot.auto;

import static frc.robot.util.FieldConstants.*;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.PathConstraints;
import com.pathplanner.lib.path.PathPlannerPath;
import com.pathplanner.lib.path.Waypoint;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.util.FieldConstants.AprilTagLayoutType;
import frc.robot.util.FieldConstants.CoralObjective;
import frc.robot.util.FieldConstants.Reef;
import frc.robot.util.FieldConstants.ReefLevel;
import java.util.List;

public class AutoHelpers {

  public static Pose2d getTagPose2d(int tagID) {
    Pose3d tagPose3D = AprilTagLayoutType.OFFICIAL.getLayout().getTagPose(tagID).orElseThrow();

    return tagPose3D.toPose2d();
  }

  public static Pose3d getTagPose3d(int tagID) {
    return AprilTagLayoutType.OFFICIAL.getLayout().getTagPose(tagID).orElseThrow();
  }

  public static Pose2d getBranchPose2d(int branchId, ReefLevel level) {
    return Reef.branchPositions2d.get(branchId).get(level);
  }

  public static Pose3d getBranchPose3d(CoralObjective objective) {
    return Reef.branchPositions.get(objective.branchId()).get(objective.reefLevel());
  }

  public static Command getPath() {
    List<Waypoint> waypoints = PathPlannerPath.waypointsFromPoses(getTagPose2d(2));

    Pose2d pose = getTagPose2d(2);

    PathConstraints constraints = new PathConstraints(3.0, 3.0, 2 * Math.PI, 4 * Math.PI);

    return AutoBuilder.pathfindToPose(pose, constraints, 0.0);

    /*
              Driver Station

                     1
                 __________
                /          \
            6  /            \  2
              /              \
             /                \
            /                  \
            \                  /
             \                /
          5   \              /  3
               \            /
                \__________/

                     4
    */
  }
}
