/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343.max3.subsystems;

import ca._4343.RobotConstants;
import ca._4343.RobotMap;
import ca._4343.max3.commands.launcher.LauncherDoNothing;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class Launcher extends Subsystem {

    private final SpeedController launcherMotor = new Victor(RobotMap.LAUNCHER_MOTOR_PAIR);
    private final DigitalInput pulledDown = new DigitalInput(RobotMap.LAUNCHER_PULLED_DOWN_LIMITSWITCH);

    public void initDefaultCommand() {
        setDefaultCommand(new LauncherDoNothing());
    }

    /**
     * Checks if the launcher is ready to pickup or fire a ball
     *
     * @return True when launcher has been pulled down entirely
     */
    public boolean isPulledDown() {
        return !pulledDown.get(); // Opposite value because limit switch is wired in reverse on robot
    }

    /**
     * Runs the launcher motor slowly so that the clutch can engage
     */
    public void turnSlowly() {
        set(RobotConstants.LAUNCHER_TURN_SLOWLY_SPEED);
    }

    /**
     * Usually ran after the clutch has engaged so that it pulls down as fast as
     * possible (AFAP)
     */
    public void fullSpeedPullDown() {
        set(isPulledDown() ? 0 : 1);
    }

    /**
     * Stops the launcher motor
     */
    public void stop() {
        set(0);
    }

    /**
     * Set the launcher motor to operate at a certain speed. Will automatically
     * convert values to negative to prevent damage of the ratchet
     *
     * @param speed How fast to turn launcher motor
     */
    private void set(double speed) {
        launcherMotor.set(-Math.abs(speed));
    }
}
