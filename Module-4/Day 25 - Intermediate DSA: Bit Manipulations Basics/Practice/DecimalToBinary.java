
public class DecimalToBinary {
    public static void decimalToBinary(int n) {
        int mul = 1;

        int ans = 0;
        while(n > 0) {
            int rem = n%2;
            n = n/2;
            ans= ans + rem * mul;
            mul = mul * 10;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int n = 45;
        decimalToBinary(n);
    }
}
