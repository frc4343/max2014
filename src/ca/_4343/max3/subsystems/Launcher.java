package ca._4343.max3.subsystems;

import ca._4343.max3.RobotMap;
import ca._4343.max3.commands.FiringSystem.LauncherDoNothing;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Launcher extends PIDSubsystem {
    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;

    SpeedController launcherMotor = new Victor(RobotMap.pwm_launcherMotorPair);
    DigitalInput limitSwitch = new DigitalInput(RobotMap.gpio_launcher_fullyLoaded_LimitSwitch);

    public Launcher() {
        super("Launcher", Kp, Ki, Kd);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new LauncherDoNothing());
    }

    protected double returnPIDInput() {
        return 0.0;
    }

    protected void usePIDOutput(double output) { }

    public void doNothing() {
        launcherMotor.set(0);
    }

    public void set(double speed) {
        // Forces the motor to only go one way.
        launcherMotor.set(-Math.abs(speed));
    }

    public void pulseMotor() {
        // Forces the motor to only go one way.
        launcherMotor.set(-1); // Set to negative for testing.
    }

    public boolean isReadyToLoadOrFire() {
        return !limitSwitch.get();
    }
}
