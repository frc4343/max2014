/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package ca._4343.max3;


import Extras.Camera;
import ca._4343.max3.commands.Autonomous.AutonomousDefaultSequence;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import ca._4343.max3.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    SendableChooser pickAutonomousMode;
    CommandGroup autoCommand;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
        initializeVirtualButtons();
        CommandBase.init();
        Camera.init();
    }
   

    public void autonomousInit() {
        autoCommand = (CommandGroup) pickAutonomousMode.getSelected();
        autoCommand.start();
        System.out.println("Starting Autonomous");
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        RobotMap.ds = this.m_ds; // is this a cause for the errors?
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
        RobotMap.ds = this.m_ds; // is this a cause for the errors?
        Scheduler.getInstance().run();
        //printConsoleOutput();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    private void initializeVirtualButtons() {
        pickAutonomousMode = new SendableChooser();
        pickAutonomousMode.addDefault("1 BALL : Starting Left", new AutonomousDefaultSequence(true , false)); // Default 1 ball, By default if it cannot find vision target, robot turns right 
        pickAutonomousMode.addObject("1 BALL : Starting Right", new AutonomousDefaultSequence(false, false)); 
        pickAutonomousMode.addObject("2 BALLS : Starting Left", new AutonomousDefaultSequence(true , true)); // By default if it cannot find vision target, robot turns right
        pickAutonomousMode.addObject("2 BALLS : Starting Right", new AutonomousDefaultSequence(false, true)); 
        SmartDashboard.putData("Select Autonomous Mode", pickAutonomousMode);
    }
    
    /*private void printConsoleOutput() {
        // Clears driverStation text.
        logger.clearWindow();
        // Print the tank pressurization state.
        logger.printLine(DriverStationLCD.Line.kUser1, "Tanks: " + (pneumatics.compressor.getPressureSwitchValue() ? "FULL" : "COMPRESSING"));
        logger.printLine(DriverStationLCD.Line.kUser2, "Launcher: " +  (launcher.isReadyToLoadOrFire() ? "Ready2Load" : "NOT FULLY DOWN"));
        // Updates the output window.
        logger.updateLCD();
    }*/
}
