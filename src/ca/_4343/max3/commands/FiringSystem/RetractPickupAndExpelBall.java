/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands.FiringSystem;

import ca._4343.max3.GlobalConstants;
import ca._4343.max3.commands.CommandBase;

/**
 * @author Brian
 */
public class RetractPickupAndExpelBall extends CommandBase {

    public RetractPickupAndExpelBall() {
        requires(pickup);
        requires(pickupPistons);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(GlobalConstants.EXPEL_BALL_TIMEOUT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        pickupPistons.retract();
        pickup.expel();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (this.isTimedOut());
    }

    // Called once after isFinished returns true
    protected void end() {
        //pickupPistons.extend();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
