/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands;

/**
 *
 * @author brianho
 */
public class PrepareLauncherForPickup extends CommandBase {
    
    public PrepareLauncherForPickup() {
        requires(launcher);
        requires(transmission);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        launcher.set(0.25);
        if(transmission.retract()) {
            launcher.set(1);
            transmission.stop();
        } 
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !launcher.isReadyToLoadOrFire();
    }

    // Called once after isFinished returns true
    protected void end() {
        launcher.set(0);
        transmission.extend();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}