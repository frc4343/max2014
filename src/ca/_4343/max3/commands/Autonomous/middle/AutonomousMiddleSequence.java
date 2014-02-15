/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.commands.Autonomous.middle;

import ca._4343.max3.commands.AutonomousMoveForward;
import ca._4343.max3.commands.FireAndReload;
import ca._4343.max3.commands.PickupBall;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author CC
 */
public class AutonomousMiddleSequence extends CommandGroup {
    
    public AutonomousMiddleSequence() {
        addSequential(new PickupBall()); //Extend arm yee
        addSequential(new CheckDirections()); //Check left and right for target, stop when detected
        //addSequential(new FireAndReload()); //Shoot ball  uncomment this when we're sure of sequencing
        addSequential(new AutonomousMoveForward()); //Drive forward for 5 points, woot woot
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
