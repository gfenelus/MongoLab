package prog;

import java.io.*;

public class CIO {
    public static String promptForString(String prompt){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isInvalid=true;
        String input = null;
        do {
            System.out.print(prompt);
            try{
                input = br.readLine();

            }catch (IOException ioe){
                System.out.println("There was an unexpected error, please try again.");
            }
            if(input == null ||input.trim().isEmpty()){
                System.out.println("Please enter a valid input");
                isInvalid=true;
            }
            else{
                isInvalid = false;
            }
        }while(isInvalid);


        return input;


    }
    public static int  promptForInt(String prompt, int min, int max) {
        int userNum = -1;
        boolean isInvalid = false;

        do {
            String input = promptForString(prompt);
            try {
                userNum = Integer.parseInt(input);
            } catch (NumberFormatException nfe) {

            }
            isInvalid = userNum < min || userNum > max;

            if (isInvalid) {
                System.out.println("Your input, \"" + input + "\" is invalid. Please enter a number between " + min + " and " + max + ".");
            }
        } while (isInvalid);

        return userNum;
    }
    public static void printString(String string){
        System.out.println(string);
    }
    public static void writeFile(String input, String fileName, boolean append){
        String writeInput = input;

        PrintStream textFile = null;
        try {
            textFile = new PrintStream(new FileOutputStream(fileName,append));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        textFile.append(writeInput);
    }
    public static String readFile(String fileName){
        String outputFile=null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //display modified string

        try {
            outputFile = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputFile;
    }
}
