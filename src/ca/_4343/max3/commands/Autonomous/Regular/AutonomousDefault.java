/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands.Autonomous.Regular;

import Extras.FindTarget;
import Extras.FindTarget.TargetReport;
import ca._4343.max3.GlobalConstants;
import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author CC
 */
public class AutonomousDefault extends CommandBase {
    
    FindTarget findtarget;
    TargetReport targetReport;
    private boolean finished;
    private boolean left;
    
    public AutonomousDefault(boolean left) {
        this.left = left;
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        findtarget = new FindTarget();
        finished = false;
        setTimeout(GlobalConstants.DELAY_BEFORE_TURNING); // if no hot goal found at placement
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.disableSafety();
        targetReport = findtarget.giveMeATarget();
        if(targetReport.Hot) {
            finished = true;
        } else if (left) { //We are on left side
            drivetrain.tankDrive(1, 0);
        } else if (!left) { //We are on right side
            drivetrain.tankDrive(0, 1);
        } else if (targetReport.leftScore > targetReport.rightScore) {
            
        }
        
        finished = isTimedOut();
            // add some code here for turning
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
