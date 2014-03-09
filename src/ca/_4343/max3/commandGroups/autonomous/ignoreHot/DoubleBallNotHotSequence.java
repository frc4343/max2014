/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commandGroups.autonomous.ignoreHot;

import ca._4343.max3.commands.drivetrain.DriveForward;
import ca._4343.max3.commandGroups.FireAndReloadSequence;
import ca._4343.max3.commands.pickup.LoadBall;
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
        addSequential(new FireAndReloadSequence());
        addSequential(new LoadBall());
        addParallel(new FireAndReloadSequence());
        addParallel(new DriveForward());
    }
}
