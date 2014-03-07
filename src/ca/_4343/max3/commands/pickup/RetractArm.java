/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commands.pickup;

import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class RetractArm extends CommandBase {
    
    public RetractArm() {
        requires(pickUp);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     * Retracts the pickup arm 
     */
    protected void execute() {
        pickUp.retract();
    }
    
    /**
     * Stops the command immediately after one execution
     * @return True so that command only runs once
     */
    protected boolean isFinished() {
        return true;
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
