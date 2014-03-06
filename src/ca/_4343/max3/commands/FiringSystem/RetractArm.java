/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands.FiringSystem;

import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author CC
 */
public class RetractArm extends CommandBase {
    
    public RetractArm() {
        requires(pickup);
        requires(pickupPistons);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pickupPistons.retract();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pickup.isLoaded();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
