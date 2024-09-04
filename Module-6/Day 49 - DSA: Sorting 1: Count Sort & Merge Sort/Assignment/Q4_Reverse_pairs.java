/*
 * Q4. Reverse pairs

 Problem Description
Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.


Problem Constraints
1 <= length of the array <= 105

-2 * 109 <= A[i] <= 2 * 109


Input Format
The only argument given is the integer array A.



Output Format
Return the number of important reverse pairs in the given array A.


Example Input
Input 1:

 A = [1, 3, 2, 3, 1]
Input 2:

 A = [4, 1, 2]


Example Output
Output 1:

 2
Output 2:

 1

Example Explanation
Explanation 1:

 There are two pairs which are important reverse pair 
 i.e  (1, 4) => A[1] > 2 * A[4] => 3 > 2 * 1 => 3 > 2 and
      (3, 4) => A[3] > 2 * A[4] => 3 > 2 * 1 => 3 > 2.
Explanation 2:

 There is only one pair 
 i.e (0, 1) => A[0] > 2 * A[1] => 4 > 2 * 1 => 4 > 1

 */
public class Q4_Reverse_pairs {

    public static int merge(int[] A, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        int count = 0;
        int  k = mid + 1;

        for(int i = l; i <= mid; i++) {
            while( k <= r && A[i] > 2L * A[k]) {
                k++;
            }
            count += k - (mid + 1);
        }

        for(int i = 0; i < n1; i++){
            L[i] = A[l  + i];
        }

        for(int j = 0; j < n2; j++) {
            R[j] = A[mid + 1 + j];
        }

        int i = 0, j = 0, index = l;

        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                A[index] = L[i];
                i++;                
            }
            else{ 
                A[index] = R[j];
                j++;
            }
            index++;
        }
        while (i < n1) {
            A[index] = L[i];
            i++;
            index++;
        }
        while (j < n2) {
            A[index] = R[j];
            j++;
            index++;
        }

        return count;
    }

    public static int mergeSort(int[] A, int l, int r) {
        if(l >= r) {
            return 0;
        }
        int mid = l + (r - l) /2;
        int count = 0;
        count += mergeSort(A, l, mid);
        count += mergeSort(A, mid + 1, r);

        count +=  merge(A, l, mid, r);

        return count;
    }

    public static int solve(int[] A) {

       return mergeSort(A, 0, A.length - 1);
    }
    public static void main(String[] args) {
        int[] A = {14046,57239,78362,99387,27609,55100,65536,62099,40820,33056,88380,78549,57512,33137,81212,32365,42276,65368,52459,74924,25355,76044,78056,45190,94365,58869,20611};
        System.out.println(solve(A));
        // for(int i = 0; i < A.length; i++) {
        //     System.out.print(A[i] + " ");
        // }
    }
}
