
package ca._4343.max3.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import ca._4343.max3.RobotMap;

/**
 *
 * @author brianho
 */
public class Pneumatics extends Subsystem {
    public Compressor compressor = new Compressor (RobotMap.gpio_compressor_pressure_switch, RobotMap.relay_compressor);


    public void initDefaultCommand() {
        compressor.start();
    }
}
