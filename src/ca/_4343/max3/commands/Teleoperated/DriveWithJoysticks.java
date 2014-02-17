package ca._4343.max3.commands.Teleoperated;

import ca._4343.max3.commands.CommandBase;

public class DriveWithJoysticks extends CommandBase {
    public DriveWithJoysticks() {
        requires(drivetrain);
    }

    protected void initialize() { }

    protected void execute() {
        drivetrain.arcadeDrive(oi.getX(), oi.getY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() { }

    protected void interrupted() { }
}
