/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import ca._4343.max3.RobotMap;
import ca._4343.max3.commands.FiringSystem.PickupDoNothing;

/**
 *
 * @author Brian
 */
public class PickUp extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    SpeedController pickUpRollers = new Victor(RobotMap.pwm_pickupMotor);
    DigitalInput limitSwitch = new DigitalInput(RobotMap.gpio_ball_inBasket_Sensor_LimitSwitch);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new PickupDoNothing());
    }
    public void extend() {
        
    }
    public void retract() {
        
    }
    public void load() {
        pickUpRollers.set(-1);
    }
    public void loadSlowly() {
        pickUpRollers.set(-0.2);
    }
    public void expel() {
        pickUpRollers.set(1);
    }
    public void doNothing() {
        pickUpRollers.set(0);
    }
    public boolean isLoaded() {
        return limitSwitch.get();
    }
}
