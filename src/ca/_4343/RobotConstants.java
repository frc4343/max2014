/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package ca._4343;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class RobotConstants {

    public static final double // Motor Speeds
            TRANSMISSION_ROTATE_TO_DRIVE_SPEED = 0.15,
            LAUNCHER_TURN_SLOWLY_SPEED = 0.275,
            PICKUP_WHEELS_UNSTICK_BALL_SPEED = 0.2,
            // Timeouts and Durations in Seconds
            EXPEL_BALL_TIMEOUT = 1,
            UNSTICK_BALL_DURATION = 1,
            TIME_REQUIRED_TO_EXTEND_ARM = 1, // PlaceHolder
            TIME_WAIT_AFTER_SHOT = 3,
            // Distance Variables
            TOO_CLOSE_DISTANCE = 0, // Placeholder
            TOO_FAR_DISTANCE = 0, // Placeholder
            // Autonomous Variables
            AUTONOMOUS_DRIVE_DURATION = 1,
            AUTONOMOUS_TURN_DURATION = 0.4,
            AUTONOMOUS_MOTOR_TURN_SPEED = 0.65,
            AUTONOMOUS_SINGLE_BALL_HOT_GOAL_TIMEOUT = 6.5,
            AUTONOMOUS_DOUBLE_BALL_HOT_GOAL_TIMEOUT = 1,
            AUTONOMOUS_OPTIMAL_DISTANCE_FROM_GOAL = 300, // placeholder in inches
            AUTONOMOUS_OPTIMAL_DISTANCE_FOR_BALL_PICKUP = 500, // placeholder in inches
            AUTONOMOUS_TURN_TO_ANGLE = 45; // placeholder in degrees
}
