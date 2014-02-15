/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands;

import ca._4343.max3.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author Administrator
 */
public class Fire extends CommandBase {
    DigitalInput extendedlimitSwitch = new DigitalInput(RobotMap.gpio_transmission_extended);
    public Fire() {
        requires(transmission);
        requires(pickupPistons);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pickupPistons.extend();
        this.setTimeout(0.7);
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!extendedlimitSwitch.get() && this.isTimedOut()) {
            transmission.extend();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (extendedlimitSwitch.get()) {
            transmission.stop();
        }
        return extendedlimitSwitch.get() && this.isTimedOut();
    }

    
    // Called once after isFinished returns true
    protected void end() {
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
