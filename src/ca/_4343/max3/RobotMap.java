package ca._4343.max3;

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
            gpio_ball_inBasket_Sensor_LimitSwitch = 9,
            gpio_launcher_fullyLoaded_LimitSwitch = 2,
            gpio_pickUpSensor_Extended_LimitSwitch = 3,
            gpio_pickUpSensor_Retracted_LimitSwitch = 4,
            gpio_launcherMotor_Encoder_Channel_A = 5,
            gpio_launcherMotor_Encoder_Channel_B = 6,
            // CRIO - ANALOG MODULE
            crio_analogModule_GyroSensor = 3;

}
