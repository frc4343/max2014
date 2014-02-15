/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca._4343.max3.subsystems;

import ca._4343.max3.commands.TrackTarget;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author CC
 */
public class AxisCameraSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private AxisCamera camera; 
    
    public AxisCameraSubsystem() {
        camera = AxisCamera.getInstance();
    }

    public AxisCamera getAxisCameraInstance() {
        return camera;
    }
    
     
    public void initDefaultCommand() {
       // this.setDefaultCommand(new TrackTarget());
    }
}
