/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands.Autonomous.Regular;

import ca._4343.max3.commands.Autonomous.AutonomousMoveForward;
import ca._4343.max3.commands.FiringSystem.ExtendPickupAndLoadBall;
import ca._4343.max3.commands.Teleoperated.FireAndReload;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author CC
 */
public class AutonomousDefaultSequence extends CommandGroup {
    
    public AutonomousDefaultSequence(boolean left) {
        addSequential(new ExtendPickupAndLoadBall()); // This only extends it, there is a check in the command for if ball = loaded
        addSequential(new AutonomousDefault(left));
        addSequential(new FireAndReload());
        addSequential(new ExtendPickupAndLoadBall()); // b/c already extended, this just loads and .. this is test -> close to hold and steady ball in launcher???
        addParallel(new FireAndReload());
        addParallel(new AutonomousMoveForward());
    }
}
