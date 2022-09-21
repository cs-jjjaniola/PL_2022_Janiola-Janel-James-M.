import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexical_Analyzer {
    public static void main(String[] args) {

    String dataType[] = {"char","int","double","String"};
    String assOperator[] = {"="};
    String delimeter[] = {";"};
    Pattern value = Pattern.compile("[_a-zA-Z][_a-zA-Z0-9]*");
    Pattern identifier = Pattern.compile("[0-9]");


        int count = 1 ;
        Scanner s = new Scanner(System.in) ;
        System.out.println(" enter input : " ) ;
        String line = " " ;
        int ct = 1 ;

        while(s.hasNext()) {
           line +=s.nextLine()+"\n";
             if(line.contains("end")){
                 break;
             }
        }
        System.out.println ( "                 ");
        String[] tksep =line.split( " ") ;
       // System.out.println(tksep[3]);
        for(int i = 0 ;i < tksep.length-1 ;i++ ) {
            System.out.println(tksep[i]);
        }

        System.out.println ( "                  ");
        for (int i = 0; i < tksep.length-1 ;i++ ) {
            int flag = 0 ;
            //System.out.println(tksep[i]);
            for ( int j = 0 ; j < dataType.length ; j ++ ) {
                if (tksep[i].equals(dataType[j])) {
                    System.out.println( tksep[i] + "< Keyword >");
                    count++;
                    flag = 1;

                }
            }
             if (flag!=1){
                 for(int j=0;j< assOperator.length;j++){
                     if(tksep[i].equals(assOperator[j])){
                         System.out.println(tksep[i]+ "< Assignment Operator>");
                         count++;
                         flag=1;

                     }
                 }

            }
            if (flag!=1){
                for(int j=0;j < delimeter.length;j++){
                    if(tksep[i].equals(delimeter[j])){
                        System.out.println(tksep[i]+ "< Delimeter>");
                        count++;
                        flag=1;

                    }
                }

            }
            if (flag!=1){
                Matcher match = value.matcher(tksep[i]);
                if(match.matches()){
                    System.out.println(tksep[i]+"< value >");
                    flag = 1;
                    count++;
                }

            }
            if (flag!=1){
                Matcher match = identifier.matcher(tksep[i]);
                if(match.matches()){
                    System.out.println(tksep[i]+"< identifier >");
                    count++;
                }

            }
        }
        System.out.println("Total no. of token:" +count);
    }
}
