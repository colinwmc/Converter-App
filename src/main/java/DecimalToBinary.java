import java.util.Scanner;

public class DecimalToBinary {
    public static void convertToBinary() {
        Scanner userInput = new Scanner(System.in);


        boolean numberNotValid=true;
        int inputAsInt=0;
        String  original="";
        while(numberNotValid) {
            System.out.print("Please input the Decimal Integer: ");
            original = userInput.nextLine();
            try {
                int testInt = Integer.parseInt(original);
                inputAsInt = testInt;
                numberNotValid=false;
            } catch (NumberFormatException e) {
                System.out.println(Colors.Red+"\nInput must be a valid number."+Colors.Reset);
            }
        }
            String binaryAnswer = "";
            while ((inputAsInt) > 0) {
                int remainder = inputAsInt % 2;
                String binaryDigit = String.valueOf(remainder);
                binaryAnswer = binaryDigit + binaryAnswer;
                inputAsInt = inputAsInt / 2;
            }
            if (original.equals("0")) {
                System.out.println("0 in binary is 0");
            } else if (!original.equals("0")) {
                String answerStatement = original + " in binary is " + binaryAnswer;
                System.out.println(Colors.Blue+"\n"+answerStatement+Colors.Reset);
            }
        }
    }

