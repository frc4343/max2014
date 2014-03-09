/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commands.pickup;

import ca._4343.RobotConstants;
import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class ExtendArm extends CommandBase {
    
    public ExtendArm() {
        requires(pickUp);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        setTimeout(RobotConstants.TIME_REQUIRED_TO_EXTEND_ARM);
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     * Extends the pickup arm 
     */
    protected void execute() {
        pickUp.extend();
    }
    
    /**
     * Stops the command immediately after one execution
     * @return True so that command only runs once
     */
    protected boolean isFinished() {
        return isTimedOut();
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
