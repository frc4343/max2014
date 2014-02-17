package ca._4343.max3.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Nikita Pekin
 */
public class Piston extends Subsystem {
    // Initialize an array of two solenoids to handle the solenoids controlling the piston.
    Solenoid[] solenoids = new Solenoid[2];

    // The constructor which takes all the values required to define and operate a piston.
    public Piston(byte firstSolenoid, byte secondSolenoid, boolean isExtended) {
        solenoids[0] = new Solenoid(firstSolenoid);
        solenoids[1] = new Solenoid(secondSolenoid);

        setExtended(isExtended);
    }

    public void extend() {
        setExtended(true);
    }

    public void retract() {
        setExtended(false);
    }

    private void setExtended(boolean isExtended) {
        solenoids[0].set(isExtended);
        solenoids[1].set(!isExtended);
    }

    public void initDefaultCommand() {
        //setDefaultCommand(new DefaultPistonPositions());
    }
}
