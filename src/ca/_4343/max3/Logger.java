package ca._4343.max3;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.DriverStationLCD.Line;

public class Logger {
    DriverStationLCD dsLCD = DriverStationLCD.getInstance();

    private void clearLine(DriverStationLCD.Line line) {
        printLine(line, "                     "); // WPILIB only supports 21 lines printing
    }

    public void clearWindow() {
        clearLine(DriverStationLCD.Line.kUser1);
        clearLine(DriverStationLCD.Line.kUser2);
        clearLine(DriverStationLCD.Line.kUser3);
        clearLine(DriverStationLCD.Line.kUser4);
        clearLine(DriverStationLCD.Line.kUser5);
        clearLine(DriverStationLCD.Line.kUser6);
    }

    public void printLine(Line line, String string) {
        dsLCD.println(line, 1, string);
    }

    public void updateLCD() {
        dsLCD.updateLCD();
    }
}
