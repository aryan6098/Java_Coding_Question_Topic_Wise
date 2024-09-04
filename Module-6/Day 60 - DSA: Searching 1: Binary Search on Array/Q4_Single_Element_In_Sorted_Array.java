/*
 * Q4. Single Element in Sorted Array

 */
public class Q4_Single_Element_In_Sorted_Array {
    public static int solve(int[] A) {

        int l = 0; 
        int r = A.length - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if((mid == 0 || A[mid - 1] != A[mid]) && ((mid == A.length - 1 || A[mid + 1] != A[mid]))){
                return A[mid];
            }
            else if(A[mid + 1] == A[mid] ||( mid == A.length - 1)) {
                if(mid%2 == 0) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }else {
                if((mid - 1)%2 == 0 || (mid == 0) ) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int A[] = {2, 3,3};
        System.out.println(solve(A));
    }
}
