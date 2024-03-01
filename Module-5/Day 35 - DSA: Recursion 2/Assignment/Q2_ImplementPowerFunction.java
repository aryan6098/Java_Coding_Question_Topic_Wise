/*
 * Q2. Implement Power Function
Problem Description
Implement pow(A, B) % C.
 Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.


Problem Constraints
-109 <= A <= 109
0 <= B <= 109
1 <= C <= 109


Input Format
Given three integers A, B, C.


Output Format
Return an integer.


Example Input
Input 1:
A = 2
B = 3
C = 3
Input 2:
A = 3
B = 3
C = 1


Example Output
Output 1:
2
Output 2:
0


Example Explanation
Explanation 1:
23 % 3 = 8 % 3 = 2
Explanation 2:
33 % 1 = 27 % 1 = 0

 */
public class Q2_ImplementPowerFunction {

    public static long mul(int A, int B, int C) {

        if (B == 0) {
            return 1;
        }
        long ans = mul(A % C, B / 2, C);
        ans %= C;
        ans *= ans;
        ans %= C;
        if (B % 2 == 0) {
            return ans;
        } else {
            ans *= A;
            ans %= C;
            return ans;
        }
    }

    public static int pow(int A, int B, int C) {
        long ans = mul(A % C, B, C) % C;
        if (ans < 0)
            ans = (ans + C) % C;
        return (int) ans;
    }

    public static int powerMethod(int A, int B) {
        if(A == 0) {
            return 0;
        }
        if(B == 0 ){
            return 1;
        }
        int ans = powerMethod(A, B/2);
        if(B % 2 == 0) {
            return ans * ans;
        }
        else {
            return ans * ans * A;
        }
    }

    public static void main(String[] args) {
        // System.out.println(pow(2, 3, 3));
        System.out.println(powerMethod(2, 4));
    }
}
