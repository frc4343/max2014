/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commands.pickup;

import ca._4343.max3.commands.CommandBase;

/**
 * Default command for pickup wheels subsystem. Causes the pickup wheels
 * to stop spinning when not in use.
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class PickupWheelsDoNothing extends CommandBase {
    
    public PickupWheelsDoNothing() {
        requires(pickupWheels);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run,
     * Stops the pickup wheels from spinning.
     */
    protected void execute() {
        pickupWheels.stop();
        
    }

    /**
     * Always returns false because it is the default command
     * of the PickupWheels subsystem
     * @return False ALWAYS
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
    }
}
