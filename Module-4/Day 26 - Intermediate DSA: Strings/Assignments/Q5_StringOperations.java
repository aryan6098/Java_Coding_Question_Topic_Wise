/*
 * Q5. String operations

 */

 import java.util.*;
public class Q5_StringOperations {
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    public static String solve(String A) {
        String concatString = A + A;
        StringBuilder deletedUpperCaseString = new StringBuilder();
        for(int i = 0 ; i < concatString.length();i++) {
            char ch = concatString.charAt(i);
            if (!(ch >= 'A' && ch <= 'Z')) {
               deletedUpperCaseString.append(ch);
            }
        }
        char[] resultArray = new char[deletedUpperCaseString.length()];
        for (int i = 0; i < deletedUpperCaseString.length(); i++) {
            char ch = deletedUpperCaseString.charAt(i);
            if (isVowel(ch)) {
                resultArray[i] = '#';
            }
            else {
                resultArray[i] = ch;
            }
        }
        
       return String.valueOf(resultArray);
    }
    public static void main(String[] args) {
        String str = "aeiOUz";
        System.out.println(solve(str));
    }
}
