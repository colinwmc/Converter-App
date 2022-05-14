import java.util.Scanner;

public class RomanNumeralToInteger {
    public static void convertRomanToDecimal() {

        boolean inputNotAccepted=true;
        String roman="";

        while(inputNotAccepted) {
            Scanner userInput = new Scanner(System.in);
            System.out.print("Please input a Roman Numeral:");
            roman = userInput.nextLine().toUpperCase();
            char[]testing = roman.toCharArray();
            boolean notOk=false;
            for (char chr : testing) {
                if (chr!='I'&& chr!='V'&& chr!='X'&& chr!='L'&&chr!='C'&&chr!='D'&&chr!='M'){

                    notOk=true;
                }
            }
            inputNotAccepted=notOk;
            if(notOk){
                System.out.println(Colors.Red+"\nInput was not a valid Roman Numeral."+Colors.Reset);
            }
        }
        char[]romanArray=roman.toCharArray();
        int answer = 0;

        for (int i = 0; i < romanArray.length; i++) {

            int s1 = value(romanArray[i]);

            if (i + 1 < romanArray.length) {

                int s2 = value(romanArray[i + 1]);

                if (s1 >= s2) {
                    answer = answer + s1;
                } else {
                    answer = answer + s2 - s1;
                    i++;
                }
            } else {
                answer = answer + s1;
            }


        }
        System.out.println(Colors.Blue+"\n"+roman +" is equal to "+answer+Colors.Reset);


    }
    private static int value ( char numeral){
        if (numeral == 'I')
            return 1;
        if (numeral == 'V')
            return 5;
        if (numeral == 'X')
            return 10;
        if (numeral == 'L')
            return 50;
        if (numeral == 'C')
            return 100;
        if (numeral == 'D')
            return 500;
        if (numeral == 'M')
            return 1000;

        return -1;
    }
}
