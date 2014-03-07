package ca._4343;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final byte
            // MOTORS
                leftMotorPair = 8,
                rightMotorPair = 9,
                launcherMotorPair = 10,
                pickupMotor = 7,            
            // COMPRESSOR
                compressor_relay = 1,
                compressor_pressure_switch = 1,
            //Launcher
                launcher_load_LimitSwitch = 2,
                launcher_ball_LimitSwitch = 3,
            //Transmission
                transmission_neutral = 4,
                transmission_drive = 5,
            // CRIO - ANALOG MODULE
                GyroSensor = 3;
}
