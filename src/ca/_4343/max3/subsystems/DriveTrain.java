/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import ca._4343.max3.RobotMap;
import ca._4343.max3.commands.DriveWithJoysticks;

/**
 *
 * @author brianho
 */
public class DriveTrain extends PIDSubsystem {

    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;

    private RobotDrive drive = new RobotDrive(RobotMap.pwm_rightMotorPair, RobotMap.pwm_leftMotorPair);
    // Initialize your subsystem here
    public DriveTrain() {
        super("DriveTrain", Kp, Ki, Kd);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoysticks());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        tankDrive(output, output);
    }
    public void tankDrive(double left, double right) {
        drive.tankDrive(left, right);
    }
    public void arcadeDrive(double x, double y) {
        
        //drive.arcadeDrive(x, y < 0 ? -(y*y) : (y*y));
        drive.arcadeDrive(x, y);
    }
}
