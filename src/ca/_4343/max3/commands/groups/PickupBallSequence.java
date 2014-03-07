/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commands.groups;

import ca._4343.max3.commands.pickup.ExtendArm;
import ca._4343.max3.commands.pickup.LoadBall;
import ca._4343.max3.commands.pickup.RetractArm;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Picks up a ball
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class PickupBallSequence extends CommandGroup {
    
    /**
     * Extends the arm and runs the load motors. Once ball is in basket,
     * retract the arm to lock it in place
     */
    public PickupBallSequence() {
        addParallel(new ExtendArm());
        addParallel(new LoadBall());
        addSequential(new RetractArm());
    }
}
