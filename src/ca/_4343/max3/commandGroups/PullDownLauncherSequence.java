/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commandGroups;

import ca._4343.max3.commands.launcher.PullDownLauncher;
import ca._4343.max3.commands.transmission.EngageTransmission;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class PullDownLauncherSequence extends CommandGroup {
    /**
     * Engages transmission then pulls down launcher at full speed
     */
    public PullDownLauncherSequence() {
        addSequential(new EngageTransmission());
        addSequential(new PullDownLauncher());
    }
}
