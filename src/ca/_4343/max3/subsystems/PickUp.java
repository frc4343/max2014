package ca._4343.max3.subsystems;

import ca._4343.max3.RobotMap;
import ca._4343.max3.commands.FiringSystem.PickupDoNothing;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PickUp extends Subsystem {
    SpeedController pickUpRollers = new Victor(RobotMap.pwm_pickupMotor);
    DigitalInput limitSwitch = new DigitalInput(RobotMap.gpio_ball_inBasket_Sensor_LimitSwitch);

    public void initDefaultCommand() {
        setDefaultCommand(new PickupDoNothing());
    }

    public void extend() { }

    public void retract() { }

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
