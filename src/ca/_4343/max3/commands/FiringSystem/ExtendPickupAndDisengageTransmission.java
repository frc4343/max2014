package ca._4343.max3.commands.FiringSystem;

import ca._4343.max3.GlobalConstants;
import ca._4343.max3.commands.CommandBase;

/**
 * @author Administrator
 */
public class ExtendPickupAndDisengageTransmission extends CommandBase {
    public ExtendPickupAndDisengageTransmission() {
        requires(transmission);
        requires(pickupPistons);
        requires(pickup);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pickup.loadSlowly();
        pickupPistons.extend();
        this.setTimeout(GlobalConstants.EXTEND_PICKUP_BEFORE_FIRING_DELAY);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!transmission.extended() && this.isTimedOut()) {
            transmission.extend();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return transmission.extended();
    }


    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
