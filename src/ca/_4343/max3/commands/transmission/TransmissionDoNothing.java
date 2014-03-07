/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commands.transmission;

import ca._4343.max3.commands.CommandBase;

/**
 * By default, stops the transmission
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class TransmissionDoNothing extends CommandBase {
    
    public TransmissionDoNothing() {
        requires(transmission);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        transmission.stop();
    }

    /**
     * Always returns false because it is the default command
     * of transmission subsystem
     * @return False ALWAYS
     */
    protected boolean isFinished() {
        return false;
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
