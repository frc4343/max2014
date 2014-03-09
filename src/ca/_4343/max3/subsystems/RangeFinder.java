/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class RangeFinder extends Subsystem {
    
    // Analog Module 1
    private final AnalogChannel rangeFinder = new AnalogChannel(1,1);
    
    /**
     * There is no default state for this subsystem
     */
    public void initDefaultCommand() {
    }
    
    /**
     * @return voltage of rangeFinder
     */
    public double getVoltage() {
        return rangeFinder.getVoltage();
    }
    
    /**
     * 1 V = 1000mV
     * 10mV = 1 inch
     * @return Distance in inches
     */
    public double getDistanceInInches() {
        return getVoltage() * 100;
    }
    
}
