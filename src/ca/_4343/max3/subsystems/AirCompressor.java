/*
 * Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.subsystems;

import ca._4343.RobotMap;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class AirCompressor extends Subsystem {
    
    public Compressor compressor = new Compressor(RobotMap.COMPRESSOR_PRESSURE_SWITCH , RobotMap.COMPRESSOR_RELAY);    
    
    /**
     * Make sure the compressor is always compressing if pressure is less than 120 PSI
     */
    public void initDefaultCommand() {
        compressor.start();
    }
}
