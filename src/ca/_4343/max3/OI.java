
package ca._4343.max3;

import ca._4343.max3.commandGroups.FireAndReloadSequence;
import ca._4343.max3.commandGroups.FireSequence;
import ca._4343.max3.commandGroups.PickupBallSequence;
import ca._4343.max3.commandGroups.PullDownLauncherSequence;
import ca._4343.max3.commands.VisionTest;
import ca._4343.max3.commands.pickup.ExpelBall;
import ca._4343.max3.commands.pickup.ExtendArm;
import ca._4343.max3.commands.pickup.RetractArm;
import ca._4343.max3.commands.transmission.TransmissionDoNothing;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class OI {
    
    public OI() {
        // Xbox 1 Buttons
        xbox1_B.toggleWhenPressed(new ExpelBall());
        xbox1_Y.toggleWhenPressed(new PickupBallSequence());
        xbox1_A.whenPressed(new FireAndReloadSequence());
        xbox1_X.whenPressed(new TransmissionDoNothing());
        xbox1_R1.whenPressed(new FireSequence());
        xbox1_L1.whenPressed(new PullDownLauncherSequence());
        xbox1_START.whileHeld(new VisionTest());
        
        
        // Xbox 2 Buttons
        xbox2_X.whenPressed(new TransmissionDoNothing());
        xbox2_A.whenPressed(new FireSequence()); //
        xbox2_B.whenPressed(new PullDownLauncherSequence());
        xbox2_R1.whenPressed(new ExtendArm());
        xbox2_L1.whenPressed(new RetractArm());
        xbox2_START.whileHeld(new VisionTest());
        
    }
    /**
     * @return X axis on controller 
     */
    public double getX() {
        return xbox1.getRawAxis(3);
    }
    /**
     * @return Y axis on controller with joystick dead zone compensation
     */
    public double getY() {
        return Math.abs(xbox1.getRawAxis(1)) >= 0.2 ? -xbox1.getRawAxis(1) : 0;
    }
    
    //Joystick's
    Joystick xbox1 = new Joystick(1);
    Joystick xbox2 = new Joystick(2);
    
    // Buttons on joystick 1
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
    
    // Buttons on joystick 2
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
    
}

