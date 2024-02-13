/*
 * Q6. Toggle i-th bit

 */
public class Q6_ToggleIthbit {
    public static int solve(int A, int B) {
        return A ^ (1 << B);
    }
    public static void main(String[] args) {
        System.out.println(solve(4, 1));
    }
}
