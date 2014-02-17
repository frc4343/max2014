package ca._4343.max3;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final byte // PWM OUT
            // These are the ports that the motor controllers are connected to on the Digital Sidecar
            pwm_leftMotorPair = 8,
            pwm_rightMotorPair = 9,
            pwm_launcherMotorPair = 10,
            pwm_pickupMotor = 7,

    // COMPRESSOR
    relay_compressor = 1,
            gpio_compressor_pressure_switch = 1,
    // DIGITAL IO / GENERAL PURPOSE INPUT OUTPUT (GPIO)
    gpio_launcher_fullyLoaded_LimitSwitch = 2,
            gpio_ball_inBasket_Sensor_LimitSwitch = 3,
            gpio_transmission_extended = 4,
            gpio_transmission_retracted = 5,
    // CRIO - ANALOG MODULE
    crio_analogModule_GyroSensor = 3;

    public static DriverStation ds;


}
