package ca._4343.max3.subsystems;

import ca._4343.max3.RobotMap;
import ca._4343.max3.commands.Teleoperated.DriveWithJoysticks;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveTrain extends PIDSubsystem {
    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;

    private RobotDrive drive = new RobotDrive(RobotMap.pwm_rightMotorPair, RobotMap.pwm_leftMotorPair);

    //private SpeedController victorLeft = new Victor(RobotMap.pwm_leftMotorPair);
    //private SpeedController victorRight = new Victor(RobotMap.pwm_rightMotorPair);

    public DriveTrain() {
        super("DriveTrain", Kp, Ki, Kd);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
    }

    protected double returnPIDInput() {
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        tankDrive(output, output);
    }

    public void disableSafety() { // Stops "robot drive not updated enough" when enabled.
        drive.setSafetyEnabled(false);
    }

    public void enableSafety() { // Enable this when you want to drive.
        drive.setSafetyEnabled(true);
    }

    public void disableMotors() {
        drive.stopMotor();
    }

    public void tankDrive(double left, double right) {
        if (!drive.isSafetyEnabled()) { // Just in case we disabled safety earlier and forgot to enable.
            enableSafety();
        }
        drive.tankDrive(left, right);
    }

    public void arcadeDrive(double x, double y) {
        if (!drive.isSafetyEnabled()) { // Just in case we disabled safety earlier and forgot to enable.
            enableSafety();
        }
        //drive.arcadeDrive(x, y < 0 ? -(y*y) : (y*y));
        drive.arcadeDrive(x, y);
    }
}
