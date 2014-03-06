package ca._4343.max3;

import ca._4343.max3.commands.FiringSystem.EngageTransmissionAndPullDownLauncher;
import ca._4343.max3.commands.FiringSystem.ExtendPickupAndDisengageTransmission;
import ca._4343.max3.commands.FiringSystem.ExtendPickupAndLoadBall;
import ca._4343.max3.commands.FiringSystem.RetractArm;
import ca._4343.max3.commands.FiringSystem.RetractPickupAndExpelBall;
import ca._4343.max3.commands.FiringSystem.UnJamLauncher;
import ca._4343.max3.commands.Teleoperated.FireAndReload;
import ca._4343.max3.commands.Teleoperated.ForceLoad;
import ca._4343.max3.commands.VisionTest;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    Joystick xbox1 = new Joystick(1);
    Joystick xbox2 = new Joystick(2);
    Button xbox1_A = new JoystickButton(xbox1, 1);
    Button xbox1_B = new JoystickButton(xbox1, 2);
    Button xbox1_X = new JoystickButton(xbox1, 3);
    Button xbox1_Y = new JoystickButton(xbox1, 4);
    Button xbox1_L3 = new JoystickButton(xbox1, 9);
    Button xbox1_R3 = new JoystickButton(xbox1, 10);
    Button xbox1_START = new JoystickButton(xbox1, 8);
    Button xbox1_SELECT = new JoystickButton(xbox1, 7);
    Button xbox1_L1 = new JoystickButton(xbox1, 5);
    Button xbox1_R1 = new JoystickButton(xbox1, 6);
     // Joystick 2
    Button xbox2_A = new JoystickButton(xbox2, 1);
    Button xbox2_B = new JoystickButton(xbox2, 2);
    Button xbox2_X = new JoystickButton(xbox2, 3);
    Button xbox2_Y = new JoystickButton(xbox2, 4);
    Button xbox2_L3 = new JoystickButton(xbox2, 9);
    Button xbox2_R3 = new JoystickButton(xbox2, 10);
    Button xbox2_START = new JoystickButton(xbox2, 8);
    Button xbox2_SELECT = new JoystickButton(xbox2, 7);
    Button xbox2_L1 = new JoystickButton(xbox2, 5);
    Button xbox2_R1 = new JoystickButton(xbox2, 6);

    public double getX() {
        return xbox1.getRawAxis(3);
    }

    public double getY() {
        return Math.abs(xbox1.getRawAxis(1)) >= 0.2 ? -xbox1.getRawAxis(1) : 0;
    }

    public OI() {
        //xbox1_L1.whenPressed(new EngageTransmissionAndPullDownLauncher()); // Load
        xbox2_L1.whenPressed(new EngageTransmissionAndPullDownLauncher()); // Load
         xbox2_B.whenPressed(new ForceLoad()); // Load
         xbox2_A.whenPressed(new UnJamLauncher()); // Load
        xbox1_R1.whenPressed(new ExtendPickupAndDisengageTransmission()); // Fire
        xbox1_X.toggleWhenPressed(new RetractPickupAndExpelBall()); // ExpelBall
        xbox1_Y.toggleWhenPressed(new ExtendPickupAndLoadBall());   // LoadBall
        xbox2_Y.toggleWhenPressed(new FireAndReload());  
        xbox1_A.whenPressed(new FireAndReload()); // Auto Fire and REload
        xbox1_B.whenPressed(new RetractArm());
        xbox1_START.whileHeld(new VisionTest());
    }
}
