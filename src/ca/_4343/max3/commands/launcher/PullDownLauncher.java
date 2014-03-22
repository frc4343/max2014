/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commands.launcher;

import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class PullDownLauncher extends CommandBase {
    
    public PullDownLauncher() {
        requires(launcher);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     * Turns and pulls down launcher at full speed 
     * (Infers that transmission is engaged)
     */
    protected void execute() {
        launcher.fullSpeedPullDown();
    }

    /**
     * Stops the command when transmission is in drive
     * @return True if transmission is engaged (Drive)
     */
    protected boolean isFinished() {
        return launcher.isPulledDown();
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
