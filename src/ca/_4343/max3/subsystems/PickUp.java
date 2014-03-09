/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.subsystems;

import ca._4343.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class PickUp extends Subsystem {
    
    private final Solenoid extend = new Solenoid(RobotMap.SOLENOID_EXTEND);
    private final Solenoid retract = new Solenoid(RobotMap.SOLENOID_RETRACT);
    
    /**
     * There is no default state for this subsystem
     */
    public void initDefaultCommand() {
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
