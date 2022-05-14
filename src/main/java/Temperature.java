import java.io.IOException;
import java.util.Scanner;

public class Temperature {
    public static void convertTemp() throws IOException {
        System.out.println(Colors.Yellow+"**************"+Colors.Blue+" Temperature Converter "+Colors.Yellow+"**************\n"+Colors.Reset);
        Scanner userInput=new Scanner(System.in);
        boolean startNotAccepted=true;
        String startingType="";
        while(startNotAccepted){
        System.out.println("Are you converting from [C]elsius or [F]ahrenheit? ");
            System.out.print("Your selection: ");
        String start=userInput.nextLine();

        if(start.equals("C") || start.equals("c") || start.equals("F") || start.equals("f")){
            startNotAccepted=false;
        }
        else{
            System.out.println(Colors.Red+"\nPlease input either C or F"+Colors.Reset);
        }
            startingType=start;
        }
        boolean tempNotValid=true;
        double temp=0;
        String  original="";
        while(tempNotValid) {
            System.out.print("\nPlease input the temperature: ");
            original = userInput.nextLine();
            try {
                double testTemp = Double.parseDouble(original);
                temp = testTemp;
                tempNotValid=false;
            } catch (NumberFormatException e) {
                System.out.println(Colors.Red+"\nPlease input a valid number."+Colors.Reset);
            }
        }

        if(startingType.toUpperCase().equals("C")){
            double convertedToF=(temp*1.8)+32;
            System.out.println(Colors.Blue+"\n"+original+" degrees Celsius is "+String.format("%.2f",convertedToF)+" degrees Fahrenheit."+Colors.Reset);
        }
        if(startingType.toUpperCase().equals("F")){
            double convertedToC=((temp-32)*0.56);
            System.out.println(Colors.Blue+"\n"+original+" degrees Fahrenheit is "+String.format("%.2f",convertedToC)+" degrees Celsius"+Colors.Reset);
        }
        boolean continueOption = true;
        while (continueOption) {
            System.out.println("\n1. Convert another value.");
            System.out.println("2. Return to Main Menu.");
            System.out.print("\nYour selection: ");
            String response = userInput.nextLine();
            if (response.equals("1")) {
                continueOption=false;
                Temperature.convertTemp();

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
