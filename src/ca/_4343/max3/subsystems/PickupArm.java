/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.subsystems;

import ca._4343.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class PickupArm extends Subsystem {
    
    /*
       Any module in cRio slot 1-3 are considered module 1,
       Any module (solenoid, analog, digital) is considered module 2
       Therefore these objects need to be instantiated referencing to 
       the 1st Solenoid Module (24v)
     */
    //private final DoubleSolenoid pickupArm = new DoubleSolenoid(1, RobotMap.SOLENOID_EXTEND, RobotMap.SOLENOID_RETRACT);
    private final Solenoid extend = new Solenoid(1, RobotMap.SOLENOID_EXTEND);
    private final Solenoid retract = new Solenoid(1, RobotMap.SOLENOID_RETRACT);
    
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
        //pickupArm.set(DoubleSolenoid.Value.kForward);
    }
    
    /**
     * Retract the loader arm (hold ball position)
     */
    public void retract() {
        extend.set(false);
        retract.set(true);
        //pickupArm.set(DoubleSolenoid.Value.kReverse);
    }
}
