/*
 * Q3. Majority Element

 */
public class Q3_MajorityElement {
    public static int majorityElement(final int[] A) {
        int mE = A[0];
        int count = 1;
        int freq = 0;
        for(int i  = 1; i < A.length; i++) {
            if(count==0) {
                mE = A[i];
                count = 1;
            }
            else if(A[i]==mE){
                count++;
            }
            else {
                count--;
            }
        }
        for(int i = 0; i < A.length; i++) {
            if(A[i]== mE) {
                freq++;
            }
        }
        if(freq > A.length/2){
            return mE;
        }
        else {
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        System.out.println(majorityElement(arr));
    }
}
