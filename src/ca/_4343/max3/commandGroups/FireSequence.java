/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commandGroups;

import ca._4343.max3.commands.pickup.ExtendArm;
import ca._4343.max3.commands.pickup.UnstickBall;
import ca._4343.max3.commands.transmission.DisengageTransmission;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Fire sequence
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class FireSequence extends CommandGroup {
    
    /**
     * Extends the arm while un-sticking the ball. Once arm is down, shoot
     * the ball by disengaging the transmission
     */
    public FireSequence() {
        addParallel(new ExtendArm());
        addSequential(new UnstickBall());
        addSequential(new DisengageTransmission());
    }
}
