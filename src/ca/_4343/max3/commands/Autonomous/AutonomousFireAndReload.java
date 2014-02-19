/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands.Autonomous;

import ca._4343.max3.commands.FiringSystem.ExtendPickupAndLoadBall;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author CC
 */
public class AutonomousFireAndReload extends CommandGroup {
    
    public AutonomousFireAndReload() {
        addSequential(new AutonomousFire());
        addSequential(new ExtendPickupAndLoadBall());
    }
}
