/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import ca._4343.max3.RobotMap;
import ca._4343.max3.commands.FiringSystem.LauncherDoNothing;

/**
 *
 * @author Brian
 */
public class Launcher extends PIDSubsystem {

    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;

    SpeedController launcherMotor = new Victor(RobotMap.pwm_launcherMotorPair);
    DigitalInput limitSwitch = new DigitalInput(RobotMap.gpio_launcher_fullyLoaded_LimitSwitch);
    // Initialize your subsystem here
    public Launcher() {
        super("Launcher", Kp, Ki, Kd);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
       setDefaultCommand(new LauncherDoNothing());
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
    }
    public void doNothing() {
        launcherMotor.set(0);
    }
    public void set(double speed) {
        launcherMotor.set(-Math.abs(speed)); 
        // So that the motor only goes one way
    }
    public void pulseMotor() {
        launcherMotor.set(-1);  // Set to negative for testing
        // So that the motor only goes one way
    }
    public boolean isReadyToLoadOrFire() {
        return !limitSwitch.get();
    }
}
