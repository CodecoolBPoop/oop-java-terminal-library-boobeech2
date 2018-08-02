package com.codecool.termlib;
import java.util.Scanner;

public class Terminal {

    /**
     * The beginning of control sequences.
     */
    private static final String CONTROL_CODE = "\033[";
    /**
     * Command for whole screen clearing.
     *
     * Might be partitioned if needed.
     */
    private static final String CLEAR = "2J";
    /**
     * Command for moving the cursor.
     */
    private static final String MOVE = "H";
    /**
     * Command for printing style settings.
     *
     * Handles foreground color, background color, and any other
     * styles, for example color brightness, or underlines.
     */
    private static final String STYLE = "m";

    /**
     * Reset printing rules in effect to terminal defaults.
     *
     * Reset the color, background color, and any other style
     * (i.e.: underlined, dim, bright) to the terminal defaults.
     */
    public void resetStyle() {
        System.out.println(CONTROL_CODE + "0" + STYLE);
    }

    /**
     * Clear the whole screen.
     *
     * Might reset cursor position.
     */
    public static void clearScreen() {
        System.out.printf(CONTROL_CODE + CLEAR);
    }

    /**
     * Move cursor to the given position.
     *
     * Positions are counted from one.  Cursor position 1,1 is at
     * the top left corner of the screen.
     *
     * @param x Column number.
     * @param y Row number.
     */
    public static void moveTo(Integer x, Integer y) {
        System.out.printf(CONTROL_CODE + x + ";" + y + MOVE);
    }

    /**
     * Set the foreground printing color.
     *
     * Already printed text is not affected.
     *
     * @param color The color to set.
     */

     
    public static String setColor(String color) {
        String colorNumber = new String("");
       switch(color) {
        case "BLACK":
            colorNumber = "30";
            break;
        case "RED":
            colorNumber = "31";
            break;
        case "GREEN":
            colorNumber = "32";
            break;
        case "YELLOW":
            colorNumber = "33";
            break;
        case "BLUE":
            colorNumber = "34";
            break;
        case "MAGENTA":
            colorNumber = "35";
            break;
        case "CYAN":
            colorNumber = "36";
            break;
        case "WHITE":
            colorNumber = "37";
            break;
       }
       return  CONTROL_CODE + colorNumber + STYLE;
    }
 
    /**
     * Set the background printing color.
     *
     * Already printed text is not affected.
     *
     * @param color The background color to set.
     */
    
    public static String setBgColor(String color) {
        String colorNumber = new String("");
       switch(color) {
        case "BLACK":
            colorNumber = "40";
            break;
        case "RED":
            colorNumber = "41";
            break;
        case "GREEN":
            colorNumber = "42";
            break;
        case "YELLOW":
            colorNumber = "43";
            break;
        case "BLUE":
            colorNumber = "44";
            break;
        case "MAGENTA":
            colorNumber = "45";
            break;
        case "CYAN":
            colorNumber = "46";
            break;
        case "WHITE":
            colorNumber = "47";
            break;
       }
       return  CONTROL_CODE + colorNumber + STYLE;
    }
    
    /**
     * Make printed text underlined.
     *
     * On some terminals this might produce slanted text instead of
     * underlined.  Cannot be turned off without turning off colors as
     * well.
     */
    public static String setUnderline() {
        return CONTROL_CODE + "4" + STYLE;
    }

    /**
     * Move the cursor relatively.
     *
     * Move the cursor amount from its current position in the given
     * direction.
     *
     * @param direction Step the cursor in this direction.
     * @param amount Step the cursor this many times.
     */
    
    public static void moveCursor(String direction, Integer amount) {
        String movementKey = new String("");
        switch(direction){
            case "UP":
                movementKey = "A";
                break;
            case "DOWN":
                movementKey = "B";
                break;
            case "BACKWARD":
                movementKey = "D";
                break;
            case "FORWARD":
                movementKey = "C";
                break;
        }
        System.out.printf(CONTROL_CODE + amount + movementKey);
    }
    
    /**
     * Set the character diplayed under the current cursor position.
     *
     * The actual cursor position after calling this method is the
     * same as beforehand.  This method is useful for drawing shapes
     * (for example frame borders) with cursor movement.
     *
     * @param c the literal character to set for the current cursor
     * position.
     */
    public static void setChar(char c) {
        System.out.println(CONTROL_CODE + c + "p");
    }

    /**
     * Helper function for sending commands to the terminal.
     *
     * The common parts of different commands shall be assembled here.
     * The actual printing shall be handled from this command.
     *
     * @param commandString The unique part of a command sequence.
     */
    private static void command(String commandString) {
        System.out.println(commandString);
    }

    public static void main(String[] args) {
        System.out.println("helloooo");
        Scanner scan = new Scanner(System.in);
        String i = scan.nextLine();
        clearScreen();
        moveTo(120, 10);
        moveCursor("UP", 100);
        command(setBgColor("RED") + "Józsi");
    }
}
