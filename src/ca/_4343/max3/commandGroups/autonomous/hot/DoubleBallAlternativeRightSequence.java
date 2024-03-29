/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commandGroups.autonomous.hot;

import ca._4343.RobotConstants;
//import ca._4343.max3.commands.drivetrain.DriveForward;
//import ca._4343.max3.commands.drivetrain.TurnLeft;
//import ca._4343.max3.commands.drivetrain.TurnRight;
import ca._4343.max3.commandGroups.FireAndReloadSequence;
import ca._4343.max3.commands.Camera.WaitForHot;
import ca._4343.max3.commands.drivetrain.DriveToDistance;
import ca._4343.max3.commands.drivetrain.TurnToAngle;
//import ca._4343.max3.commands.drivetrain.DriveReverse;
import ca._4343.max3.commands.pickup.LoadBall;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class DoubleBallAlternativeRightSequence extends CommandGroup {
    public DoubleBallAlternativeRightSequence() {
        addParallel(new WaitForHot(), RobotConstants.AUTONOMOUS_DOUBLE_BALL_HOT_GOAL_TIMEOUT);
        //addParallel(new DriveForward(), RobotConstants.AUTONOMOUS_DRIVE_DURATION);
        addSequential(new DriveToDistance("forward", RobotConstants.AUTONOMOUS_OPTIMAL_DISTANCE_FROM_GOAL)); // Either using a range finder, or timer (above)
        if (true) {
            addSequential(new FireAndReloadSequence());
            //addParallel(new DriveReverse(), RobotConstants.AUTONOMOUS_DRIVE_DURATION);
            addParallel(new DriveToDistance("reverse", RobotConstants.AUTONOMOUS_OPTIMAL_DISTANCE_FOR_BALL_PICKUP));
            addSequential(new LoadBall());
            //addSequential(new TurnLeft(), RobotConstants.AUTONOMOUS_TURN_DURATION);
            addSequential(new TurnToAngle("left", RobotConstants.AUTONOMOUS_TURN_TO_ANGLE));
            //addSequential(new DriveForward(), RobotConstants.AUTONOMOUS_DRIVE_DURATION);
            addSequential(new DriveToDistance("forward", RobotConstants.AUTONOMOUS_OPTIMAL_DISTANCE_FROM_GOAL));
            addSequential(new FireAndReloadSequence());
        } else {
            //addSequential(new TurnLeft(), RobotConstants.AUTONOMOUS_TURN_DURATION);
            addSequential(new TurnToAngle("left", RobotConstants.AUTONOMOUS_TURN_TO_ANGLE));
            addSequential(new FireAndReloadSequence());
            //addSequential(new TurnRight(), RobotConstants.AUTONOMOUS_TURN_DURATION);
            addSequential(new TurnToAngle("right", RobotConstants.AUTONOMOUS_TURN_TO_ANGLE));
            //addParallel(new DriveReverse(), RobotConstants.AUTONOMOUS_DRIVE_DURATION);
            addParallel(new DriveToDistance("reverse", RobotConstants.AUTONOMOUS_OPTIMAL_DISTANCE_FOR_BALL_PICKUP));
            addSequential(new LoadBall());
            //addSequential(new DriveForward(), RobotConstants.AUTONOMOUS_DRIVE_DURATION);
            addSequential(new DriveToDistance("forward", RobotConstants.AUTONOMOUS_OPTIMAL_DISTANCE_FROM_GOAL));
            addSequential(new FireAndReloadSequence());
        }
    }
}
