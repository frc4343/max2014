package ca._4343.max3.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import ca._4343.max3.OI;
import ca._4343.max3.subsystems.AirCompressor;
import ca._4343.max3.subsystems.DriveTrain;
import ca._4343.max3.subsystems.Launcher;
import ca._4343.max3.subsystems.PickUp;
import ca._4343.max3.subsystems.Transmission;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * 
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    public static AirCompressor airCompressor = new AirCompressor();
    public static DriveTrain driveTrain = new DriveTrain();
    public static Transmission transmission = new Transmission();
    public static Launcher launcher = new Launcher();
    public static PickUp pickUp = new PickUp();

    public static void init() {
        // Must be here, don't delete
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(driveTrain);
        SmartDashboard.putData(transmission);
        SmartDashboard.putData(launcher);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
