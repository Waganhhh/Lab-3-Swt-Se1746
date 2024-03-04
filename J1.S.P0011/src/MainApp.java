
import common.Validate;
import controller.Convert;

/**
 *
 * @author Quang Anh
 *
 * The program that allows users choose the input base system (2, 10, 16) and
 * the output base system (2,10,16) then enter input value, the program will
 * print the equivalent output value The program should be repetitive until
 * users close the program
 *
 */
public class MainApp {

    /**
     * The main method of the program.
     *
     * @param args
     *
     */
    public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            int choice = Convert.menu();
            switch (choice) {
                case 1://Convert from binary to others
                    String binary = Validate.checkInputBinary();
                    Convert.convertfromBinary(binary);
                    break;
                case 2://Convert from decimal to others
                    String decimal = Validate.checkInputDecimal();
                    Convert.convertfromDecimal(decimal);
                    break;
                case 3://Convert from hexadecimal to others
                    String hexa = Validate.checkInputHexa();
                    Convert.convertfromHexa(hexa);
                    break;
                case 4://Exit program
                    return;
            }
        }
    }
}
