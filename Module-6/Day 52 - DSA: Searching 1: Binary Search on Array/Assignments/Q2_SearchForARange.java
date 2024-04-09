/*
 * Q2. Search for a Range
Problem Description
Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.

Return an array of size 2, such that 
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].

Note : Your algorithm's runtime complexity must be in the order of O(log n).


Problem Constraints
1 <= N <= 106
1 <= A[i], B <= 109


Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].

Example Input
Input 1:

 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:

 A = [5, 17, 100, 111]
 B = 3


Example Output
Output 1:

 [3, 4]
Output 2:

 [-1, -1]


Example Explanation
Explanation 1:

 The first occurrence of 8 in A is at index 3.
 The last occurrence of 8 in A is at index 4.
 ans = [3, 4]
Explanation 2:

 There is no occurrence of 3 in the array.
 */

public class Q2_SearchForARange {

    public static int findLeftIndex(int[] A, int B) {
        int l = 0; 
        int r = A.length - 1;
        while(l <= r) {
            int mid= l + (r - l)/2;
            if((mid == 0 || A[mid - 1] < B) && A[mid] == B) {
                return mid;
            }
            if(A[mid] < B) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    }
    public static int findRightIndex(int[] A, int B) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if((mid == A.length - 1 || A[mid + 1] > A[mid]) && A[mid] == B) {
                return mid;
            }
            if(A[mid] > B) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
         }
         return -1;
    }
    public static int[] searchRange(final int[] A, int B) {

      
       int[] result = new int[2];
       result[0] = findLeftIndex(A, B);
       result[1] = findRightIndex(A, B);

       return result;
    }

    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 8, 10};
        int b = 8;
        // int result[] = new int[2];
        int result[]  = searchRange(A, b);
        System.out.println(result[0] +" "+ result[1]);


    }
}
