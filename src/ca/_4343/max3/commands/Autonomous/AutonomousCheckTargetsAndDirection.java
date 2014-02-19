package ca._4343.max3.commands.Autonomous;

import Extras.FindTarget;
import Extras.FindTarget.TargetReport;
import ca._4343.max3.GlobalConstants;
import ca._4343.max3.commands.CommandBase;

public class AutonomousCheckTargetsAndDirection extends CommandBase {
    FindTarget findtarget;
    TargetReport targetReport;
    private boolean finished;
    private boolean left;
    private byte stage = 0;
    private boolean setTimer1 = false;
    private static boolean detectedOnFirst = false;

    public AutonomousCheckTargetsAndDirection(boolean left, byte stage) {
        this.left = left;
        this.stage = stage;
        requires(drivetrain);
    }

    protected void initialize() {
        findtarget = new FindTarget();
        finished = false;
        detectedOnFirst = false;
        if(this.stage == 3)
            setTimeout(GlobalConstants.SINGLE_BALL_NO_VISION_TIMEOUT);
        //setTimeout(GlobalConstants.DELAY_BEFORE_TURNING); // If no hot goal found at placement.
    }

    protected void execute() {
        targetReport = findtarget.giveMeATarget();
        if ( stage == 0 && targetReport.Hot && targetReport != null) {
                    left = targetReport.leftScore > targetReport.rightScore;
                    detectedOnFirst = true;
                    finished = true;
        } else if (stage == 3) {
            if(!this.isTimedOut())
                finished = targetReport.Hot;
            else
                finished = true;
        } else if (!targetReport.Hot || stage == 1) {
            if(detectedOnFirst == false) {
                finished = true;
            } else {
            if(setTimer1 == false) {
                this.setTimeout(GlobalConstants.TURN_FOR);
                setTimer1 = false;
                System.out.println("----------------------Set Timer----------------------");                        
            }
            if (left) {
                if(!this.isTimedOut())
                    drivetrain.tankDrive(-GlobalConstants.AUTONOMOUS_MOTOR_TURN_SPEED, GlobalConstants.AUTONOMOUS_MOTOR_TURN_SPEED); //Turn right.
                else {
                    finished = true;
                    System.out.println("----------------------Timed out 1----------------------");
                }
                /*if (targetReport.Hot) { // Check for target.
                    finished = true;
                }*/
            } else { // right
                if(!this.isTimedOut()) 
                    drivetrain.tankDrive(GlobalConstants.AUTONOMOUS_MOTOR_TURN_SPEED, -GlobalConstants.AUTONOMOUS_MOTOR_TURN_SPEED); // Turn left.
                else {
                    finished = true;
                    System.out.println("----------------------Timed out 2----------------------");
                }
                /*if (targetReport.Hot) { // Check for target.
                    finished = true;
                }*/
            }
        }
        } else {
            finished = false;
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
        //findtarget = null; // Make it ready for garbage collector (was originally in check directions, dont know if needed, tedi had not used for start button in teleop of controller.
        drivetrain.tankDrive(0, 0);
        setTimer1 = false;
        System.out.println("FINISHED");
    }

    protected void interrupted() { }
}
