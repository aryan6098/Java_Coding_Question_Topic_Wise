/*
 * Q1. Sorted Permutation Rank

 */
public class Q1_SortedPermutationRank {

    public static long mod = 1000003;
    public static int findFact(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return (n * findFact(n - 1));
    }
    public static int findRank(String A) {
        int n = A.length();
        int ans = 0;
        for(int i = 0; i < A.length(); i++) {
            int count = 0;
            for(int j = i + 1; j < A.length(); j++) {
                if(A.charAt(i) > A.charAt(j)) {
                    count++;
                }
            }
            ans += count * findFact(n - i - 1);
        }
        return ans + 1;
    }
    public static void main(String[] args) {
        System.out.println(findRank("play"));
    }
}
