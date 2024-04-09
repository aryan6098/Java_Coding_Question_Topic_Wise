public class Q1_MergeTwoSortedArrays {

    public static int[] solve(final int[] A, final int[] B) {
        int[] ans = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while(i < A.length && j < B.length) {
            if(A[i] < B[j]) {
                ans[index] = A[i];
                i++;
            }
            else {
                ans[index] = B[j];
                j++;
            }
            index++;
        }
        while (i < A.length) {
            ans[index] = A[i];
            i++;
            index++;
        }
        while(j < B.length) {
            ans[index] = B[j];
            j++;
            index++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {4, 7, 9};
        int[] B = {2, 11, 19};
        int[] res = solve(A, B);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
