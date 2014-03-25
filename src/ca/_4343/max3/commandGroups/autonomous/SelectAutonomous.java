/*
 * Team 4343
 * Visit us at www.4343.ca
 */

package ca._4343.max3.commandGroups.autonomous;

/**
 *
 * @author Tedi Papajorgji <www.4343.ca>
 * @author Brian Ho <www.4343.ca>
 */
public class SelectAutonomous {
    /* Java 1.3 is so bad...........
    * These are possible values for type:
    * 1 - 1 Ball Hot | Any Side
    * 2 - 2 Ball No Hot | Any Side
    * 3 - 2 Ball Hot | Left Side
    * 4 - 2 Ball Hot | Right Side
    * 5 - 2 Ball Hot ALT | Left Side
    * 6 - 2 Ball Hot ALT | Right Side
    */
    
    public SelectAutonomous(int type) {
        nameOfAutonomous = "" + type;
    }
    
    private final String nameOfAutonomous;
    
    public String toString() {
        return nameOfAutonomous;
    }
    
}
