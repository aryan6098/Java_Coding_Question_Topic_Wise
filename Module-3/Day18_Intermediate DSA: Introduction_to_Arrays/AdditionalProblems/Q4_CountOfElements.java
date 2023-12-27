/**

 * Q4. Count of elements
Problem Description
Given an array A of N integers. 
Count the number of elements that have at least 1 elements greater than itself.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109


Input Format
First and only argument is an array of integers A.


Output Format
Return the count of elements.

Example Input
Input 1:
A = [3, 1, 2]
Input 2:
A = [5, 5, 3]


Example Output
Output 1:
2
Output 2:
1


Example Explanation
Explanation 1:
The elements that have at least 1 element greater than itself are 1 and 2
Explanation 2:
The elements that have at least 1 element greater than itself is 3
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q4_CountOfElements {

    //First Approach
    public static int solve(ArrayList<Integer> A) {
        int count = 0;
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.size();j++){
                if(i!=j && A.get(i)<A.get(j)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    // Second Approach
    public static int solve2(int[] A) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0;i<A.length;i++){
            max = Math.max(max, A[i]);
        }
        for(int i=0;i<A.length;i++){
            if(max>A[i]){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5,5,3));
        System.out.println(solve(arrayList)); 
        int[] arr = {5,5,3};
        System.out.println(solve2(arr));          
    }
}
   