package ca._4343.max3.commands.FiringSystem;

import ca._4343.max3.GlobalConstants;
import ca._4343.max3.commands.CommandBase;

public class ExtendPickupAndDisengageTransmission extends CommandBase {
    public ExtendPickupAndDisengageTransmission() {
        requires(transmission);
        requires(pickupPistons);
        requires(pickup);
    }

    protected void initialize() {
        pickup.loadSlowly();
        pickupPistons.extend();
        this.setTimeout(GlobalConstants.EXTEND_PICKUP_BEFORE_FIRING_DELAY);
    }

    protected void execute() {
        if (!transmission.extended() && this.isTimedOut()) {
            transmission.extend();
        }
    }

    protected boolean isFinished() {
        return transmission.extended();
    }

    protected void end() { }

    protected void interrupted() { }
}
