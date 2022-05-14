import java.io.IOException;
import java.util.Scanner;

public class RomanNumeral {
    public static void convertRoman() throws IOException {
        System.out.println(Colors.Yellow+"\nIVXCDMDCXVI" +Colors.Blue+" Roman Numeral Converter "+Colors.Yellow+ "IVXCDMDCXVI\n"+Colors.Reset);
        Scanner userInput=new Scanner(System.in);
        boolean startNotAccepted=true;
        String start="";
        while(startNotAccepted){
            System.out.println("Input R to convert a Roman Numeral to a Decimal Integer.");
            System.out.println("Input D to convert a Decimal Integer to a Roman Numeral.");
            System.out.print("\nYour selection: ");
            start=userInput.nextLine().toUpperCase();

            if(start.equals("R")||start.equals("D")){
                startNotAccepted=false;
            }
            else {
                System.out.println(Colors.Red+"\nPlease input either R or D"+Colors.Reset);
            }
        }
        if(start.equals("R")){
            RomanNumeralToInteger.convertRomanToDecimal();
        }
        if(start.equals("D")){
            IntegerToRomanNumeral.convertToRomanNumeral();
        }
        boolean continueOption = true;
        while (continueOption) {
            System.out.println("\n1. Convert another value.");
            System.out.println("2. Return to Main Menu.");
            System.out.print("\nYour selection: ");
            String response = userInput.nextLine();
            if (response.equals("1")) {
                continueOption=false;
                RomanNumeral.convertRoman();

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
