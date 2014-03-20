/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commandGroups.autonomous.hot;

import ca._4343.RobotConstants;
import ca._4343.max3.commands.drivetrain.DriveForward;
import ca._4343.max3.commands.drivetrain.TurnLeft;
import ca._4343.max3.commands.drivetrain.TurnRight;
import ca._4343.max3.commandGroups.FireAndReloadSequence;
import ca._4343.max3.commands.CommandBase;
import ca._4343.max3.commands.pickup.ExtendArm;
import ca._4343.max3.commands.pickup.LoadBall;
import ca._4343.max3.commands.pickup.RetractArm;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class DoubleBallLeftSequence extends CommandGroup {
    public DoubleBallLeftSequence() {
        if (true) {
            addSequential(new FireAndReloadSequence());
            addSequential(new LoadBall());
            addSequential(new TurnRight(), RobotConstants.AUTONOMOUS_TURN_DURATION);
            addSequential(new FireAndReloadSequence());
            addSequential(new DriveForward(), RobotConstants.AUTONOMOUS_DRIVE_DURATION);
        } else {
            addSequential(new TurnRight(), RobotConstants.AUTONOMOUS_TURN_DURATION);
            addSequential(new FireAndReloadSequence());
            addSequential(new RetractArm());
            addSequential(new TurnLeft(), RobotConstants.AUTONOMOUS_TURN_DURATION);
            addParallel(new ExtendArm());
            addSequential(new LoadBall());
            addSequential(new FireAndReloadSequence());
            addSequential(new DriveForward(), RobotConstants.AUTONOMOUS_DRIVE_DURATION);
        }
    }
}
