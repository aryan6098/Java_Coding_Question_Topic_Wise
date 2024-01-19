
/*
 * Q2. Noble Integer
Problem Description
Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.



Problem Constraints
1 <= |A| <= 2*105
-108 <= A[i] <= 108


Input Format
First and only argument is an integer array A.



Output Format
Return 1 if any such integer p is present else, return -1.

Example Input
Input 1:

 A = [3, 2, 1, 3]
Input 2:

 A = [1, 1, 3, 3]


Example Output
Output 1:

 1
Output 2:

 -1


Example Explanation
Explanation 1:

 For integer 2, there are 2 greater elements in the array..
Explanation 2:

 There exist no integer satisfying the required conditions.
 */
import java.util.*;;

public class Q2_NobleInteger {
    public static int solve(int[] A) {
        int ans = -1;
        int less = 0;

        if (A[0] == 0) {
            ans++;
        }
        Arrays.sort(A);
        int flag = -1;
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            j = i;
            for (j = i; j < A.length; j++) {
                if (A[i] != A[j])
                    break;
            }
            if (A[i] == A.length - j) {
                flag = 1;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 3, 3 };
        System.out.println(solve(arr));
    }

}
