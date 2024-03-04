package common;

import java.util.Scanner;

/**
 *
 * @author Quang Anh
 */
public class Validate {

    private final static Scanner scan = new Scanner(System.in);
    private static final String BINARY_VALID = "[0-1 .]*";
    private static final String DECIMAL_VALID = "[0-9 .]*";
    private static final String HEXADECIMAL_VALID = "[0-9A-F .]*";

    /**
     *
     * Check the user's input
     *
     * @param min Minimum value of input
     * @param max Maximum value of input
     * @return The user's input as an integer
     */
    public static int checkInputIntLimit(int min, int max) {
        int input = 0;
        boolean result = false;
        while (!result) {
            try {
                input = scan.nextInt();
                //Check input in range
                if (input < min || input > max) {
                    printMessage("Please input number in range: " + min + "," + max);
                } else {
                    result = true;
                }
            } catch (NumberFormatException e) {
                printMessage("Please input number: ");
                scan.nextLine();
            }
        }
        return input;
    }

    /**
     * Checks user input is a binary number
     *
     * @return The user's input as an string
     */
    public static String checkInputBinary() {
        String value;
        boolean validInput = false;

        do {
            printMessage("Enter number binary: ");
            value = scan.nextLine().trim();

            if (value.matches(BINARY_VALID)) {
                validInput = true;
            } else {
                System.err.println("Must be enter 0 and 1");
                printMessage("Enter again: ");
            }
        } while (!validInput);

        return value;
    }

    /**
     * Checks user input is a decimal number
     *
     * @return The user's input as an string
     */
    public static String checkInputDecimal() {
        printMessage("Enter number decimal: ");
        String value = "";
        value = scan.nextLine().trim();
        boolean result = true;
        //loop until user input correct
        while (result) {
            value = scan.nextLine().trim();
            if (value.matches(DECIMAL_VALID)) {
                return value;
            } else {
                System.err.println("Must be enter 0-9");
                printMessage("Enter again: ");
            }
        }
        return value;
    }

    /**
     * Checks user input is a hexadecimal number
     *
     * @return The user's input as an string
     */
    public static String checkInputHexa() {
        printMessage("Enter number hexadecimal: ");
        String value;
        value = scan.nextLine().trim();
        //loop until user input correct
        while (true) {
            value = scan.nextLine().trim();
            if (value.matches(HEXADECIMAL_VALID)) {
                return value;
            } else {
                System.err.println("Must be enter 0-9 , A-F");
                printMessage("Enter again: ");
            }
        }
    }

    /**
     * Use to print message
     *
     * @param message Used to pass strings into messages to write programs
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }
}
