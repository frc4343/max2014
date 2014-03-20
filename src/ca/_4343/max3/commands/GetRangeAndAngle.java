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
public class GetRangeAndAngle extends CommandBase {
    
    public GetRangeAndAngle() {
        requires(rangeFinder);
        requires(gyro);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("range: " + rangeFinder.getDistanceInInches());
        System.out.println("angle: " + gyro.getAngle());
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
