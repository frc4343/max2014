package ca._4343.max3.commands.Autonomous;

import ca._4343.max3.commands.FiringSystem.ExtendPickupAndLoadBall;
import ca._4343.max3.commands.Teleoperated.FireAndReload;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousDefaultSequence extends CommandGroup {
    public AutonomousDefaultSequence(boolean left, boolean firingTwoBalls) {
        if (firingTwoBalls) {
            addSequential(new ExtendPickupAndLoadBall()); // This only extends it, there is a check in the command for if ball = loaded.
            addSequential(new AutonomousCheckTargetsAndDirection(left, (byte) 0)); //Stage 0
            addSequential(new FireAndReload());
        } else {
            addSequential(new AutonomousCheckTargetsAndDirection(left, (byte) 3)); //Stage 3 , 1 Ball auto, waits for hot goal before firing.
            addParallel(new FireAndReload());
        }
        if (firingTwoBalls) {
            addSequential(new ExtendPickupAndLoadBall()); // b/c already extended, this just loads and .. this is test -> close to hold and steady ball in launcher???
            addSequential(new AutonomousCheckTargetsAndDirection(!left, (byte) 1)); // Stage 1 looks at opposite side :D
            addParallel(new FireAndReload());
        }
        addParallel(new AutonomousMoveForward());
    }
}
