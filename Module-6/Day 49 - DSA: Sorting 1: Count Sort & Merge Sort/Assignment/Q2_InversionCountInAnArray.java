public class Q2_InversionCountInAnArray {


    static int count = 0;
    // public static int solve(int[] A) {
    //     int count = 0; 
    //     for(int i = 0 ; i < A.length; i++) {
    //         for(int j = i; j >= 0; j--) {
    //             if(A[i] < A[j] && j < i) {
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }



    public static void merge(int[] A, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = A[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = l; 
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                count = count+n1- i;
                j++;
            }
            k++;
        }
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
       
    }
    public static void mergeSort(int A[], int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(A, l, mid);
        mergeSort(A, mid + 1, r);
        merge(A, l, mid, r);
    }


    public static int solve(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {28,18,44,49,41,14};
        System.out.println(solve(arr));
    }
}
