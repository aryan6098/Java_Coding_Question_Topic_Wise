public class Q3_Find_a_Peak_Element {
    public static int solve(int[] A) {
        
        int l = 0;
        int r = A.length - 1; 
       
        while(l <= r) {
            int mid = l + (r - l)/2;
            if((mid ==0 || (A[mid - 1] <= A[mid])) && ((A[mid] >= A[mid + 1]) || (mid == A.length - 1)) ){
                return A[mid];
            }else if (A[mid] > A[mid - 1] || mid==0) {
                l = mid + 1;
            }else  {
                r = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] A = {5, 17, 100, 11};
        System.out.println(solve(A));
    }
}
