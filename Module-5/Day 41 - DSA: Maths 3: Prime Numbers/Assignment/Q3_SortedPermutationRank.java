/*
 * Problem Description
Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003


Problem Constraints
1 <= |A| <= 1000


Input Format
First argument is a string A.


Output Format
Return an integer denoting the rank of the given string.


Example Input
Input 1:

A = "acb"
Input 2:

A = "a"


Example Output
Output 1:
2

Output 2:
1


Example Explanation
Explanation 1:

Given A = "acb".
The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
So, the rank of A is 2.
Explanation 2:

Given A = "a".
Rank is clearly 1.

 */
public class Q3_SortedPermutationRank {

   
    public static int fact(int n) {
        int mod = 1000003;
        if(n == 0 || n == 1) {
            return 1;
        }
        return (n * fact(n - 1)) % mod;
    }

    public static int findRank(String A) {
       int mod = 1000003;
        char[] s = A.toCharArray();
        int ans = 0; 
        int n = s.length;
        for(int i = 0 ; i < n ; i++) {
            int count = 0;
            for(int j = i + 1; j < n; j++) {
                if(s[j] < s[i]) {
                    count++;
                }
            }
            ans += (count * fact(n - i - 1)) % mod;
        }
        return (ans + 1) % mod;
    }
    public static void main(String[] args) {
        System.out.println(findRank("acb"));
    }
}
