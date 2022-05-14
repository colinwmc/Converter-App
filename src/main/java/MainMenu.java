import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    public static void run() throws IOException {
        System.out.println("\nWhat would you like to convert?\n");
        boolean keepRunning=true;
        while(keepRunning){
            System.out.println("1. Binary Numbers-Decimal Integers");
            System.out.println("2. Roman Numerals-Decimal Integers");
            System.out.println("3. Miles-Kilometers");
            System.out.println("4. Fahrenheit-Celsius");
            System.out.println("5. Currency");
            System.out.println("6. Exit");
            System.out.print("\nPlease input the number of your selection:");
            Scanner userInput=new Scanner(System.in);
            String choice=userInput.nextLine();

                if(choice.equals("1")) {
                BinaryMenu.convertBinary();
            }
                else if(choice.equals("2")) {
                RomanNumeral.convertRoman();
            }
                else if(choice.equals("3")) {
                DistanceConverter.convertDistance();
            }
                else if(choice.equals("4")) {
                Temperature.convertTemp();
            }
                else if(choice.equals("5")){
                    CurrencyCoverter.run();
                }
                else if(choice.equals("6")) {
                keepRunning = false;
            }
                else{
                System.out.println(Colors.Red+"\nI'm sorry, I didn't understand that. Please input a number from the list below"+Colors.Reset);
            }
            }
        System.out.println(Colors.Blue+"Thank you. Goodbye.");
        System.exit(0);
        }
    }

