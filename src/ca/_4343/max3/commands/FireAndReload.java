/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Administrator
 */
public class FireAndReload extends CommandGroup {
    
    public FireAndReload() {
        addSequential(new Fire());
        addSequential(new PrepareLauncherForPickup());
    }
}
