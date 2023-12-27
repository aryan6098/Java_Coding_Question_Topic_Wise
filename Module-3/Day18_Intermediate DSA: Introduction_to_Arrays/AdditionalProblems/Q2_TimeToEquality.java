/*
 * Q2. Time to equality
Problem Description
Given an integer array A of size N. In one second, you can increase the value of one element by 1.

Find the minimum time in seconds to make all elements of the array equal.

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000

Input Format
First argument is an integer array A.

Output Format
Return an integer denoting the minimum time to make all elements equal.

Example Input
A = [2, 4, 1, 3, 2]

Example Output
8

Example Explanation
We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.

 */
import java.util.ArrayList;
import java.util.Arrays;

public class Q2_TimeToEquality {

    public static int solve(ArrayList<Integer> A) {
        int totalSecond = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<A.size();i++){
            if(A.get(i) > max){
                max = A.get(i);
            }
        }
        for(int i=0;i<A.size();i++){
            if(A.get(i)<max){
                totalSecond = totalSecond + (max-A.get(i));
            }
        }

        return totalSecond;
    }
    //  public static int solve(int A[]) {
    //     int n = A.length;
    //     int max = Integer.MIN_VALUE;
    //     int totalSecond = 0;
    //     for(int i=0;i<n;i++){
    //         max = Math.max(max, A[i]);
    //     }
    //     for(int i=0;i<n;i++){
    //         totalSecond = totalSecond+ (max - A[i]);
    //     }
    //     return totalSecond;
    //  }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 4, 1, 3, 2));
        // int array[] = {2,4,1,3,2};
        System.out.println(solve(arrayList));    
    }
}


