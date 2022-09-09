import java.util.Scanner;

public class Palindrome{
    public static void main(String[] args) {
        try {
            while(true) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Check if it is Palindrome: ");
                String input = sc.nextLine();
                isPalindrome(input);
            }
        }catch(Exception e) {

        }
    }
    public static void isPalindrome(String inputStr) {
        char[] charArr = inputStr.toCharArray();
        int lastCharArr = charArr.length - 1;
        char[] strArray = new char[lastCharArr  + 1];
        int index1 = 0;
        int index2 = 0;

        for (index1 = 0; index1 <= lastCharArr; index1++) {
            if (charArr[index1] >= 'A' && charArr[index1] <= 'Z'|| charArr[index1] >= 'a' && charArr[index1] <= 'z')
                strArray[index2++] =charArr[index1];

        }

        int newLastIndex = index2 - 1;
        int firstIndex = 0;


        while(newLastIndex > firstIndex) {
            if(lowAlphaCheck(strArray[firstIndex++]) != lowAlphaCheck(strArray[newLastIndex--]))
            {
                System.out.println(inputStr+" is Not a palindrome");
                return;
            }
        }
        System.out.println(inputStr+" Is a palindrome");
    }
    public static char lowAlphaCheck(char alphabet) {
        if (alphabet >= 'A' && alphabet <= 'Z') {
            return (char) ((char) alphabet + 32);
        }

        return alphabet;
    }
}
