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
public class Lights extends Subsystem {
    
    // Solenoid Module 4
    private final Solenoid red = new Solenoid(4, RobotMap.SOLENOID_RED_LED);
    private final Solenoid green = new Solenoid(4, RobotMap.SOLENOID_GREEN_LED);
    private final Solenoid blue = new Solenoid(4, RobotMap.SOLENOID_BLUE_LED);
    
    /**
     * There is no default state for this subsystem
     */
    public void initDefaultCommand() {
        // range sensor stuff
    }
    
    /**
     * Sets the colour of the LED light strip
     * @param colour Accepts a value of red, green, or blue, case insensitive 
     */
    public void setColour(String colour) {
        if (colour.equalsIgnoreCase("red")) {
            setRed();
        } else if (colour.equalsIgnoreCase("green")) {
            setGreen();
        } else if (colour.equalsIgnoreCase("blue")) {
            setBlue();
        } else {
            turnOff();
        }
    }
    
    /**
     * Turns off other colours first to have enough voltage then turns on red
     */
    private void setRed() {
        blue.set(false);
        green.set(false);
        red.set(true);
    }
    
    /**
     * Turns off other colours first to have enough voltage then turns on red
     */
    private void setGreen() {
        blue.set(false);
        red.set(false);
        green.set(true);
    }
    
    /**
     * Turns off other colours first to have enough voltage then turns on blue
     */
    private void setBlue() {
        red.set(false);
        green.set(false);
        blue.set(true);
    }
    
    /**
     * Turns off all colours
     */
    private void turnOff() {
        red.set(false);
        green.set(false);
        blue.set(false);
    }
}
