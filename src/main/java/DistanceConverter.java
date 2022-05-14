import java.io.IOException;
import java.util.Scanner;

public class DistanceConverter {
    public static void convertDistance() throws IOException {
        System.out.println(Colors.Yellow+"\n**************"+Colors.Blue+" Distance Converter "+Colors.Yellow+"**************\n"+Colors.Reset);
        Scanner userInput=new Scanner(System.in);
        boolean startNotAccepted=true;
        String start="";
        while(startNotAccepted){
            System.out.println("Are you converting from [K]ilometers or [M]iles? ");
            System.out.print("Your selection: ");
            start=userInput.nextLine();

            if(start.toUpperCase().equals("K")||start.toUpperCase().equals("M")){
                startNotAccepted=false;
            }
            else {
                System.out.println(Colors.Red+"\nPlease input either K or M"+Colors.Reset);
            }
        }
        boolean numberNotValid=true;
        double distance=0;
        String  original="";
        while(numberNotValid) {
            System.out.print("\nPlease input the distance: ");
            original = userInput.nextLine();
            try {
                double testDistance = Double.parseDouble(original);
                distance = testDistance;
                numberNotValid=false;
            } catch (NumberFormatException e) {
                System.out.println(Colors.Red+"\nInput must be a valid number."+Colors.Reset);
            }
        }
        if(start.toUpperCase().equals("K")){
            System.out.println(Colors.Blue+"\n"+distance+"m is equal to "+String.format("%.2f", (distance*0.6214))+"km."+Colors.Reset);
        }
        if(start.toUpperCase().equals("M")){
            System.out.println(Colors.Blue+"\n"+distance+"m is equal to "+String.format("%.2f", (distance/0.6214))+"km."+Colors.Reset);
        }
        boolean continueOption = true;
        while (continueOption) {
            System.out.println("\n1. Convert another value.");
            System.out.println("2. Return to Main Menu.");
            System.out.print("\nYour selection: ");
            String response = userInput.nextLine();
            if (response.equals("1")) {
                continueOption=false;
                DistanceConverter.convertDistance();

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
