/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commandGroups.autonomous.hot;

import ca._4343.RobotConstants;
import ca._4343.max3.commands.drivetrain.DriveForward;
import ca._4343.max3.commandGroups.FireAndReloadSequence;
import ca._4343.max3.commands.Camera.WaitForHot;
import ca._4343.max3.commands.WaitForEver;
import ca._4343.max3.commands.pickup.ExtendArm;
import ca._4343.max3.commands.pickup.UnstickBall;
import ca._4343.max3.commands.transmission.DisengageTransmission;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class SingleBallSequence extends CommandGroup {
    
    public SingleBallSequence() {
        RobotConstants.waitAfterDetectedVision = 0;
        RobotConstants.setAutonomousStatus("Single Ball Sequence started");
        addSequential(new WaitForEver(), RobotConstants.AUTONOMOUS_WAIT__BEFORE_STARTING);
        addParallel(new DriveForward(), RobotConstants.AUTONOMOUS_DRIVE_DURATION);
        addParallel(new UnstickBall());
        addSequential(new ExtendArm());
        addSequential(new WaitForHot(), RobotConstants.AUTONOMOUS_SINGLE_BALL_HOT_GOAL_TIMEOUT);
        addSequential(new WaitForEver(), RobotConstants.waitAfterDetectedVision);
        //addSequential(new FireAndReloadSequence());
        addSequential(new DisengageTransmission());
    }
}
