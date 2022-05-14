import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyCoverter {
    public static void run() throws IOException {


        HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();

        //Add currency codes
        currencyCodes.put(1,"USD");
        currencyCodes.put(2,"GBP");
        currencyCodes.put(3,"EUR");
        currencyCodes.put(4,"CZK");
        currencyCodes.put(5,"JPY");

        String fromCode, toCode;
        double amount;

        Scanner scanner=new Scanner(System.in);

        System.out.println(Colors.Yellow+"\n$£¥€Kč$£¥€Kč" +Colors.Blue+" Currency Converter "+Colors.Yellow+ "$£¥€Kč$£¥€Kč\n"+Colors.Reset);

        System.out.println("Currency converting FROM?");
        System.out.println("1: American Dollar (USD) \n2: British Pound (GBP) \n3: Euro (EUR) \n4: Czech Crown (CZK) \n5: Japanese Yen (JPY)");
        System.out.print("Your choice: ");
        fromCode=currencyCodes.get(scanner.nextInt());

        System.out.println("\nCurrency converting TO?");
        System.out.println("1: American Dollar (USD) \n2: British Pound (GBP) \n3: Euro (EUR) \n4: Czech Crown (CZK) \n5: Japanese Yen (JPY)");
        System.out.print("Your choice: ");

        toCode=currencyCodes.get(scanner.nextInt());

        System.out.println("\nAmount you wish to convert?");
        System.out.print("Your input: ");
        amount=scanner.nextFloat();
        System.out.println(Colors.Blue+String.format("%.2f",amount)+" "+fromCode+" is equal to "+sendHttpGETRequest(fromCode,toCode,amount)+" "+toCode+Colors.Reset);

        boolean continueOption = true;
        while (continueOption) {
            Scanner userInput=new Scanner(System.in);
            System.out.println("\n1. Convert another value.");
            System.out.println("2. Return to Main Menu.");
            System.out.print("\nYour selection: ");
            String response = userInput.nextLine();
            if (response.equals("1")) {
                continueOption=false;
                CurrencyCoverter.run();

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
    private static String sendHttpGETRequest(String fromCode, String toCode, double amount) throws IOException {
        String url_str="https://v6.exchangerate-api.com/v6/c06f0f9e2000a95178f9dc5d/pair/"+fromCode + "/"+ toCode+"/"+amount;
        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

// Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

// Accessing object
        String req_result = jsonobj.get("conversion_result").getAsString();
        return req_result;
        }


    }

