package ca._4343.max3.commands.FiringSystem;

import ca._4343.max3.commands.CommandBase;

public class PickupDoNothing extends CommandBase {
    public PickupDoNothing() {
        requires(pickup);
    }

    protected void initialize() { }

    protected void execute() {
        pickup.doNothing();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() { }

    protected void interrupted() { }
}
