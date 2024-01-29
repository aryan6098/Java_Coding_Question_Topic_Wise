/*
 * Q6. Isalnum()
Problem Description
You are given a function isalpha() consisting of a character array A.

Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.



Problem Constraints
1 <= |A| <= 105



Input Format
Only argument is a character array A.



Output Format
Return 1 if all the characters of the character array are alphanumeric (a-z, A-Z and 0-9), else return 0.



Example Input
Input 1:

 A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']
Input 2:

 A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 All the characters are alphanumeric.
Explanation 2:

 All the characters are NOT alphabets i.e ('#').

 */

public class Q6_Isalnum {

    public static int solve(char[] A){
        int count = 0;
        char val = ' ';
        for(int i = 0; i < A.length; i++){
            char ch = A[i];
            if((ch >= 'A' && ch <='Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                count = 1;
            }
            else {
                count = 0;
                break;
            }
        }
        return count;
}
    public static void main(String[] args) {
        char[] A = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'};
        // solve(A);
        System.out.println(solve(A));
    }
}
