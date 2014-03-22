/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.commands.drivetrain;

import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class DriveToDistance extends CommandBase {
    private final String direction;
    private final double distance;
    /**
     * Constructor determining direction and distance to drive to
     * @param direction Accepts either "forward" or "reverse" case-insensitive
     * @param distance Distance to drive to before stopping
     */
    public DriveToDistance(String direction, double distance) {
        this.direction = direction;
        this.distance = distance;
        
        requires(rangeFinder);
        requires(driveTrain);
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
        if (rangeFinder.getDistanceInInches() != distance) {
            driveTrain.arcadeDrive(direction.equalsIgnoreCase("forward") ? 1 : -1, 0); // If an invalid paramter is given then it is treated as reverse
        }
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     * @return True, when robot is at specified distance
     */
    protected boolean isFinished() {
        return rangeFinder.getDistanceInInches() == distance;
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
