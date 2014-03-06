package ca._4343.max3.subsystems;

import ca._4343.max3.RobotMap;
import ca._4343.max3.commands.FiringSystem.TransmissionDoNothing;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Transmission extends Subsystem {
    SpeedController motor = new Victor(6);
    DigitalInput extendedlimitSwitch = new DigitalInput(RobotMap.gpio_transmission_extended);
    DigitalInput retractedlimitSwitch = new DigitalInput(RobotMap.gpio_transmission_retracted);
    Timer superTimer = new Timer();

    public void initDefaultCommand() {
        setDefaultCommand(new TransmissionDoNothing());
    }

    public void extend() {
        motor.set(1);
    }

    public boolean extended() {
        return extendedlimitSwitch.get();
    }

    public void retract() {
        /*superTimer.reset();
        superTimer.start();*/
        motor.set(-.275);
    }

    public boolean retracted() {
        return retractedlimitSwitch.get(); /*|| superTimer.get() > 0.314;*/
    }

    public void stop() {
        motor.set(0);
        //superTimer.stop();
    }
}
