/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.subsystems;

import ca._4343.RobotConstants;
import ca._4343.RobotMap;
import ca._4343.max3.commands.pickup.PickupWheelsDoNothing;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class PickupWheels extends Subsystem {
    
    private final SpeedController pickupMotor = new Victor(RobotMap.PICKUP_MOTOR);

    /**
     * Runs pickup wheels to load ball
     */
    public void load() {
        pickupMotor.set(-1);
    }
    
    /**
     * Runs the pickup wheels in reverse
     * The command that calls this should make sure to call
     * the retract() method contained in the PickUp subsystem.
     * This is to ensure that when you expel a ball, the pickup
     * arm is actually 
     */
    public void expel() {
        pickupMotor.set(1);
    }
    
    /**
     * Runs the motor in the opposite direction (keeps ball in basket)
     * This is useful because the ball has a tendency to roll out
     * of the basket as the pickup is being extended
     */
    public void unstickBall() {
        pickupMotor.set(-RobotConstants.PICKUP_WHEELS_UNSTICK_BALL_SPEED);
    }
    
    /**
     * Stops the pickup wheels
     */
    public void stop() {
        pickupMotor.set(0);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new PickupWheelsDoNothing());
    }
}
