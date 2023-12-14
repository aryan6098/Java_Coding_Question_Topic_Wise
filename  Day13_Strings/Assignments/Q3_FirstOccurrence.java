/*
 * Q3. First Occurrence
Problem Description

You are given a character string A, having length N and an integer ASCII code B.

You have to tell the leftmost occurrence of the character having ASCII code equal to B, in A or report that it does not exist.

Problem Constraints

1 <= N <= 105

A[i] ∈ ['a'-'z']

97 <= B <= 122


Input Format

First argument is a character string A.

Second argument is an integer B.

Output Format

If there exists an occurrence, return the leftmost index(0 - based), else return -1.

Example Input

Input 1:

 A = "aabbcc"
 B = 98 
Input 2:

 A = "abc"
 B = 100


Example Output

Output 1:

 2 
Output 2:

 -1 

Example Explanation

Explanation 1:

 Character having ASCII code equal to 98 = 'b' 
 Leftmost index of character 'b' in "aabbcc" is 2.
Explanation 2:

 Character having ASCII code equal to 100 = 'd'
 Character 'd' is not present in "abc".

 */

public class Q3_FirstOccurrence {

    public static int solve(final String A, final int B) {

        int count = -1 ;
        for(int i=0;i<A.length();i++){
           if(A.charAt(i) == B){
            count = i;
            break;
           }
            
        }
        return count;
    }
    public static void main(String[] args) {
        String str = "bvymzikytswvgniflzbyyrkcojuxedcviygnxuckqxmiqtzsqvrvppsnmaoghsxoierzuuecjlxwievsxcesfqsaeg";
        System.out.println(solve(str, 99));
        
    }
}
