/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.subsystems;

import ca._4343.RobotConstants;
import ca._4343.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class PickUp extends Subsystem {
    
    private final Solenoid extend = new Solenoid(RobotMap.SOLENOID_EXTEND);
    private final Solenoid retract = new Solenoid(RobotMap.SOLENOID_RETRACT);
    private final SpeedController pickupMotor = new Victor(RobotMap.PICKUP_MOTOR);
    private final DigitalInput ballLoaded = new DigitalInput(RobotMap.LAUNCHER_BALL_LOADED_LIMITSWITCH);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Runs pickup wheels to load ball
     */
    public void load() {
        pickupMotor.set(-1);
    }
    
    /**
     * Runs the pickup wheels in reverse and also ensures pickup
     * arm is in the retracted position
     */
    public void expel() {
        retract();
        pickupMotor.set(1);
    }
    
    /**
     * Runs the motor in the opposite direction (keeps ball in basket)
     * This is useful because the ball has a tendency to roll out
     * of the basket as the pickup is being extended
     */
    public void unstickBall() {
        pickupMotor.set(-RobotConstants.PICKUP_UNSTICK_BALL_SPEED);
    }

    /**
     * Checks if the ball is within the basket
     * @return True if ball is inside basket
     */
    public boolean isBallLoaded() {
        return ballLoaded.get();
    }
    
    /**
     * Extend the loader arm (pickup ball position)
     */
    public void extend() {
        retract.set(false);
        extend.set(true);
    }
    
    /**
     * Retract the loader arm (hold ball position)
     */
    public void retract() {
        extend.set(false);
        retract.set(true);
    }
}
