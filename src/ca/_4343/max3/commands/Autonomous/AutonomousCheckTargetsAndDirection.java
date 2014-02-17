/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands.Autonomous;

import Extras.FindTarget;
import Extras.FindTarget.TargetReport;
import ca._4343.max3.GlobalConstants;
import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author CC
 */
public class AutonomousCheckTargetsAndDirection extends CommandBase {

    FindTarget findtarget;
    TargetReport targetReport;
    private boolean finished;
    private boolean left;
    private byte stage = 0;

    public AutonomousCheckTargetsAndDirection(boolean left, byte stage) {
        this.left = left;
        this.stage = stage;
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        findtarget = new FindTarget();
        finished = false;
        //setTimeout(GlobalConstants.DELAY_BEFORE_TURNING); // if no hot goal found at placement
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //drivetrain.disableSafety();
        targetReport = findtarget.giveMeATarget();
        if (targetReport.Hot && stage == 0) {
            //drivetrain.enableSafety();
            if (targetReport.leftScore > targetReport.rightScore) { //We are on left side
                left = true;
            } else {    //We are on right side
                left = false;
            }
            finished = true;
        } else if (!targetReport.Hot || stage == 1) {
            if (left) {
                drivetrain.tankDrive(0, 1); //Turn Right
                if (targetReport.Hot) { // Check for target
                    finished = true;
                } else { // right
                    drivetrain.tankDrive(1, 0); //Turn Right
                    if (targetReport.Hot) { // Check for target
                        finished = true;
                    }
                }
            }
        } else if (stage == 3) {
            finished = targetReport.Hot;
        } else {
            finished = false;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
        //findtarget = null; //Make it ready for garbage collector (was originally in check directions, dont know if needed, tedi had not used for start button in teleop of controller
        drivetrain.tankDrive(0, 0);
        System.out.println("FINISHED");

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
