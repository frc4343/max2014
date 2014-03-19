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
public class LoadBall extends CommandBase {
    
    public LoadBall() {
        requires(pickupWheels);
        requires(basket);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     * Runs pickup wheels
     */
    protected void execute() {
        if(!basket.isBallLoaded()) {
            pickupWheels.load();
        }
    }
    
    /**
     * Stops the command once the ball is in the basket
     * @return True if the ball is loaded
     */
    protected boolean isFinished() {
        return basket.isBallLoaded();
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
