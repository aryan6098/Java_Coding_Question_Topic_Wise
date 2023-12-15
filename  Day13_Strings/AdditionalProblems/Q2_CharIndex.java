/*
 * Q2. Char Index
 * 
Problem Description
Shivam has a string A of size N containing only lowercase characters. He will update the string by inserting a number after every char which will be the index of that char.

For E.g.: if string is azd then it will be updated as a1z26d4 since index of a is 1, of z is 26 and of d is 4.

You have to tell how the string will look like afterwards,

Problem Constraints
1 <= A.size() <= 1000

a <= A[i] <= z

Input Format
First argument is string A.

Output Format
You have to return an string as per the question.

Example Input
Input 1:

scaler

Example Output
Output 1:

s19c3a1l12e5r18


Example Explanation
Explanation 1:

Clearly after putting all the chars index in "scaler" it will become "s19c3a1l12e5r18".
 */

public class Q2_CharIndex {

    public static String solve(String A) {
        String str = "";
        for(int i= 0;i<A.length();i++){
            str = str+A.charAt(i);
            if(A.charAt(i)>=97 && A.charAt(i)<=122){
               str=str+(int)(A.charAt(i)-96);
            }

        }
        return str;

    }
    public static void main(String[] args) {
        System.out.println(solve("scaler"));
    }
    
}
