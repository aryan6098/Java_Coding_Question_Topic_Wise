/*
 * Q1. Count unique elements

Problem Description
You are given an array A of N integers. Return the count of elements with frequency 1 in the given array.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109

Input Format
First argument A is an array of integers.

Output Format
Return an integer.

Example Input
Input 1:
A = [3, 4, 3, 6, 6]
Input 2:
A = [3, 3, 3, 9, 0, 1, 0]


Example Output
Output 1:
1
Output 2:
2

Example Explanation
Explanation 1:
Only the element 4 has a frequency 1.
Explanation 2:
The elements 9 and 1 has a frequncy 1.
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q1_CountUniqueElements {

        public static int solve(ArrayList<Integer> A) {
            int count =0;
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for(int i=0;i<A.size();i++){
                if(hashMap.containsKey(A.get(i))){
                    hashMap.put(A.get(i), hashMap.get(A.get(i))+1);
                }
                else{
                    hashMap.put(A.get(i), 1);
                }
            }
            for(int val: hashMap.keySet()){
                if(hashMap.get(val)==1){
                    count++;
                }
            }
            return count;

        }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(3,4,3,5,32,6,6));
        System.out.println(solve(arrayList));
    }
    
}
