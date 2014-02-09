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
public class Launch extends CommandBase {
    
    public Launch() {
        requires(launcherPiston);
        requires(launcher);
        setTimeout(.001);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(!isTimedOut() && launcher.isReadyToLoadOrFire()) {
            launcher.pulseMotor();
            launcherPiston.extend();
        } else if (isTimedOut()) {
            launcher.set(0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !launcher.isReadyToLoadOrFire();
    }

    // Called once after isFinished returns true
    protected void end() {
        launcherPiston.retract();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
