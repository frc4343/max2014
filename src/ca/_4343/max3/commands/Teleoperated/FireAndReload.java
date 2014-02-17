package ca._4343.max3.commands.Teleoperated;

import ca._4343.max3.commands.FiringSystem.EngageTransmissionAndPullDownLauncher;
import ca._4343.max3.commands.FiringSystem.ExtendPickupAndDisengageTransmission;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class FireAndReload extends CommandGroup {
    public FireAndReload() {
        addSequential(new ExtendPickupAndDisengageTransmission());
        addSequential(new EngageTransmissionAndPullDownLauncher());
    }
}
