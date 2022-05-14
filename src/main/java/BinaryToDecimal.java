import java.util.Scanner;

public class BinaryToDecimal {
    public static void convertBinaryToDecimal(){
        boolean inputNotAccepted=true;
        String binary="";
        while(inputNotAccepted) {
            Scanner userInput = new Scanner(System.in);
            System.out.print("Please enter binary number: ");
            binary = userInput.nextLine();
            char[] testing = binary.toCharArray();
            boolean notOk = false;
            for (char bi : testing) {
                if (bi != '1' && bi != '0') {
                    notOk = true;
                }
            }
            inputNotAccepted = notOk;
            if (notOk) {
                System.out.println(Colors.Red+"\nInput was not a valid Binary Number."+Colors.Reset);
            }
        }
       int output=0;
       int addition=1;
       for(int i=binary.length()-1;i>=0;i--){
           if(binary.charAt(i)=='1'){
               output+=addition;
           }
           addition*=2;
       }
        System.out.println(Colors.Blue+"\n"+binary+" in decimal is "+output+Colors.Reset);
    }
}
