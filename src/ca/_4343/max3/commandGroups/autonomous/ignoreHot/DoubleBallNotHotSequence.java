/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commandGroups.autonomous.ignoreHot;

import ca._4343.RobotConstants;
import ca._4343.max3.commands.drivetrain.DriveForward;
import ca._4343.max3.commandGroups.FireAndReloadSequence;
import ca._4343.max3.commandGroups.PullDownLauncherSequence;
import ca._4343.max3.commands.drivetrain.DriveBackwards;
import ca._4343.max3.commands.launcher.WaitAfterShooting;
import ca._4343.max3.commands.pickup.LoadBall;
import ca._4343.max3.commands.transmission.DisengageTransmission;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class DoubleBallNotHotSequence extends CommandGroup {
    /**
     * Fire the ball and reload launcher with second ball. Then shoot second
     * ball and drive forward
     */
    public DoubleBallNotHotSequence() {
        addSequential(new DriveForward(), RobotConstants.AUTONOMOUS_DRIVE_DURATION);
        //EXTEND THE GOD DAMN ARM HERE PLEASE FK
        addSequential(new DisengageTransmission());
        addParallel(new DriveBackwards(), RobotConstants.AUTONOMOUS_DRIVE_DURATION);
        addSequential(new WaitAfterShooting(), 1);
        addSequential(new PullDownLauncherSequence());
        addSequential(new LoadBall());
        addSequential(new DriveForward(), RobotConstants.AUTONOMOUS_DRIVE_DURATION + 0.5);
        addSequential(new DisengageTransmission());
        //addSequential(new DriveForward());
    }
}
