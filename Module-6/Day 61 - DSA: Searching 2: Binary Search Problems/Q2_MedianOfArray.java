/*
 * Q2. Median of Array
Problem Description
There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:

The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.


Problem Constraints
1 <= N + M <= 2*106


Input Format
The first argument is an integer array A of size N.
The second argument is an integer array B of size M.


Output Format
Return a decimal value denoting the median of two sorted arrays.


Example Input
Input 1:

 A = [1, 4, 5]
 B = [2, 3]
Input 2:

 A = [1, 2, 3]
 B = [4]


Example Output
Output 1:

 3.0
Output 2:

 2.5


Example Explanation
Explanation 1:

 The median of both the sorted arrays will be 3.0.
Explanation 2:

 The median of both the sorted arrays will be (2+3)/2 = 2.5.
 */

import java.util.List;

public class Q2_MedianOfArray {
    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        int m = a.size();
        int n = b.size();

        if (m > n) {
            return findMedianSortedArrays(b, a);
        }

        int low = 0;
        int high = m;
        while (low <= high) {
            int partitionA = (low + high) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : a.get(partitionA - 1);
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : a.get(partitionA);

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : b.get(partitionB - 1);
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : b.get(partitionB);

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = partitionA - 1;
            } else {
                low = partitionA + 1;
            }
        }

    }

    public static void main(String[] args) {
        int[] A = {1, 4, 5};
        int[] B = {2, 3};
    System.out.println(findMedianSortedArrays(A, B));
   }
}
