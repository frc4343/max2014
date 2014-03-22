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
public class DriveWithJoystick extends CommandBase {
    
    public DriveWithJoystick() {
        requires(driveTrain);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
    }

    /**
     * Gets x and y values from oi and passes values into arcadeDrive method to
     * drive robot
     */
    protected void execute() {
        driveTrain.arcadeDrive(oi.getX(), oi.getY());
    }

    /**
     * Never stops the command to drive
     * @return False, ALWAYS
     */
    protected boolean isFinished() {
        return false;
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
