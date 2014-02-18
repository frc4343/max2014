package ca._4343.max3.commands.Autonomous;

import Extras.FindTarget;
import Extras.FindTarget.TargetReport;
import ca._4343.max3.commands.CommandBase;

public class AutonomousCheckTargetsAndDirection extends CommandBase {
    FindTarget findtarget;
    TargetReport targetReport;
    private boolean finished;
    private static boolean left;
    private byte stage = 0;

    public AutonomousCheckTargetsAndDirection(boolean left, byte stage) {
        this.left = left;
        this.stage = stage;
        requires(drivetrain);
    }

    protected void initialize() {
        findtarget = new FindTarget();
        finished = false;
        //setTimeout(GlobalConstants.DELAY_BEFORE_TURNING); // If no hot goal found at placement.
    }

    protected void execute() {
        //drivetrain.disableSafety();
        targetReport = findtarget.giveMeATarget();
        if (targetReport.Hot && stage == 0) {
            left = targetReport.leftScore > targetReport.rightScore;
            finished = true;
        } else if (!targetReport.Hot || stage == 1) {
            if (left) {
                drivetrain.tankDrive(1, 0); //Turn right.
                if (targetReport.Hot) { // Check for target.
                    finished = true;
                }
            } else { // right
                drivetrain.tankDrive(0, 1); // Turn left.
                if (targetReport.Hot) { // Check for target.
                    finished = true;
                }
            }
        } else if (stage == 3) {
            finished = targetReport.Hot;
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
        System.out.println("FINISHED");
    }

    protected void interrupted() { }
}
