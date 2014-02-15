/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands.Autonomous.Regular;

import ca._4343.max3.commands.Autonomous.AutonomousMoveForward;
import ca._4343.max3.commands.FireAndReload;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author CC
 */
public class AutonomousRegularSequence extends CommandGroup {
    
    public AutonomousRegularSequence() {
        addSequential(new AutonomousRegular());
        //addSequential(new FireAndReload());
        //addSequential(new AutonomousMoveForward());
    }
}
