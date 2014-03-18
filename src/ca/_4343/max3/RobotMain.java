/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package ca._4343.max3;


import ca._4343.max3.commandGroups.autonomous.hot.DoubleBallAlternativeLeftSequence;
import ca._4343.max3.commandGroups.autonomous.hot.DoubleBallAlternativeRightSequence;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import ca._4343.max3.commands.CommandBase;
import ca._4343.max3.commandGroups.autonomous.hot.DoubleBallLeftSequence;
import ca._4343.max3.commandGroups.autonomous.hot.DoubleBallRightSequence;
import ca._4343.max3.commandGroups.autonomous.hot.SingleBallSequence;
import ca._4343.max3.commandGroups.autonomous.ignoreHot.DoubleBallNotHotSequence;
import ca._4343.util.Camera;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotMain extends IterativeRobot {

    CommandGroup autonomousCommandGroup;
    SendableChooser pickAutonomous;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();

        // Initialize all subsystems
        CommandBase.init();
        Camera.init();
        
        pickAutonomous = new SendableChooser();
        pickAutonomous.addDefault("1 Ball Hot | Any Side", new SingleBallSequence());
        pickAutonomous.addObject("2 Ball No Hot | Any Side", new DoubleBallNotHotSequence());
        pickAutonomous.addObject("2 Ball Hot | Left Side", new DoubleBallLeftSequence());
        pickAutonomous.addObject("2 Ball Hot | Right Side", new DoubleBallRightSequence());
        pickAutonomous.addObject("2 Ball Hot ALT | Left Side", new DoubleBallAlternativeLeftSequence());
        pickAutonomous.addObject("2 Ball Hot ALT | Right Side", new DoubleBallAlternativeRightSequence());
        
    }

    public void autonomousInit() {
        autonomousCommandGroup = (CommandGroup) pickAutonomous.getSelected();
        autonomousCommandGroup.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        CommandBase.ds = this.m_ds;
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if(autonomousCommandGroup != null) { // Fixes error if we try to cancel NOTHING 
            autonomousCommandGroup.cancel();
        }
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        CommandBase.ds = this.m_ds;
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
