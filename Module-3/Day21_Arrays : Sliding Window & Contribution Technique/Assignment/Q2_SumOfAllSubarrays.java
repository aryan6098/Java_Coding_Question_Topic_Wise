public class Q2_SumOfAllSubarrays {


    //Method 4 : 
    // T.C = O(N) ,  S.C == O(1)
    public static long subarraySumMethod4(int[] A){
        int ans = 0;
        for(int i = 0; i < A.length; i++){
            int count = (i+1) * (A.length - i);
            ans += A[i] * count;
        }
        return ans;
    }

    //Method- 2 : Carry Forward Approach
    // T.C = O(N2) ,  S.C == O(1)
    public static long subarraySumMethod3(int[] A) {
        long ans = 0;
        for(int i =0; i< A.length; i++) {
            long sum = 0;
            for(int j = i; j < A.length; j++){
                sum = sum + A[j];
                ans = ans + sum;
            }g

        }
        return ans ;
    }

    // Method- 2 :  Prefix Sum Approach
    // T.C = O(N2) ,  S.C == O(N)
    public static long subarraySumMethod2(int[] A) {
        long[] prefixSum = new long[A.length];
        prefixSum[0] = A[0];
        for(int i = 1; i < A.length; i++){
            prefixSum[i] = prefixSum[i-1] + A[i];
        }
        long ans = 0;
        for(int i = 0; i < A.length; i++) {
            long sum = 0;
            for(int j = i; j < A.length; j++){
                if(i == 0) {
                    sum = sum + prefixSum[j];
                }
                else {
                    sum = sum + prefixSum[j] - prefixSum[ i -1 ];
                }
            }
            ans +=sum;
        }
        return ans;
    }

    // Method - 1 : Bruit Force Approach
    // T.C = O(N3) ,  S.C == O(1)
    public static long subarraySumMethod1(int[] A) {
        long ans = 0;
        for(int i = 0; i < A.length; i++){
            int sum = 0;
            for(int j = i; j < A.length; j++) {
                for(int k = i; k <= j; k++){
                    sum = sum + A[k];
                }
            }
            ans =ans+sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subarraySumMethod1(arr));
        System.out.println(subarraySumMethod2(arr));
        System.out.println(subarraySumMethod3(arr));
        System.out.println(subarraySumMethod4(arr));
    }
}
