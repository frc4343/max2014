/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commands.transmission;

import ca._4343.max3.commands.CommandBase;

/**
 * Puts the transmission motor into drive
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class EngageTransmission extends CommandBase {

    public EngageTransmission() {
        requires(launcher);
        requires(transmission);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run Turns launcher
     * slowly and sets transmission to drive
     */
    protected void execute() {
        transmission.setDrive();
        if (!transmission.getDrive()) { // Prevent Grinding
            launcher.turnSlowly();
        }
    }

    /**
     * Stops the command when transmission is in drive state
     *
     * @return True when transmission is in drive
     */
    protected boolean isFinished() {
        return transmission.getDrive();
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
