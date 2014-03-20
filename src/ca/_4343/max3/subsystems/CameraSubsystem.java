/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.subsystems;

import ca._4343.max3.commands.camera.WaitForHot;
import ca._4343.util.Camera;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author brianho
 */
public class CameraSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Camera camera = new Camera();
    
    public void initDefaultCommand() {
        //setDefaultCommand(new WaitForHot());
    }
    
    public boolean findTarget() {
        return false;
        //return camera.findTarget();
    } 
}
