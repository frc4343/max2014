/*
 * Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.subsystems;

import ca._4343.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class DriveTrain extends Subsystem {

    
    final private RobotDrive drive = new RobotDrive(RobotMap.rightMotorPair, RobotMap.leftMotorPair);
    
    public DriveTrain() {
        super("DriveTrain");
    }

    public void initDefaultCommand() {
    }
    
    /**
     * Drive the robot using tank style
     * @param left How much power to apply to left motor pairs
     * @param right How much power to apply to right motor pairs
     */
    public void tankDrive(double left, double right) {
        drive.tankDrive(left, right);
    }
    
    /**
     * Drive the robot using arcade style.
     * @param x Forward and backwards speed
     * @param y Rotation speed 
     */
    public void arcadeDrive(double x, double y) {
        drive.arcadeDrive(x, y);
    }
    
    /**
     * Disable motor safety, stops 'Robot drive not updated enough...' error
     * @param value Either true or false. 'True' to enable safety and 'False' to disable
     */
    public void toggleSaftey(boolean value) {
        drive.setSafetyEnabled(value);
    }
}
