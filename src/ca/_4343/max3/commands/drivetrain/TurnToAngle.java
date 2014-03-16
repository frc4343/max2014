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
public class TurnToAngle extends CommandBase {

    private final String direction;
    private final double degreesToTurn;

    /**
     * Constructor determining direction and distance to drive to
     *
     * @param direction Accepts either "left" or "right" case-insensitive
     * @param degreesToTurn Distance to drive to before stopping
     */
    public TurnToAngle(String direction, double degreesToTurn) {
        this.direction = direction;
        if (direction.equalsIgnoreCase("right")) {
            this.degreesToTurn = -degreesToTurn; // Angle is negative when turning right
        } else {
            this.degreesToTurn = degreesToTurn;
        }
        
        requires(gyro);
        requires(driveTrain);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        gyro.reset(); // Zeros the gyro
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        if (gyro.getAngle() != degreesToTurn) {
            driveTrain.tankDrive(0, direction.equalsIgnoreCase("left") ? 1 : -1); // If an invalid paramter is given then it is treated as right
        }
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     * @return True, when robot angle is at specified degrees
     */
    protected boolean isFinished() {
        return gyro.getAngle() == degreesToTurn;
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
