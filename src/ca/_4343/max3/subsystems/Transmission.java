/*
 * Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.subsystems;

import ca._4343.RobotConstants;
import ca._4343.RobotMap;
import ca._4343.max3.commands.transmission.TransmissionDoNothing;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Manages the launcher transmission (neutral, drive)
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class Transmission extends Subsystem {
    
    private final SpeedController transmissionMotor = new Victor(RobotMap.TRANSMISSION_MOTOR);
    private final DigitalInput neutral = new DigitalInput(RobotMap.TRANSMISSION_NEUTRAL_LIMITSWITCH);
    private final DigitalInput drive = new DigitalInput(RobotMap.TRANSMISSION_DRIVE_LIMITSWITCH);
    
    /**
     * Sets default command for transmission to do nothing
     */
    public void initDefaultCommand() {
        setDefaultCommand(new TransmissionDoNothing());
    }
    
    /**
     * Gets position of transmission
     * @return True if transmission is in neutral position
     */
    public boolean getNeutral() {
        return !neutral.get(); // remove ! for actual competition
    }
    
    /**
     * Turns the transmission motor neutral position
     */
    public void setNeutral() {
        if(!getNeutral()) {
            transmissionMotor.set(1);
        } else {
            stop(); // Incase button is repeatly pressed
        }
    }
    
    /**
     * Gets position of transmission
     * @return True if transmission is in drive position
     */
    public boolean getDrive() {
        return drive.get();
    }
    
    /**
     * Turns the transmission motor to drive position
     */
    public void setDrive() {
        if(!getDrive()) {
            transmissionMotor.set(RobotConstants.TRANSMISSION_ROTATE_TO_DRIVE_SPEED);
        } else {
            stop(); // Incase button is repeatly pressed
        }
    }
    
    /**
     * Stops the tranmission motor
     */
    public void stop() {
       transmissionMotor.set(0); 
    }
   
}
