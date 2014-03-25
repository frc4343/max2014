/*
 * Team 4343
 * Visit us at www.4343.ca
 */

package ca._4343;

import edu.wpi.first.wpilibj.camera.AxisCamera;

/**
 *
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class Camera {
    
    private static AxisCamera camera;

    public static void init() {
        camera = AxisCamera.getInstance();
    }

    public static AxisCamera getCamera() {
        return camera;
    }
    
}
