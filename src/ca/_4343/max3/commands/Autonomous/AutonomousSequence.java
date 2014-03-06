package ca._4343.max3.commands.Autonomous;

import ca._4343.max3.GlobalConstants;
import ca._4343.max3.commands.FiringSystem.ExtendPickupAndLoadBall;
import ca._4343.max3.commands.Teleoperated.FireAndReload;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousSequence extends CommandGroup {
    public AutonomousSequence(boolean left, boolean firingTwoBalls, boolean IDONTGIVEASHITABOUTHOTGOAL) {        
        if (firingTwoBalls) {
            addSequential(new ExtendArm());
            addSequential(new AutonomousCheckTargetsAndDirection(left, (byte) 0)); //Stage 0
            addSequential(new FireAndReload());
            addSequential(new ExtendPickupAndLoadBall()); // b/c already extended, this just loads and .. this is test -> close to hold and steady ball in launcher???
            addSequential(new AutonomousCheckTargetsAndDirection(!left, (byte) 1)); // Stage 1 looks at opposite side :D
            //GlobalConstants.detectedOnFirst = false;
            addParallel(new FireAndReload());
            addParallel(new AccelerateSlowly(0.2));
        } else if (IDONTGIVEASHITABOUTHOTGOAL) {
            addSequential(new ExtendPickupAndLoadBall());
            //addSequential(new AutonomousCheckTargetsAndDirection(left, (byte) 0)); //Stage 0
            addSequential(new FireAndReload());
            addSequential(new ExtendPickupAndLoadBall()); // b/c already extended, this just loads and .. this is test -> close to hold and steady ball in launcher???
            //addSequential(new AutonomousCheckTargetsAndDirection(!left, (byte) 1)); // Stage 1 looks at opposite side :D
            addSequential(new FireAndReload());
            addSequential(new AutonomousMoveForward());
            //addSequential(new AutonomousMoveForward());
        } else {
            addSequential(new ExtendArm());
            addSequential(new AutonomousCheckTargetsAndDirection(left, (byte) 3)); //Stage 3 , 1 Ball auto, waits for hot goal before firing.
            addSequential(new AutonomousFireAndReload());
            addSequential(new AutonomousMoveForward());
        }
        /*if(IDONTGIVEASHITABOUTHOTGOAL)
            addSequential(new AutonomousMoveForward());
        else*/ //Only uncomment this if you decide to show 2 ball left and right and change the "addSequential(new FireAndReload());" directly above this line to "addParallel"
           // addSequential(new AutonomousMoveForward());
    }
}
