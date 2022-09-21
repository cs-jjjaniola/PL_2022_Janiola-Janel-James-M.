import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lexical_Analyzer_Activity3 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("C:\\Users\\ADMIN\\IdeaProjects\\NEW_TPL\\Assignment\\src\\sample");
        Scanner scanner = new Scanner(inputFile);
        String tempString = "";
        while (scanner.hasNextLine()) {
            tempString += scanner.nextLine();
            tempString += "\n";

        }
        char[] charrSpecific = tempString.toCharArray();
        checkLexemes(charrSpecific);
    }

    public static void  checkLexemes(char[] arr) {
       // int j = 0;
        String tempVal = "";
        String[] s = new String[1000];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '"') { //Check if its start in double quote
                i++;
                while (arr[i] != '"') { //Check until the last double quote reach
                    tempVal += arr[i];
                    i++;
                }
                i++;
                System.out.print("<value>"); //
            }
            tempVal = "";
            while (Character.isLetter(arr[i]) || Character.isDigit(arr[i]) || arr[i] == '_') {
                tempVal += arr[i];
                i++;
            }
            int l = tempVal.length();
            if (l != 0)
                if (isKeyword(tempVal))
                    System.out.print("<data_type>");
                else if (isInteger(tempVal))
                    System.out.print("<value>");
                else if (isFloat(tempVal))
                    System.out.print("<value>");
                else
                    System.out.print("<identifier>");

            tempVal = "";
            if (arr[i] == '=') {
                System.out.print("<assignment_operator>");
            } else if (arr[i] == '*') {
                System.out.print("<assignment_operator>");
            } else if (arr[i] == '+') {
                System.out.print("<assignment_operator>");
            } else if (arr[i] == '-') {
                System.out.print("<assignment_operator>");
            } else if (arr[i] == '.') {
                System.out.print("<assignment_operator>");
            } else if (arr[i] == '(') {
                System.out.print("<delimiter>");
            } else if (arr[i] == '{') {
                System.out.print("<delimiter>");
            } else if (arr[i] == '}') {
                System.out.print("<delimiter>");
            } else if (arr[i] == ')') {
                System.out.print("<delimiter>");
            } else if (arr[i] == ';') {
                System.out.print("<delimiter>");
            } else if (arr[i] == ',') {
                System.out.print(",<delimiter>");
            }

        }
    }

    public static boolean isKeyword(String kywrd) {
        String keywords[] = { "int", "double", "char", "String" };
        for (int i = 0; i < keywords.length; i++){
            if (kywrd.equals(keywords[i])){
                return true;
            }
        }
        return false;
    }

    public static boolean isInteger(String a) {
        try {
            int i = Integer.parseInt(a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFloat(String a) {
        try {
            float i = Float.parseFloat(a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
