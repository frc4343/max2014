/*
 * Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.subsystems;

import ca._4343.util.FindTarget;
import ca._4343.util.FindTarget.TargetReport;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class VisionSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private FindTarget findTarget;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Creates a new instance of the findTarget class 
     */
    private void instantiate() {
        findTarget = new FindTarget();
    }
    
    /**
     * Gets the image from the camera and returns its data
     * @return The current target report (part that grabs the image)
     */
    private TargetReport getTargetReport() {
        if(findTarget != null)
            return findTarget.giveMeATarget();
        else 
            return null;
    }
    
    /**
     * Scans the area to check if there is a hot target visible
     * @return True if there is a hot target visible
     */
    public boolean scanForTarget() {
        if(findTarget == null) {
            instantiate();
        } else if (findTarget != null) {
            TargetReport currentTarget = getTargetReport();
            if(currentTarget != null) {
                return currentTarget.Hot;
            } else {
                return false;
            }
        }
        return false;
    }
 }
