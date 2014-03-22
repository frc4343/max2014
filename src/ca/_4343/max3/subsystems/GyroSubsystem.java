/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.subsystems;

import ca._4343.RobotMap;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class GyroSubsystem extends Subsystem {
    
    // Analog Module 1
    private final Gyro gyro = new Gyro(1, RobotMap.GYRO_SENSOR);
    
    private final double kP = 0.03; // http://wpilib.screenstepslive.com/s/3120/m/7912/l/85772-gyros-to-control-robot-driving-direction
    /**
     * Always scan for range
     */
    public void initDefaultCommand() {
        
    }
    
    /**
     * Resets the gyro
     */
    public void reset() {
        gyro.reset();
    }
    
    /**
     * @return The angle of the robot (gyro)
     */
    public double getAngle() {
        return gyro.getAngle() * kP;
    }
}
