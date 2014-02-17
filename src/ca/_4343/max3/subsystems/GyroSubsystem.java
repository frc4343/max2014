/*package ca._4343.max3.subsystems;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GyroSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Gyro gyro = new Gyro(1);
    double initialAngle = 0;
    boolean isRotatingClockwise = true;
    double rotationAmount = 0;
    boolean finishedRotating = false;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void getAngle(){
        gyro.getAngle();
    }
    public void
    public void whatever() {
        gyro.
    }
    public void rotate(double angle) {
        initialAngle = gyro.getAngle();
        rotationAmount = angle;
        robot.driveSystem.driveIndefinitely(0.0, angle > 0 ? Mappings.ROTATE_SPEED : -Mappings.ROTATE_SPEED);

        systemState = ROTATING;
    }
}*/
