/*
 * Q3. First Missing Integer
Problem Description
Given an unsorted integer array, A of size N. Find the first missing positive integer.

Note: Your algorithm should run in O(n) time and use constant space.



Problem Constraints
1 <= N <= 1000000

-109 <= A[i] <= 109



Input Format
First argument is an integer array A.



Output Format
Return an integer denoting the first missing positive integer.



Example Input
Input 1:

[1, 2, 0]
Input 2:

[3, 4, -1, 1]
Input 3:

[-8, -7, -6]


Example Output
Output 1:

3
Output 2:

2
Output 3:

1


Example Explanation
Explanation 1:

A = [1, 2, 0]
First positive integer missing from the array is 3.
Explanation 2:

A = [3, 4, -1, 1]
First positive integer missing from the array is 2.
Explanation 3:

A = [-8, -7, -6]
First positive integer missing from the array is 1.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Q3_FirstMissingInteger {

    public static int firstMissingPositive(ArrayList<Integer> A) {

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) <= 0) {
                A.set(i, A.size() + 1);
            }

            int ele = Math.abs(A.get(i));
            int idx = ele - 1;
            if (idx < A.size()) {
                A.set(idx, -1 * Math.abs(A.get(idx)));
            }
        }

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > 0) {
                return i + 1;
            }
        }
        return A.size() + 1;

    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(-8, -7, 1, 4, 3 - 6));
        System.out.println(firstMissingPositive(arrayList));
    }

}
