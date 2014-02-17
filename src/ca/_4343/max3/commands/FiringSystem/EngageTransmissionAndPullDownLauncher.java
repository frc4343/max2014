package ca._4343.max3.commands.FiringSystem;

import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author brianho
 */
public class EngageTransmissionAndPullDownLauncher extends CommandBase {
    
    public EngageTransmissionAndPullDownLauncher() {
        requires(launcher);
        requires(transmission);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        launcher.set(0.50);
        if(!transmission.retracted()) {
            transmission.retract();
        } else {
            transmission.stop();
            launcher.set(1); // Full Pulldown
        } 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return launcher.isReadyToLoadOrFire();
    }

    // Called once after isFinished returns true
    protected void end() {
        launcher.set(0); // Just Incase.... May not be necessary, but don't want recked robot.. could be a potential error causing agent
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
