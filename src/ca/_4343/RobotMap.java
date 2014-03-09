package ca._4343;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class RobotMap {
    public static final byte
            // MOTORS
                TRANSMISSION_MOTOR = 6,
                PICKUP_MOTOR = 7, 
                LEFT_MOTOR_PAIR = 8,
                RIGHT_MOTOR_PAIR = 9,
                LAUNCHER_MOTOR_PAIR = 10,        
            // COMPRESSOR
                COMPRESSOR_RELAY = 1,
                COMPRESSOR_PRESSURE_SWITCH = 1, // GPIO
            // SOLENOIDS
                SOLENOID_EXTEND = 3,
                SOLENOID_RETRACT = 4,
                SOLENOID_RED_LED = 1,
                SOLENOID_GREEN_LED = 2,
                SOLENOID_BLUE_LED = 3,
            // LAUNCHER
                LAUNCHER_PULLED_DOWN_LIMITSWITCH=  2,
                LAUNCHER_BALL_LOADED_LIMITSWITCH = 3,
            // TRANSMISSION
                TRANSMISSION_NEUTRAL_LIMITSWITCH = 4,
                TRANSMISSION_DRIVE_LIMITSWITCH = 5,
            // CRIO - ANALOG MODULE
                GYRO_SENSOR = 3;
                //RANGE_SENSOR = X;
}
