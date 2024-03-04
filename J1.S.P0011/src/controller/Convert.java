package controller;

import common.Validate;
import static common.Validate.printMessage;
import java.util.HashMap;

/**
 *
 * @author Quang Anh
 */
public class Convert {

    /**
     * Defines a string containing hexadecimal characters
     *
     */
    public static final char[] hexDigits = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    /**
     * Display menu
     *
     * @return The user's choice as an integer
     */
    public static int menu() {
        printMessage("1. Convert From Binary.");
        printMessage("2. Convert From Decimal.");
        printMessage("3. Convert From Hexa.");
        printMessage("4. Exit");
        printMessage("Enter your choice: ");
        int choice = Validate.checkInputIntLimit(1, 4);
        return choice;
    }

    /**
     * Display menu choose convert
     *
     * @param from The original format
     * @param toCase1 The first format
     * @param toCase2 The second format
     * @return The user's choice as an integer
     */
    public static int displayConvert(String from, String toCase1, String toCase2) {
        printMessage("1. Convert form " + from + " to " + toCase1);
        printMessage("2. Convert form " + from + " to " + toCase2);
        printMessage("Enter your choice: ");
        int result = Validate.checkInputIntLimit(1, 2);
        return result;
    }

    /**
     * Choose convert from Binary
     *
     * @param binary The binary number to convert. return void
     *
     */
    public static void convertfromBinary(String binary) {
        int choice = displayConvert("binary", "decimal", "hexadecimal");
        switch (choice) {
            case 1:
                printMessage("Decimal:"
                        + convertBinaryToDecimal(binary));
                break;
            case 2:
                printMessage("Hexadecimal:"
                        + convertBinaryToHexa(binary));
                break;
        }
    }

    /**
     *
     * Choose convert from Decimal
     *
     * @param decimal The decimal number to convert. return void
     *
     */
    public static void convertfromDecimal(String decimal) {
        int choice = displayConvert("decimal", "binary", "hexadecimal");
        switch (choice) {
            case 1:
                printMessage("Binary: "
                        + convertDecimalToBinary(decimal));
                break;
            case 2:
                printMessage("Hexadecimal: "
                        + convertDecimalToHexa(decimal));
                break;
        }
    }

    /**
     * Choose convert from Hexadecimal
     *
     * @param hexa The hexadecimal number to convert return void
     *
     */
    public static void convertfromHexa(String hexa) {
        int choice = displayConvert("hexadecimal", "binary", "decimal");
        switch (choice) {
            case 1:
                printMessage("Binary: "
                        + convertHexaToBinary(hexa));
                break;
            case 2:
                printMessage("Decimal: "
                        + convertHexaToBinary(hexa));
                break;
        }
    }

    /**
     * Convert Binary To Decimal
     *
     * @param binary The hexadecimal number to convert return void
     * @return The binary number has been converted to decimal
     */
    public static String convertBinaryToDecimal(String binary) {
        String[] parts = convertwithSplit(binary);
        int integer_decimal = Integer.parseInt(parts[0], 2);
        int fractional_decimal = Integer.parseInt(parts[1], 2);
        return Integer.toString(integer_decimal) + "."
                + Integer.toString(fractional_decimal);
    }
    
    


    // Create HashMap for convert from Binary to Hexdemical
    public static final HashMap<String, String> binaryToHexMap;

    static {
        binaryToHexMap = new HashMap<>();
        binaryToHexMap.put("0000", "0");
        binaryToHexMap.put("0001", "1");
        binaryToHexMap.put("0010", "2");
        binaryToHexMap.put("0011", "3");
        binaryToHexMap.put("0100", "4");
        binaryToHexMap.put("0101", "5");
        binaryToHexMap.put("0110", "6");
        binaryToHexMap.put("0111", "7");
        binaryToHexMap.put("1000", "8");
        binaryToHexMap.put("1001", "9");
        binaryToHexMap.put("1010", "A");
        binaryToHexMap.put("1011", "B");
        binaryToHexMap.put("1100", "C");
        binaryToHexMap.put("1101", "D");
        binaryToHexMap.put("1110", "E");
        binaryToHexMap.put("1111", "F");
    }

    /**
     * Convert Binary To Hexadecimal
     *
     * @param binary The binary number to convert return void
     * @return The binary number has been converted to hexadecimal
     */
    public static String convertBinaryToHexa(String binary) {
        String[] parts = convertwithSplit(binary);
        StringBuilder hexa_integer = new StringBuilder();

        // Check the length of the binary string
        int length_i = parts[0].length();
        int remainder_i = length_i % 4;

        // If not divisible by 4, add '0' to beginning of the binary string 
        if (remainder_i != 0) {
            int zerosToAdd = 4 - remainder_i;
            StringBuilder paddedBinary = new StringBuilder();
            for (int i = 0; i < zerosToAdd; i++) {
                paddedBinary.append("0");
            }
            paddedBinary.append(parts[0]);
            parts[0] = paddedBinary.toString();
            length_i = parts[0].length();
        }

        // Convert with hashmap
        for (int i = 0; i < length_i; i += 4) {
            String group = parts[0].substring(i, i + 4);
            String hexDigit = binaryToHexMap.get(group);
            hexa_integer.append(hexDigit);
        }

        StringBuilder hexa_fractional = new StringBuilder();

        // Check the length of the binary string
        int length_f = parts[1].length();
        int remainder_f = length_f % 4;

        // If not divisible by 4, add '0' to beginning of the binary string 
        if (remainder_f != 0) {
            int zerosToAdd = 4 - remainder_f;
            StringBuilder paddedBinary = new StringBuilder();
            for (int i = 0; i < zerosToAdd; i++) {
                paddedBinary.append("0");
            }
            paddedBinary.append(parts[1]);
            parts[1] = paddedBinary.toString();
            length_f = parts[1].length();
        }

        // Convert with hashmap
        for (int i = 0; i < length_f; i += 4) {
            String group = parts[1].substring(i, i + 4);
            String hexDigit = binaryToHexMap.get(group);
            hexa_fractional.append(hexDigit);
        }

        return hexa_integer.toString() + "." + hexa_fractional.toString();
    }

