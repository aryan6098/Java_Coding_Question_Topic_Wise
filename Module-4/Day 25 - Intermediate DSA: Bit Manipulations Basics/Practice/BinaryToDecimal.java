/**
 * BinaryToDecimal
 */
public class BinaryToDecimal {

    public static void binaryToDecimalMethod1(int n) {
        int ans = 1;
        int power = 0;
        int res = 0;
        while (n > 0) {
           int  val = n%10;
            res = res + val * (int) Math.pow(2, power);
            power++;
            n = n/10;
         
        }
        System.out.println(res+ " ");

    }

    public static void binaryToDecimalMethod2(int n) {
        int res = 0;
        int mul = 1;
        while (n > 0) {
           int  val = n%10;
           n = n/10;
            res = res + val * mul;
            mul = mul  * 2;
        }
        System.out.println(res+ " ");
    }


    public static void main(String[] args) {
        int n = 1011010;
        binaryToDecimalMethod1(n);
        binaryToDecimalMethod2(n);
    }
}