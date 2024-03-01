public class Q3_CheckBit {
    public static int solve(int A, int B) {
        if( (A & ( 1 << B)) > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public static void main(String[] args) {
        System.out.println(solve(5, 2));

    }
}
