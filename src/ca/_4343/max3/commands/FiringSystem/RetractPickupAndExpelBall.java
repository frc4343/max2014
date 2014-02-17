package ca._4343.max3.commands.FiringSystem;

import ca._4343.max3.GlobalConstants;
import ca._4343.max3.commands.CommandBase;

public class RetractPickupAndExpelBall extends CommandBase {
    public RetractPickupAndExpelBall() {
        requires(pickup);
        requires(pickupPistons);
    }

    protected void initialize() {
        setTimeout(GlobalConstants.EXPEL_BALL_TIMEOUT);
    }

    protected void execute() {
        pickupPistons.retract();
        pickup.expel();
    }

    protected boolean isFinished() {
        return this.isTimedOut();
    }

    protected void end() {
        //pickupPistons.extend();
    }

    protected void interrupted() { }
}
