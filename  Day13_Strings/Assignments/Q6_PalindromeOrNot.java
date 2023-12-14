/*
 * Q6. Palindrome or not
Problem Description:

Write a program to check whether the given string is a palindrome or not. Return True if it is palindrome else return False.

Note: A string is said to be a palindrome if the reverse of the string is the same as the string itself.

Input Format:

First line will have the number of test cases. For each testcase there will be single line of input consisting of a string.
Output Format:

True if palindrome else False
Sample Input 1:

1
level
Sample Output 1:

True
Sample explanation:

'level' when reversed returns 'level' only which are same therefore True is returned.
Sample Input 2:

1
Scaler
Sample Output 2:

False
Sample explanation:

'Scaler' when reversed returns 'relacS' which is not equal to original string therefore False is returned.
 */

public class Q6_PalindromeOrNot {


    //Reverse String Method 1
    // public static String reverseString(String str){
      
    //     int start = 0;
    //     char[] ch = str.toCharArray();
    //     int end = ch.length-1;
    //     while(start<end){
    //         char temp = ch[start];
    //         ch[start] = ch[end];
    //         ch[end] = temp;
    //         start++;
    //         end--;
    //     }
    //     String reverseString  = String.valueOf(ch);
    //     return reverseString;
    // }

    // Reverse String Method 2

    // public static String reverseString(String str){
    //     String reverseString = "";
    //     for(int i =0;i<str.length();i++){
    //         reverseString = str.charAt(i)+  reverseString; 
    //     }
    //     return reverseString;
    // }


    // Reverse String Method 2
    public static String reverseString(String str){
        String reverseString = "";
        for(int i= str.length()-1;i>=0;i--){
            reverseString =  reverseString + str.charAt(i);
        }
        return reverseString;
    }

    public static boolean isPalin(String s) {
        String reverseString = reverseString(s);
        if(s.equals(reverseString)){
            return true;
        }
        return false;
        // complete the function template
    }
    public static void main(String[] args) {
        System.out.println(isPalin("level"));
    }
}
