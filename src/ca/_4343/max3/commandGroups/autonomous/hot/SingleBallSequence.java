/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commandGroups.autonomous.hot;

import ca._4343.RobotConstants;
import ca._4343.max3.commands.camera.WaitForHot;
import ca._4343.max3.commands.drivetrain.DriveForward;
import ca._4343.max3.commandGroups.FireAndReloadSequence;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class SingleBallSequence extends CommandGroup {
    
    public SingleBallSequence() {
        addParallel(new DriveForward(), RobotConstants.AUTONOMOUS_DRIVE_DURATION);
        addParallel(new WaitForHot(), RobotConstants.AUTONOMOUS_SINGLE_BALL_HOT_GOAL_TIMEOUT);
        addSequential(new FireAndReloadSequence());
    }
}
