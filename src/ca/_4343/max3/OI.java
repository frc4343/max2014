
package ca._4343.max3;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import ca._4343.max3.commands.ExpelBall;
import ca._4343.max3.commands.Fire;
import ca._4343.max3.commands.FireAndReload;
import ca._4343.max3.commands.PickupBall;
import ca._4343.max3.commands.PrepareLauncherForPickup;
import ca._4343.max3.commands.RetractTransmission;

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
    public double getX() {
        return Math.abs(xbox1.getRawAxis(3)) >= 0.2 ? xbox1.getRawAxis(3) : 0; 
    }
    public double getY() {
        return Math.abs(xbox1.getRawAxis(1)) >= 0.2 ? -xbox1.getRawAxis(1) : 0;
    }
    public OI() {
        xbox1_L1.whenPressed(new PrepareLauncherForPickup());
        
        //xbox1_R1.whenPressed(new Fire());
        xbox1_X.toggleWhenPressed(new ExpelBall());
        xbox1_Y.toggleWhenPressed(new PickupBall());
        xbox1_A.whenPressed(new FireAndReload());
        
        //xbox1_B.whenPressed(new RetractTransmission());
        
    }
}

