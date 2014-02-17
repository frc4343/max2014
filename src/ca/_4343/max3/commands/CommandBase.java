package ca._4343.max3.commands;

import edu.wpi.first.wpilibj.command.Command;
import ca._4343.max3.OI;
import ca._4343.max3.subsystems.DriveTrain;
import ca._4343.max3.subsystems.Launcher;
import ca._4343.max3.subsystems.PickUp;
import ca._4343.max3.subsystems.Piston;
import ca._4343.max3.subsystems.Pneumatics;
import ca._4343.max3.subsystems.Transmission;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static PickUp pickup = new PickUp();
    public static DriveTrain drivetrain = new DriveTrain();
    public static Launcher launcher = new Launcher();
    public static Pneumatics pneumatics = new Pneumatics();
    public static Piston pickupPistons = new Piston((byte) 3,(byte) 4, true);
    public static Transmission transmission = new Transmission();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(pickup);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
