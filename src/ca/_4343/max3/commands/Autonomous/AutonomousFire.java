/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands.Autonomous;

import ca._4343.max3.commands.CommandBase;

/**
 *
 * @author CC
 */
public class AutonomousFire extends CommandBase {
    
   public AutonomousFire() { 
        requires(transmission);
        requires(pickup);
    }

    protected void initialize() {
        
    }

    protected void execute() {
        if (!transmission.extended()) {
            transmission.extend();
        }
    }

    protected boolean isFinished() {
        return transmission.extended();
    }

    protected void end() { }

    protected void interrupted() { }
}
