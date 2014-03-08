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
    public static final double
            TRANSMISSION_ROTATE_TO_DRIVE_SPEED = 0.275,
            LAUNCHER_TURN_SLOWLY_SPEED = 0.40,
            PICKUP_UNSTICK_BALL_SPEED = 0.2,
            EXPEL_BALL_TIMEOUT = 1,
            UNSTICK_BALL_TIMEOUT = 1,
            EXTEND_ARM_TIMEOUT = 3,
            AUTONOMOUS_DRIVE_DURATION = 1,
            AUTONOMOUS_SINGLE_BALL_HOT_GOAL_TIMEOUT = 6.5,
            AUTONOMOUS_DOUBLE_BALL_HOT_GOAL_TIMEOUT = 1,
            AUTONOMOUS_MOTOR_TURN_SPEED = 0.65,
            AUTONOMOUS_TURN_DURATION = 0.4;
    
    /*
    Vision Tracking Constants
    */
        //Camera constants used for distance calculation
            public static final int Y_IMAGE_RES = 480;		//X Image resolution in pixels, should be 120, 240 or 480
            public static final double VIEW_ANGLE = 37.4;  //Axis M1011 camera
            public static final double PI = 3.141592653;

        //Score limits used for target identification
            public static final int  RECTANGULARITY_LIMIT = 40;
            public static final int ASPECT_RATIO_LIMIT = 55;

        //Score limits used for hot target determination
            public static final int TAPE_WIDTH_LIMIT = 50;
            public static final int  VERTICAL_SCORE_LIMIT = 50;
            public static final int LR_SCORE_LIMIT = 50;

        //Minimum area of particles to be considered
            public static final int AREA_MINIMUM = 150;

        //Maximum number of particles to process
            public static final int MAX_PARTICLES = 8;
            
           
}
