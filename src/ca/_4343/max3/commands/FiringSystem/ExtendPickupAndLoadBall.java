package ca._4343.max3.commands.FiringSystem;

import ca._4343.max3.GlobalConstants;
import ca._4343.max3.RobotMap;
import ca._4343.max3.commands.CommandBase;

public class ExtendPickupAndLoadBall extends CommandBase {
    public ExtendPickupAndLoadBall() {
        requires(pickup);
        requires(pickupPistons);
        requires(launcher);
    }

    protected void initialize() {
        //this.setTimeout(GlobalConstants.PICKUP_BALL_DELAY);
    }

    protected void execute() {
        pickupPistons.extend();
        System.out.println("Launcher is ready: "+launcher.isReadyToLoadOrFire());
        System.out.println("Pickup is loaded: " + pickup.isLoaded());
        if(!pickup.isLoaded()) {
             if (launcher.isReadyToLoadOrFire() && !pickup.isLoaded()) {
                pickup.load();
            }
        }
    }

    protected boolean isFinished() {
        //if (RobotMap.ds.isAutonomous()) {
            //return isTimedOut();
       // } else {
            return pickup.isLoaded();
        //}
    }

    protected void end() {
        if(RobotMap.ds.isAutonomous())
            pickup.doNothing();
        pickupPistons.retract();
    }

    protected void interrupted() { }
}
