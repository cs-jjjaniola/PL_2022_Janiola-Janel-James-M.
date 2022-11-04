import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eli{

    public static void main(String[] args){

        //String input = new Scanner(System.in).nextLine();
        String input = "double number=2;";

        String inChar="";
        boolean strChk=false;

        List<String> lexeme = new ArrayList<String>();

        for(int i=0; i<input.length(); i++){

            inChar+=input.charAt(i);

            if(isApostrophe(input.charAt(i))) {
                strChk = toggleBool(strChk);
            }

            if(strChk!=true) {

                if(input.charAt(i)=='=' || input.charAt(i)==';') {
                    lexeme.add(inChar.substring(0, inChar.length() - 1));
                    lexeme.add("" + input.charAt(i));
                    inChar="";
                }

                else if(input.charAt(i)==' ') {
                    lexeme.add(inChar.replaceAll("\\s+$", ""));
                    inChar="";
                }

            }
        }
        lexeme.add(inChar.replaceAll("\\s+$", ""));
        lexeme.removeAll(Arrays.asList("", null));
        System.out.println(lexeme);


        for(String lex : lexeme) {

            if(isDataType(lex)) {
                System.out.print("<data_type>");
            }
            else if(isAssnOperator(lex)) {
                System.out.print("<assignment_operator>");
            }
            else if(isValue(lex)) {
                System.out.print("<value>");
            }
            else if(isIdentifier(lex)) {
                System.out.print("<identifier>");
            }
            else if(lex.matches(";")) {
                System.out.print("<delimiter>");
            }
        }
    }

    public static boolean toggleBool(boolean b) {
        if(b==true) return false;
        else return true;
    }

    private static boolean isApostrophe(char c) {

        if(c=='“' || c=='”' || c=='\"' || c=='\'') {
            return true;
        }
        return false;
    }
    private static boolean isValue(String s) {
        if(s.contains("“") || s.contains("”") || s.contains("\"") || s.contains("\'") || s.matches("[0-9]*\\.?[0-9]*")) {
            return true;
        }
        return false;
    }
    private static boolean isIdentifier(String s) {

        if(s.matches("^[a-zA-Z0-9_.-]*$") && (!s.contains("\"") || !s.contains("\'") || !s.matches("[0-9]*\\.?[0-9]*")))
            return true;
        return false;
    }

    public static boolean isDataType(String s){

        String[] dataType = {"int","double","char","String"};

        for(String dType : dataType){
            if(s.contentEquals(dType))
                return true;
        }
        return false;
    }

    public static boolean isAssnOperator(String s) {

        if(s.matches("=")) {
            return true;
        }

        return false;
    }

    public static boolean isOperator(char c) {

        char[] operator = {'+','=','-','/','*','%'};

        for(char op : operator) {
            if(c==op) {
                return true;
            }
        }
        return false;
    }


}