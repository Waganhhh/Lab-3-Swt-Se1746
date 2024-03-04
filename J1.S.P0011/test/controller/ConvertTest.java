/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Quang Anh
 */
public class ConvertTest {

    Convert cv;

    public ConvertTest() {
        cv = new Convert();
    }

    //binary-decimal
    @Test
    public void testConvertBinaryToDecimal() {
        String binary = "1111";
        String result = cv.convertBinaryToDecimal(binary);
        String expect = "15";
        assertEquals(expect, result);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertBinaryToDecimal_invalidInput_nonBinaryCharacter() {
        String binary = "13";
        cv.convertBinaryToDecimal(binary);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertBinaryToDecimal_invalidInput_emptyString() {
        String binary = "";
        cv.convertBinaryToDecimal(binary);
    }

    @Test
    public void testConvertBinaryToDecimal_notsame() {
        String binary = "1111";
        String result = cv.convertBinaryToDecimal(binary);
        String expect = "9";
        assertEquals(expect, result);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertBinaryToHexa_invalidInput_nullInput() {
        String binary = null;
        cv.convertBinaryToDecimal(binary);
    }

    
    
    //binary-hexa
    @Test
    public void testConvertBinaryToHexa_validInput() {
        String binary = "11011010.10101101";
        String result = cv.convertBinaryToHexa(binary);
        String expect = "DA.AD";
        assertEquals(expect, result);
    }

    @Test
    public void testConvertBinaryToHexa_validInput_withLeadingZeros() {
        String binary = "11011010.10101101";
        String result = cv.convertBinaryToHexa(binary);
        String expect = "DA.AB";
        assertEquals(expect, result);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertBinaryToHexa_invalidInput_nonBinaryCharacter() {
        String binary = "12.101";
        cv.convertBinaryToHexa(binary);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertBinaryToHexa_invalidInput_emptyString() {
        String binary = "";
        cv.convertBinaryToHexa(binary);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertBinaryToHexa_invalidInput_nullInput1() {
        String binary = null;
        cv.convertBinaryToHexa(binary);
    }

    
    
    
    //hexa-binary
    @Test
    public void testConvertHexaToBinary_validInput() {
        String hexadecimal = "2B.D2";

        String result = cv.convertHexaToBinary(hexadecimal);

        assertEquals("00101011.11010010", result);
    }

    @Test
    public void testConvertHexaToBinary_notsame() {
        String hexadecimal = "2B.D2";

        String result = cv.convertHexaToBinary(hexadecimal);

        assertEquals("12.01", result);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertHexaToBinary_invalidInput_nonHexadecimalCharacter() {
        String hexadecimal = "2K.A5";

        cv.convertHexaToBinary(hexadecimal);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertHexaToBinary_invalidInput_emptyString() {
        String hexadecimal = "";

        cv.convertHexaToBinary(hexadecimal);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertHexaToBinary_invalidInput_nullInput() {
        String hexadecimal = null;

        cv.convertHexaToBinary(hexadecimal);
    }

    
    //hexa-decimal
    @Test
    public void testConvertHexaToDecimal_validInput() {
        // Arrange
        String hexadecimal = "2B.D2";

        // Act
        String result = cv.convertHexaToDecimal(hexadecimal);

        // Assert
        assertEquals("43.82421875", result);
    }

    @Test
    public void testConvertHexaToDecimal_validInput_notsame() {
        // Arrange
        String hexadecimal = "2B.D2";

        // Act
        String result = cv.convertHexaToDecimal(hexadecimal);

        // Assert
        assertEquals("10.12109375", result);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertHexaToDecimal_invalidInput_nonHexadecimalCharacter() {
        // Arrange
        String hexadecimal = "2K.A5";

        // Act & Assert
        cv.convertHexaToDecimal(hexadecimal);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertHexaToDecimal_invalidInput_emptyString() {
        // Arrange
        String hexadecimal = "";

        // Act & Assert
        cv.convertHexaToDecimal(hexadecimal);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertHexaToDecimal_invalidInput_nullInput() {
        // Arrange
        String hexadecimal = null;

        // Act & Assert
        cv.convertHexaToDecimal(hexadecimal);
    }
    
    
    //decimal-binary
    @Test
    public void testConvertDecimalToBinary_validInput() {
        // Arrange
        String decimal = "43.82421875";

        // Act
        String result = cv.convertDecimalToBinary(decimal);

        // Assert
        assertEquals("101011.11010010", result);
    }

    @Test
    public void testConvertDecimalToBinary_validInput_notSame() {
        // Arrange
        String decimal = "43.82421875";

        // Act
        String result = cv.convertDecimalToBinary(decimal);

        // Assert
        assertEquals("11110", result);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertDecimalToBinary_invalidInput_nonDecimalCharacter() {
        // Arrange
        String decimal = "43.A2";

        // Act & Assert
        cv.convertDecimalToBinary(decimal);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertDecimalToBinary_invalidInput_emptyString() {
        // Arrange
        String decimal = "";

        // Act & Assert
        cv.convertDecimalToBinary(decimal);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertDecimalToBinary_invalidInput_nullInput() {
        // Arrange
        String decimal = null;

        // Act & Assert
        cv.convertDecimalToBinary(decimal);
    }
    
    
    //decimal-hexa
    @Test
    public void testConvertDecimalToHexa_validInput() {
        // Arrange
        String decimal = "43.82421875";

        // Act
        String result = cv.convertDecimalToHexa(decimal);

        // Assert
        assertEquals("2B.D2", result);
    }

    @Test
    public void testConvertDecimalToHexa_validInput_notSame() {
        // Arrange
        String decimal = "43.82421875";

        // Act
        String result = cv.convertDecimalToHexa(decimal);

        // Assert
        assertEquals("1E.0", result);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertDecimalToHexa_invalidInput_nonDecimalCharacter() {
        // Arrange
        String decimal = "43.A2";

        // Act & Assert
        cv.convertDecimalToHexa(decimal);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertDecimalToHexa_invalidInput_emptyString() {
        // Arrange
        String decimal = "";

        // Act & Assert
        cv.convertDecimalToHexa(decimal);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertDecimalToHexa_invalidInput_nullInput() {
        // Arrange
        String decimal = null;

        // Act & Assert
        cv.convertDecimalToHexa(decimal);
    }

    @Test
    public void testConvertwithSplit() {
    }

}
