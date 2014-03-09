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
public class ExpelBall extends CommandBase {
    
    public ExpelBall() {
        requires(pickUp);
        requires(pickupWheels);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        setTimeout(RobotConstants.EXPEL_BALL_TIMEOUT);
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     * Retracts the loader arm and runs the pickup wheels
     * in reverse to expel the ball.
     */
    protected void execute() {
        pickUp.retract();
        pickupWheels.expel();
    }
    
    /**
     * Stops the command after EXPELL_BALL_TIMEOUT
     * @return True when timed out
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
