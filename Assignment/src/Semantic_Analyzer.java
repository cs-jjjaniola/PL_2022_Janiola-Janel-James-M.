import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Semantic_Analyzer {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("C:\\Users\\ADMIN\\IdeaProjects\\NEW_TPL\\Assignment\\src\\WhenInputString");
        Scanner scanner = new Scanner(inputFile);
        String tempString = "";
        while (scanner.hasNextLine()) {
            tempString += scanner.nextLine();
            tempString += "\n";
        }
            // This will use the file WhenInputString.txt when we try to check if the value is String or not
            String sample_String = tempString;
            String firstWordString = checkFirstWord(sample_String);
            String lastWordString = checkLastWord(sample_String);

            //-----------------------------------------------------------------------------------------------//

            //This will use in the another data type like int, double, char, boolean to check the value
            String sample = "double x = true;";
            String firstWord = checkFirstWord(sample);
            String lastWord = checkLastWord(sample);


            if(firstWordString.contains("String")){
                System.out.print(sample_String);
                System.out.println(checkIfString(lastWordString));
            }


            if (firstWord.contains("int")) {
                System.out.println(sample);
                System.out.println(checkIfInteger(lastWord));
                
            } else if (firstWord.contains("double")) {
                System.out.println(sample);
                System.out.println(checkIfDouble(lastWord));

            } else if (firstWord.contains("char")) {
                System.out.println(sample);
                System.out.println(checkIfCharacter(lastWord));

            } else if (firstWord.contains("boolean")) {
                System.out.println(sample);
                System.out.println(checkIfBoolean(lastWord));

            } else {
                System.out.println(sample);
                System.out.println("Input Error");
            }
    }

    public static String checkFirstWord(String input){
        String firstWord = input;
        if(firstWord.contains(" ")){
            firstWord= firstWord.substring(0, firstWord.indexOf(" "));
        }
        return firstWord;
    }

    public static String checkLastWord(String input){
        String test =  input;
        String lastWord = test.substring(test.lastIndexOf(" ")+1);
        String strNew = lastWord.replace(";", ""); //im just removing the terminator

        return strNew;
    }

    public static String checkIfString(String input){
        String tempVal = "";
        String[] s = new String[1000];

        char[] arr = input.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '"') { //Check if its start in double quote
                i++;
                while (arr[i] != '"') { //Check until the last double quote reach
                    tempVal += arr[i];
                    i++;
                }
                System.out.println("Semantically Correct!");
                break;
            }else{
                System.out.println("Semantically Incorrect!");
                break;
            }
        }

        return " ";
    }

    public static String checkIfCharacter(String input){
        //boolean
        char c = input.charAt(1);
        try{
            String output = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
                    ?  "Semantically Correct!"
                    :  "Semantically Incorrect!";
            return output;

        }catch(NumberFormatException e){

        }
        return " ";

    }

    public static String checkIfInteger(String input){

        try{
            Integer.parseInt(input);
            System.out.println("Semantically Correct!");
        }catch(NumberFormatException e){
            //not int
            System.out.println("Semantically Incorrect!");
        }
        return " ";

    }

    public static String checkIfDouble(String input){
        //boolean
        String decimalPattern = "([0-9]*)\\.([0-9]*)";
        String number= input;
        try{
            boolean match = Pattern.matches(decimalPattern, number);
            //System.out.println(match); //if true then decimal else not

            if(match == true){
                System.out.println("Semantically Correct!");

            }else
                System.out.println("Semantically Incorrect!");

        }catch(NumberFormatException e){

        }

        return " ";

    }

    public static String checkIfBoolean(String input){

        try{
            if(input.contentEquals("true") || input.contentEquals("false") || input.contentEquals("TRUE") || input.contentEquals("FALSE")){
                System.out.println("Semantically Correct!");
            }
            else{
                System.out.println("Semantically Incorrect!");
            }

        }catch(NumberFormatException e){

        }
        return " ";

    }
}
