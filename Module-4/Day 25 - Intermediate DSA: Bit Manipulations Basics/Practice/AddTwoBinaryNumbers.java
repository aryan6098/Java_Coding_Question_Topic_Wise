
public class AddTwoBinaryNumbers {
    public static void addTwoBinaryNumbers(int n1, int n2) {
        int ans = 0;
        int mul =1;
        int carry = 0;
        while(n1 > 0 || n2 > 0 || carry > 0) {
            int d1 = n1%10;
            int d2 = n2%10;
            n1 = n1/10;
            n2 = n2/10;
            int sum = d1 + d2 + carry;
            carry = sum / 2;
            int rem = sum % 2;
            ans = ans + rem * mul;
            mul *= 2;
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
       addTwoBinaryNumbers(10110, 00111); 
    }
}
