/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commandGroups;

import ca._4343.max3.commands.launcher.WaitAfterShooting;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class FireAndReloadSequence extends CommandGroup {
    
    /**
     * Fires the ball and then reloads the launcher
     */
    public FireAndReloadSequence(){
        addSequential(new FireSequence());    
        addSequential(new WaitAfterShooting());
        addSequential(new PullDownLauncherSequence());
    }
}
