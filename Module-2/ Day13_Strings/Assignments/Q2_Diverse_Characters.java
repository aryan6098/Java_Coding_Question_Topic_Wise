/*
 * 
Problem Description

You are given a character string A having length N.

The string consists of 2 types of characters:

Alphabets : ['a'-'z', 'A'-'Z']
Digits: ['0'-'9']
You have to tell the count of characters of the maximum occuring character type.


Problem Constraints

1 <= N <= 105

Input Format

First and only argument is a character string A.

Output Format

Return an integer.

Example Input

Input 1:

 A = "HelloUser1"
Input 2:

 A = "M1234"


Example Output

Output 1:

 9 
Output 2:

 4 


Example Explanation

Explanation 1:

 Count of alphabets = 9(max)
 Count of digits = 1
Explanation 2:

 Count of alphabets = 1
 Count of digits = 4(max)


 */

public class Q2_Diverse_Characters {

    public static int solve(final String A) {
        int charCount =0;
        int digitCount = 0;
        for(int i=0;i<A.length();i++){
            char ch = A.charAt(i);
            if(ch>=65 && ch<=90 || ch>=97 && ch<=122){
            charCount++;
           }
           if(ch>=48 && ch<=57){
            digitCount++;
           }
        }
        if(charCount>digitCount){
            return charCount;
        }
        else {
            return digitCount;
        }

    }


    public static void main(String[] args) {
        String str = "HelloUser1";
        System.out.println(solve(str));
    }
}
