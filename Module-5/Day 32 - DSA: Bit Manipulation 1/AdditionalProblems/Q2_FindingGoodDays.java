public class Q2_FindingGoodDays {
    public static int solve(int A) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if((A & (1 << i)) > 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(solve(5));
       
    }
}
