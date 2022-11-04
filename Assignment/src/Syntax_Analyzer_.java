import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Syntax_Analyzer_ {
    public static void main(String[] args) {
        System.out.println("Input Series of Tokens: ");
        Scanner sc = new Scanner(System.in);
        String Tokens = sc.nextLine();
        try{
                String line = " ";
                //parsing a CSV file that contains possible correct Syntax into BufferedReader class constructor
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\IdeaProjects\\NEW_TPL\\Assignment\\src\\CSVDemo.csv"));
                while ((line = br.readLine()) != null)
                {
                    if (line.contains(Tokens)) {
                        System.out.println("Syntax is Correct! ");
                    }else{
                        System.out.println("Syntax is Error! ");
                    }
                }
            }catch (Exception e){
        }
    }
}
