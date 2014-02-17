/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands;

import Extras.FindTarget;

/**
 * @author CC
 */
public class VisionTest extends CommandBase {

    FindTarget findTarget;

    public VisionTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        findTarget = new FindTarget();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.disableSafety();
        findTarget.giveMeATarget();
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
