/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.subsystems;

import ca._4343.RobotMap;
import ca._4343.max3.commands.GetRangeAndAngle;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for (Maxbotix LV-MaxSonar-EZ1)
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class RangeFinder extends Subsystem {
    
    // Analog Module 1
    private final AnalogChannel rangeFinder = new AnalogChannel(1, RobotMap.RANGE_SENSOR);
    
    /**
     * There is no default state for this subsystem
     */
    public void initDefaultCommand() {
        setDefaultCommand(new GetRangeAndAngle());
    }
    
    /**
     * @return voltage of rangeFinder
     */
    public double getVoltage() {
        return rangeFinder.getVoltage();
    }
    
    /**
     * 9.766mV = 1 inch
     * http://www.maxbotix.com/articles/016.htm
     * @return Distance in inches
     */
    public double getDistanceInInches() {
        return getMillivolts() / 9.766;
    }
    
    /**
     * 1 V = 1000mV
     * @return Measured voltage in millivolts
     */
    public double getMillivolts() {
        return getVoltage() * 1000;
    }
    
}
