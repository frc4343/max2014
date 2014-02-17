package ca._4343.max3.commands.FiringSystem;

import ca._4343.max3.commands.CommandBase;

public class LauncherDoNothing extends CommandBase {
    public LauncherDoNothing() {
        requires(launcher);
    }

    protected void initialize() { }

    protected void execute() {
        launcher.doNothing();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() { }

    protected void interrupted() { }
}
