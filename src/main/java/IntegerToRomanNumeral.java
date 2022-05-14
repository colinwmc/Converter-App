import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class IntegerToRomanNumeral {
    public static void convertToRomanNumeral(){
        Scanner userInput=new Scanner(System.in);

        boolean inputNotAccepted=true;
        String userNumber="";
        int userInt=12;
        while(inputNotAccepted) {
            System.out.print("Please input a decimal integer between 1 and 3999: ");
            userNumber = userInput.nextLine();
            try {
                int testNumber = Integer.parseInt(userNumber);
                userInt = testNumber;
                inputNotAccepted=false;
            } catch (NumberFormatException e) {
                System.out.println(Colors.Red+"\nInput must be a valid number."+Colors.Reset);
            }


            if (userInt < 1 || userInt > 3999) {
                System.out.println(Colors.Red+"\nNumber must be within the specified range."+Colors.Reset);
                inputNotAccepted=true;
            }
        }
        String answer = "";
    while (userInt >= 1000) {
        answer += "M";
        userInt -= 1000;        }
    while (userInt >= 900) {
        answer += "CM";
        userInt -= 900;
    }
    while (userInt >= 500) {
        answer += "D";
        userInt -= 500;
    }
    while (userInt >= 400) {
        answer += "CD";
        userInt -= 400;
    }
    while (userInt >= 100) {
        answer += "C";
        userInt -= 100;
    }
    while (userInt >= 90) {
        answer += "XC";
        userInt -= 90;
    }
    while (userInt >= 50) {
        answer += "L";
        userInt -= 50;
    }
    while (userInt >= 40) {
        answer += "XL";
        userInt -= 40;
    }
    while (userInt >= 10) {
        answer += "X";
        userInt -= 10;
    }
    while (userInt >= 9) {
        answer += "IX";
        userInt -= 9;
    }
    while (userInt >= 5) {
        answer += "V";
        userInt -= 5;
    }
    while (userInt >= 4) {
        answer += "IV";
        userInt -= 4;
    }
    while (userInt >= 1) {
        answer += "I";
        userInt -= 1;
    }
        System.out.println(Colors.Blue+"\n"+userNumber+" in Roman numerals is "+answer+Colors.Reset);
}
    }

