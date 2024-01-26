
public class AddTwoDecimalNumber {

    public static void addTwoDecimalNumber(int n1, int n2){
        int mul = 1;
        int ans = 0;
        int carry =0;
        while(n1 > 0 || n2 > 0 || carry > 0){
            int d1 = n1%10;
            int d2 = n2%10;
            n1 = n1/10;
            n2 = n2/10;
            int sum = d1 + d2 + carry;
            int rem = sum % 10;
            carry = sum/10;
            ans = ans + rem * mul;
            mul = mul * 10;

        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        addTwoDecimalNumber(89, 143);
    }
}
