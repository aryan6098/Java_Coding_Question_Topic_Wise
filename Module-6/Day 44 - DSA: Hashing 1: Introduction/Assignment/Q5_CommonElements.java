/*
Q5. Common Elements

 * Problem Description
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.


Problem Constraints
1 <= N, M <= 105

1 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.

Second argument is an integer array B of size M.



Output Format
Return an integer array denoting the common elements.



Example Input
Input 1:

 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:

 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]


Example Output
Output 1:

 [1, 2, 2]
Output 2:

 [2, 10]


Example Explanation
Explanation 1:

 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:

 Elements (2, 10) appears in both the array.

 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Q5_CommonElements {
    public static ArrayList<Integer> solve(int[] A, int[] B) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap_A = new HashMap<>();
        HashMap<Integer, Integer> hashMap_B = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            hashMap_A.put(A[i], hashMap_A.getOrDefault(A[i], 0) + 1);
        }
        for (int i = 0; i < B.length; i++) {
            hashMap_B.put(B[i], hashMap_B.getOrDefault(B[i], 0) + 1);
        }

        for (int val : hashMap_A.keySet()) {
            if(hashMap_A.containsKey(val) && hashMap_B.containsKey(val)) {
                    for (int i = 0; i < Math.min(hashMap_B.get(val), hashMap_A.get(val)); i++) {
                        arrayList.add(val);
                    }
            }
            
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 2, 1 };
        int[] B = {2, 3, 1, 2 };
        System.out.println(solve(A, B));
    }
}
