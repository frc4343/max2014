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
public class UnstickBall extends CommandBase {
    
    public UnstickBall() {
        requires(pickUp);
    }

    /**
     * Called just before this Command runs the first time
     * Starts a timer
     */
    protected void initialize() {
        setTimeout(RobotConstants.UNSTICK_BALL_TIMEOUT);
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     * Runs the motor slowly so the ball doesn't get removed
     * from basket
     */
    protected void execute() {
        pickUp.unstickBall();
    }
    
    /**
     * Stops the command immediately after one execution
     * @return True once timed out
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