    // Create HashMap for convert from Hexdemical to Binary 
    public static final HashMap<String, String> hexatoBinaryMap;

    static {
        hexatoBinaryMap = new HashMap<>();
        hexatoBinaryMap.put("0", "0000");
        hexatoBinaryMap.put("1", "0001");
        hexatoBinaryMap.put("2", "0010");
        hexatoBinaryMap.put("3", "0011");
        hexatoBinaryMap.put("4", "0100");
        hexatoBinaryMap.put("5", "0101");
        hexatoBinaryMap.put("6", "0110");
        hexatoBinaryMap.put("7", "0111");
        hexatoBinaryMap.put("8", "1000");
        hexatoBinaryMap.put("9", "1001");
        hexatoBinaryMap.put("A", "1010");
        hexatoBinaryMap.put("B", "1011");
        hexatoBinaryMap.put("C", "1100");
        hexatoBinaryMap.put("D", "1101");
        hexatoBinaryMap.put("E", "1110");
        hexatoBinaryMap.put("F", "1111");
    }

    /**
     * Convert Hexadecimal To Binary
     *
     * @param hexadecimal The hexadecimal number to convert return void
     * @return The hexadecimal number has been converted to binary
     */
    public static String convertHexaToBinary(String hexadecimal) {
        String[] parts = convertwithSplit(hexadecimal);
        StringBuilder binary_integer = new StringBuilder();
        for (int i = 0; i < parts[0].length(); i++) {
            String key_integer = Character.toString(hexadecimal.charAt(i));
            String result = hexatoBinaryMap.get(key_integer);
            binary_integer.append(result);
        }

        StringBuilder binary_fractional = new StringBuilder();
        for (int j = 0; j < parts[1].length(); j++) {
            String key_fractional = Character.toString(hexadecimal.charAt(j));
            String result = hexatoBinaryMap.get(key_fractional);
            binary_fractional.append(result);
        }

        return binary_integer.toString() + "." + binary_fractional;
    }

    /**
     * Convert Hexadecimal To Decimal
     *
     * @param hexadecimal The hexadecimal number to convert return void
     * @return The hexadecimal number has been converted to decimal
     */
    public static String convertHexaToDecimal(String hexadecimal) {
        String[] parts = convertwithSplit(hexadecimal);
        int integer_hexa = Integer.parseInt(parts[0], 16);
        int fractional_hexa = Integer.parseInt(parts[1], 16);
        return Integer.toString(integer_hexa) + "."
                + Integer.toString(fractional_hexa);
    }

    /**
     * Convert Decimal To Binary
     * 
     * @param decimal The decimal number to convert return void
     * @return The decimal number has been converted to binary
     */
    public static String convertDecimalToBinary(String decimal) {
        String[] parts = convertwithSplit(decimal);
        String integer_binary = Integer.toBinaryString(Integer.parseInt(parts[0]));
        String fractional_binary = Integer.toBinaryString(Integer.parseInt(parts[1]));
        return integer_binary + "." + fractional_binary;
    }

    /**
     *
     * Convert Decimal to Binary or Hexadecimal
     *
     * @param decimal The decimal number to convert return void
     * @return The decimal number has been converted to hexadecimal
     */
    public static String convertDecimalToHexa(String decimal) {
        String[] parts = convertwithSplit(decimal);
        String hexa_integer = "";
        String hexa_fractional = "";
        int deci_integer = Integer.parseInt(parts[0]);
        while (deci_integer != 0) {
            hexa_integer = hexDigits[deci_integer % 16] + hexa_integer;
            deci_integer /= 16;
        }
        int deci_fractional = Integer.parseInt(parts[1]);
        while (deci_fractional != 0) {
            hexa_fractional = hexDigits[deci_fractional % 16] + hexa_fractional;
            deci_fractional /= 16;
        }

        return hexa_integer + "." + hexa_fractional;
    }

    /**
     * Divide the number the user entered into 2 parts if it is a fractional number
     * 
     * @param number The number that the user entered to convert
     * @return The number that the user enters after dividing it into parts
     */
    public static String[] convertwithSplit(String number) {
        String[] parts = new String[2];

        // Default values if no fractional part
        parts[0] = number;
        parts[1] = "0";

        int dotIndex = number.indexOf('.');
        if (dotIndex != -1) {
            parts[0] = number.substring(0, dotIndex);
            parts[1] = number.substring(dotIndex + 1);
        }
        return parts;
    }
}
