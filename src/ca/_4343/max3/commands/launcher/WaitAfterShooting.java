/*
 * Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commands.launcher;

import ca._4343.RobotConstants;
import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class WaitAfterShooting extends CommandBase {
    
    public WaitAfterShooting() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        this.setTimeout(RobotConstants.TIME_WAIT_AFTER_SHOT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
