/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.subsystems;

import ca._4343.max3.RobotMap;
import ca._4343.max3.commands.TransmissionDefaultState;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Administrator
 */

public class Transmission extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    SpeedController motor = new Victor(6);
    DigitalInput retractedlimitSwitch = new DigitalInput(RobotMap.gpio_transmission_retracted);
    Timer superTimer = new Timer();
    public void initDefaultCommand() {
        setDefaultCommand(new TransmissionDefaultState());
    }
    public void extend() {
            motor.set(1); 
    }
    public boolean retract(){
            superTimer.reset();
            superTimer.start();
            motor.set(-.15);
            
            return retractedlimitSwitch.get() || superTimer.get() > 0.314;
    }
    public void stop(){
        motor.set(0);
        superTimer.stop();
    }
}
