import java.io.IOException;
import java.util.Scanner;

public class BinaryMenu {
    public static void convertBinary() throws IOException {
        System.out.println(Colors.Yellow+"\n10101010101010101"+Colors.Blue+" Binary Converter "+Colors.Yellow+"01010101010101010\n"+Colors.Reset);
        Scanner userInput = new Scanner(System.in);
        boolean startNotAccepted = true;
        String start = "";
        while (startNotAccepted) {
            System.out.println("Input B to convert a Binary Number to a Decimal Integer.");
            System.out.println("Input D to convert a Decimal Integer to a Binary Number.");
            System.out.print("\nYour selection: ");
            start = userInput.nextLine().toUpperCase();

            if (start.equals("B") || start.equals("D")) {
                startNotAccepted = false;
            } else {
                System.out.println(Colors.Red+"\nPlease input either B or D"+Colors.Reset);
            }
        }
        if (start.equals("B")) {
            BinaryToDecimal.convertBinaryToDecimal();
        }
        if (start.equals("D")) {
            DecimalToBinary.convertToBinary();
        }
        boolean continueOption = true;
        while (continueOption) {
            System.out.println("\n1. Convert another value.");
            System.out.println("2. Return to Main Menu.");
            System.out.print("\nYour selection: ");
            String response = userInput.nextLine();
            if (response.equals("1")) {
                continueOption=false;
                BinaryMenu.convertBinary();

            }
            if (response.equals("2")) {
                continueOption=false;
                MainMenu.run();
            }
            else{
                System.out.println(Colors.Red+"\nI'm sorry, I didn't understand that. Please choose from the list below."+Colors.Reset);
            }
        }
    }
}
