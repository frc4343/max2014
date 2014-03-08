/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commands.autonomous.groups;

import ca._4343.max3.commands.camera.WaitForTargetOrTimeout;
import ca._4343.max3.commands.drivetrain.DriveForward;
import ca._4343.max3.commands.groups.FireAndReloadSequence;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class SingleBallHotGoalSequence extends CommandGroup {
    
    public SingleBallHotGoalSequence() {
        addParallel(new DriveForward());
        addParallel(new WaitForTargetOrTimeout());
        addSequential(new FireAndReloadSequence());
    }
}
