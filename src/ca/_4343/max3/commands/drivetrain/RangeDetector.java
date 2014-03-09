/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commands.drivetrain;

import ca._4343.RobotConstants;
import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class RangeDetector extends CommandBase {
    
    public RangeDetector() {
        requires(lights);
        requires(rangeFinder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(rangeFinder.getDistanceInInches() <= RobotConstants.TOO_CLOSE_DISTANCE) {
            lights.setColour("red");
        } else if ((rangeFinder.getDistanceInInches() >= RobotConstants.TOO_CLOSE_DISTANCE) && (rangeFinder.getDistanceInInches() <= RobotConstants.TOO_FAR_DISTANCE)) {
            lights.setColour("green");
        } else {
            lights.setColour("blue");
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
