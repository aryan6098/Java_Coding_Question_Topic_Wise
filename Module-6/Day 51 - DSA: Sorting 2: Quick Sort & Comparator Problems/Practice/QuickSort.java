/*
 * Quick Sort
 */
public class QuickSort {


    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static int partition(int[] A, int l, int r) {
        
        int pivot = A[r];
        int i = l - 1;
        for(int j = l; j < r ; j++) {
            if(A[j] < pivot) {
                i++;
                swap(A, i , j);
            }
        }
        swap(A, i+1, r);
        return i + 1;
    }
   public static void quickSort(int[] A, int l, int r) {
        if(l < r) {
            int pi = partition(A, l, r);
            quickSort(A, l, pi - 1);
            quickSort(A, pi + 1, r);
        }
    }
    public static void main(String[] args) {
        int[] A = {54, 26, 93, 17, 77, 31, 44, 55};
        quickSort(A, 0, A.length-1);
        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
