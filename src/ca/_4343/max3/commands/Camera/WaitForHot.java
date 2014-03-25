/*
 * Team 4343
 * Visit us at www.4343.ca
 */

package ca._4343.max3.commands.Camera;

import ca._4343.util.FindTarget;
import ca._4343.util.FindTarget.TargetReport;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class WaitForHot extends Command {

    FindTarget findTarget;
    TargetReport tg;
    protected void initialize() {
        findTarget = new FindTarget();
    }

    protected void execute() {
        tg = findTarget.giveMeATarget();
    }

    protected boolean isFinished() {
        if(tg.Hot) {
            return true;
        }
        return false;
    }

    protected void end() {
        findTarget = null;
        tg = null;
    }

    protected void interrupted() {

    }
    
}
