/*
 * Q1. Letter Phone
Problem Description

Given a digit string A, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.


The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.

NOTE: Make sure the returned strings are lexicographically sorted.



Problem Constraints

1 <= |A| <= 10



Input Format

The only argument is a digit string A.



Output Format

Return a string array denoting the possible letter combinations.


Example Input

Input 1:

 A = "23"
Input 2:

 A = "012"


Example Output

Output 1:

 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Output 2:

 ["01a", "01b", "01c"]


Example Explanation

Explanation 1:

 There are 9 possible letter combinations.
Explanation 2:

 Only 3 possible letter combinations.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Q1_LetterPhone {


    private static final HashMap<Character, String> digitToChar = new HashMap<>();
    static {
        digitToChar.put('0', "0");
        digitToChar.put('1', "1");
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "pqrs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");
    }
    public static void generateLetterCombination(ArrayList<String> result, String A, String current, int index) {

        if(index == A.length()) {
            result.add(current);
            return;
        }

        char digit = A.charAt(index);
        String letter = digitToChar.get(digit);
        for(int i = 0; i < letter.length(); i++) {
            generateLetterCombination(result, A, current + letter.charAt(i), index + 1);
        }
    }

    public static ArrayList<String> letterCombinations(String A) {
        ArrayList<String> result = new ArrayList<>();
       String current = "";
       generateLetterCombination(result, A, current, 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("10"));
    }
}
