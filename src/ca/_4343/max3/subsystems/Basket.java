/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.subsystems;

import ca._4343.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class Basket extends Subsystem {
    
    private final DigitalInput ballLoaded = new DigitalInput(RobotMap.LAUNCHER_BALL_LOADED_LIMITSWITCH);
    
    /**
     * There is no default state for this subsystem
     */
    public void initDefaultCommand() {
    }
    /**
     * Checks if the ball is within the basket
     * @return True if ball is inside basket
     */
    public boolean isBallLoaded() {
        return ballLoaded.get();
    }
}
