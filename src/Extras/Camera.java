/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Extras;

import edu.wpi.first.wpilibj.camera.AxisCamera;

/**
 *
 * @author CC
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
