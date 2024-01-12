/*
 * Q3. Range Sum Query

Problem Description
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.


Problem Constraints
1 <= N, M <= 105
1 <= A[i] <= 109
0 <= L <= R < N


Input Format
The first argument is the integer array A.
The second argument is the 2D integer array B.


Output Format
Return an integer array of length M where ith element is the answer for ith query in B.


Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = [[0, 3], [1, 2]]
Input 2:

A = [2, 2, 2]
B = [[0, 0], [1, 2]]


Example Output
Output 1:
[10, 5]
Output 2:
[2, 4]


Example Explanation
Explanation 1:
The sum of all elements of A[0 ... 3] = 1 + 2 + 3 + 4 = 10.
The sum of all elements of A[1 ... 2] = 2 + 3 = 5.
Explanation 2:

The sum of all elements of A[0 ... 0] = 2 = 2.
The sum of all elements of A[1 ... 2] = 2 + 2 = 4.

 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q3_RangeSumQuery {


    // Solution 1 Using Array Concept
    public static int[] prefixSum(int[] A, int[][] B){
        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];
        for(int i = 1;i < A.length ;i++){ 
            prefixSum[i] = prefixSum[i-1] + A[i];
        }
        int[] result = new int[B.length];
        for(int i = 0 ;i < B.length ;i++) {
            int  l = B[i][0];
            int r = B[i][1];
            if(l == 0){
                result[i] = prefixSum[r];
            }
            else { 
                result[i] = prefixSum[r] - prefixSum[l - 1];
            }
        }
        return result;
    }

    // Solution 2 Using ArrayList Concept
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(A.get(0));

        for(int i = 1; i<A.size(); i++) {
           prefixSum.add(prefixSum.get(i-1) + A.get(i));
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i< B.size(); i++) {
            int  l = B.get(i).get(0);
            int r = B.get(i).get(1);
            if(l ==0 ){
                result.add(prefixSum.get(r));
            }else {
            result.add(prefixSum.get(r) - prefixSum.get(l - 1));
            }
        }

        return result;
    } 
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<ArrayList<Integer>> query = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(0, 3)),
            new ArrayList<>(Arrays.asList(1, 2))
    ));
        System.out.println(solve(arrayList, query)); // [10, 5]

        int[] array = {2, 2, 2};
        int[][] query1 = {{0, 0}, {1, 2}};
        int result[] = prefixSum(array, query1);  // [2, 4]
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
