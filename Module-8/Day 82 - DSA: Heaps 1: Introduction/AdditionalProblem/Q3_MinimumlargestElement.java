
/*
 * Problem Description

Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.







Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
Find the minimum possible largest element after B operations.









Problem Constraints

1 <= N <= 104
0 <= B <= 104
1 <= A[i] <= 104



Input Format

The first argument is an integer array A.
The second argument is an integer B.



Output Format

Return an integer denoting the minimum possible largest element after B operations.



Example Input

Input 1:

 A = [1, 2, 3, 4] 
 B = 3
Input 2:

 A = [5, 1, 4, 2] 
 B = 5


Example Output

Output 1:

 4
Output 2:

 5


Example Explanation

Explanation 1:

 Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
 Minimum possible largest element after 3 operations is 4.
Explanation 2:

 Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
 Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
 Minimum possible largest element after 5 operations is 5.


 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    // int original;
    int current;
    int index;

    Pair(int current, int index) {
        // this.original = original;
        this.current = current;
        this.index = index;
    }

    @Override
    public String toString() {
        return "(" + current + ", " + index + ")";
    }
}

public class Q3_MinimumlargestElement {

    public static int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.current, p2.current));
        for (int i = 0; i < A.size(); i++) {
            pq.add(new Pair(2 * A.get(i), i));
        }
        ArrayList<Integer> arrayList = new ArrayList<>(A);
        ArrayList<Integer> list = new ArrayList<>(A);
        for (int i = 0; i < B; i++) {
            Pair minPair = pq.poll();
            arrayList.set(minPair.index, minPair.current);
            minPair.current += A.get(minPair.index);
            pq.add(minPair);

        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arrayList.size(); i++) {
            max = Math.max(max, arrayList.get(i));
        }

        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 1, 4, 2));
        System.out.println(solve(arrayList, 5));
    }
}
