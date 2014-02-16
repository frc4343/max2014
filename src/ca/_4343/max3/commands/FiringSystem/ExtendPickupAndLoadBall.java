package ca._4343.max3.commands.FiringSystem;

import ca._4343.max3.GlobalConstants;
import ca._4343.max3.RobotMap;
import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author Brian
 */
public class ExtendPickupAndLoadBall extends CommandBase {
    
    public ExtendPickupAndLoadBall() {
        requires(pickup);
        requires(pickupPistons);
        requires(launcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        this.setTimeout(GlobalConstants.PICKUP_BALL_DELAY);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        pickupPistons.extend();
        if(launcher.isReadyToLoadOrFire() && !pickup.isLoaded()) {
            pickup.load();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(RobotMap.ds.isAutonomous()) {
            return isTimedOut();
        } else {
            return pickup.isLoaded();
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        pickupPistons.retract();
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
