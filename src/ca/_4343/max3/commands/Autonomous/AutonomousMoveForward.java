package ca._4343.max3.commands.Autonomous;

import ca._4343.max3.commands.CommandBase;

public class AutonomousMoveForward extends CommandBase {
    public AutonomousMoveForward() {
        requires(drivetrain);
    }

    protected void initialize() {
        this.setTimeout(0.7);
    }

    protected void execute() {
        drivetrain.arcadeDrive(-1, 0);
    }

    protected boolean isFinished() {
        return this.isTimedOut();
    }

    protected void end() { }

    protected void interrupted() { }
}
