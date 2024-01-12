/*
 * Q6. Generate all subarrays
Problem Description
You are given an array A of N integers.
Return a 2D array consisting of all the subarrays of the array

Note : The order of the subarrays in the resulting 2D array does not matter.


Problem Constraints
1 <= N <= 100
1 <= A[i] <= 105


Input Format
First argument A is an array of integers.


Output Format
Return a 2D array of integers in any order.


Example Input
Input 1:
A = [1, 2, 3]
Input 2:
A = [5, 2, 1, 4]


Example Output
Output 1:
[[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
Output 2:
[[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]


Example Explanation
For Input 1:
All the subarrays of the array are returned. There are a total of 6 subarrays.
For Input 2:
All the subarrays of the array are returned. There are a total of 10 subarrays.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q6_GenerateAllSubarrays {


    // First Approach using Array
    public static void solve(int[] A){
        int n = A.length;
        int totalSubArrays = (n *(n+1))/2 ;
        int[][] result = new int[totalSubArrays][A.length];
        int subArrayIndex = 0;

        for(int i = 0; i < A.length; i++){
            for(int j = i ;j < A.length ;j++){
                for(int k = i; k <= j; k++){
                    result[subArrayIndex][k] = A[k];
                }
                subArrayIndex++;
            }
        }

        for(int i = 0;i<result.length;i++) {
            for(int j = 0; j< result[0].length; j++){
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }
    }

    // Second Approach
    public static ArrayList<ArrayList<Integer>> subArrays(ArrayList<Integer> A){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int  i = 0; i < A.size(); i++){
            for(int j = i; j < A.size(); j++){
                ArrayList<Integer> val = new ArrayList<>();
                for(int k = i; k <= j; k++){
                    val.add(A.get(k));
                }
                result.add(val);
            }
        }
        return result;
    } 

    public static void main(String[] args) {
        int[] arr = {36,63,63,26,87,28,77,93,7};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3));
        solve(arr);
        System.out.println(subArrays(arrayList));
    }
}
