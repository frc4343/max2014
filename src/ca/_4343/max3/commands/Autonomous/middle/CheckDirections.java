/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands.Autonomous.middle;

import Extras.FindTarget;
import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author CC
 */
public class CheckDirections extends CommandBase {
    
    FindTarget findtarget;
    final double TIME_FOR_LEFT_TURN = 0.2;
    final double TIME_FOR_RIGHT_TURN = 1; // Should always be double of left turn
    byte stage = 0;
    boolean finished;
    
    public CheckDirections() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        stage = 0;
        findtarget = new FindTarget();
        finished = false;
        this.setTimeout(TIME_FOR_LEFT_TURN);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Stage: "+stage);
        if(stage == 0) {
            if(!this.isTimedOut()) {
                drivetrain.tankDrive(0, 1); //Turn left
            } else if (this.isTimedOut()){
                if(findtarget.targetFound()) { // Check for target
                    finished = true;
                } else {
                    System.out.println("Here");
                    stage++;
                    this.setTimeout(TIME_FOR_RIGHT_TURN);
                }
            }
        } 
        if (stage == 1) {
            if(!this.isTimedOut()) {
                drivetrain.tankDrive(1,0); //Turn right
                System.out.println("TURNING RIGHT");
            } else if (this.isTimedOut()) {
                 finished = true; //If left has no target, then right must be hot
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
        findtarget = null; //Make it ready for garbage collector
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
