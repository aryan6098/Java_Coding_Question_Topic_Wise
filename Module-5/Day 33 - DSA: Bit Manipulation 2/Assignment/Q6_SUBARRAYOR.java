import java.util.ArrayList;
import java.util.Arrays;

public class Q6_SUBARRAYOR {
    public static int solve(ArrayList<Integer> A) {
        int ans = 0;
        for (int i = 0; i < A.size(); i++) {
            int current = A.get(i);
        ans |= current;
        for (int j = i + 1; j < A.size(); j++) {
            current |= A.get(j);
            ans += current;
        }
        }
        return ans;
    }

    public static int solveMethod1(int[] A) {
        long ans = 0 ;
        int n = A.length;
        int M = 1000000007 ;

        for(int i = 0; i < 30; i++) {
            int prev = -1;
            long count = 0;
            long bit =  (1 << i);
            for(int j = 0; j < n; j++) {
                if(((A[j] >> i) & 1)==1) {
                    prev = j;
                }
                count += (prev + 1);
            }
        
            ans = (ans + (count % M * bit%M)%M)% M;
        }

        return (int) ans;

    }



    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(7, 8, 9, 10));
        System.out.println(solve(arrayList));
        // int[] arr = {347148,221001,394957,729925,276769,40726,552988,29952,184491,146773,418965,307,219145,183037,178111,81123,109199,683929,422034,346291,11434,7327,340473,316152,364005,359269,170935,105784,224044,22563,48561,165781,9329,357681,169473,175031,605611,374501,6607,329965,76068,836137,103041,486817,195549,107317,34399,56907,37477,189690,36796,376663,39721,177563,174179,183646,217729,408031,429122,631665,282941,526797,262186,306571,63613,57501,70685,226381,1338,9360,130360,20300,400906,87823,180349,108813,18181,119185,1,102611,63591,12889,311185,383896,8701,76077,75481,386017,153553,304913,383455,105948,142885,1,12610,137005,119185,16948,66171,123683};
        // System.out.println(solve(arr));

    }
}
