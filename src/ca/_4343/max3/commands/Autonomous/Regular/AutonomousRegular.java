/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands.Autonomous.Regular;

import Extras.FindTarget;
import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author CC
 */
public class AutonomousRegular extends CommandBase {
    
    FindTarget findtarget;
    private boolean finished;
    
    public AutonomousRegular() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        findtarget = new FindTarget();
        finished = false;
        drivetrain.disableSafety();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(findtarget.targetFound()) {
            finished = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.enableSafety();
        System.out.println("FINISHED");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
