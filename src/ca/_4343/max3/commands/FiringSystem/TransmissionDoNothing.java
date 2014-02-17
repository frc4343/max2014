package ca._4343.max3.commands.FiringSystem;

import ca._4343.max3.commands.CommandBase;

public class TransmissionDoNothing extends CommandBase {
    public TransmissionDoNothing() {
        requires(transmission);
    }

    protected void initialize() { }

    protected void execute() {
        transmission.stop();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() { }

    protected void interrupted() { }
}
