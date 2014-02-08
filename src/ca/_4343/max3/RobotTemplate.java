/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package ca._4343.max3;


import ca._4343.max3.Logger;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import ca._4343.max3.commands.CommandBase;
import ca._4343.max3.subsystems.DriveTrain;
import ca._4343.max3.subsystems.Launcher;
import ca._4343.max3.subsystems.PickUp;
import ca._4343.max3.subsystems.Pneumatics;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    Pneumatics pneumatics = new Pneumatics();
    public static PickUp pickup = new PickUp();
    public static DriveTrain drivetrain = new DriveTrain();
    public static Launcher launcher = new Launcher();
    Logger logger = new Logger();
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();

        // Initialize all subsystems
        CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        printConsoleOutput();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    private void printConsoleOutput() {
        // Clears driverStation text.
        logger.clearWindow();
        // Print the tank pressurization state.
        logger.printLine(DriverStationLCD.Line.kUser1, "Tanks: " + (pneumatics.compressor.getPressureSwitchValue() ? "FULL" : "COMPRESSING"));
        logger.printLine(DriverStationLCD.Line.kUser2, "Launcher: " +  (launcher.isReadyToLoadOrFire() ? "Ready2Load" : "NOT FULLY DOWN"));
        // Updates the output window.
        logger.updateLCD();
        // Prints the current gyro angle.
        //logger.printLine(Line.kUser1, "Gyro value: " + (gyroSystem.gyro.getAngle()));
    }
}
