package ca._4343.util;

import edu.wpi.first.wpilibj.camera.AxisCamera;

public class Camera {
    private static AxisCamera camera;

    public static void init() {
        camera = AxisCamera.getInstance();
    }

    public static AxisCamera getCamera() {
        return camera;
    }
}
