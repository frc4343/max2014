package ca._4343.max3.commands.FiringSystem;

import ca._4343.max3.commands.CommandBase;

public class EngageTransmissionAndPullDownLauncher extends CommandBase {
    public EngageTransmissionAndPullDownLauncher() {
        requires(launcher);
        requires(transmission);
    }

    protected void initialize() { }

    protected void execute() {
        launcher.set(0.40);
        System.out.println("Transmission State: "+transmission.retracted());
        if (!transmission.retracted()) {
            if(!transmission.retracted()) {
                transmission.retract();
            }
        } else {
            transmission.stop();
            launcher.set(1); // Full pull-down.
        }
    }

    protected boolean isFinished() {
        return launcher.isReadyToLoadOrFire();
    }

    protected void end() {
        //launcher.set(0); // Just in-case. May not be necessary, but don't want wrecked robot.. could be a potential source of error.
    }

    protected void interrupted() { }
}
