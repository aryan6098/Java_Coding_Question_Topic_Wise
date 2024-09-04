import java.util.ArrayList;
import java.util.Stack;

public class Q5_Infix_ToPostfix {

    public static int precedence(char ch) {
        switch (ch) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }

    public static String solve(String A) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);

            if(Character.isLetter(c)) {
                result.append(c);
            }else if(c == '('){
                stack.push(c);
            }else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                // else {
                    stack.pop();
                // }
            }else {
                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.toString();

    }

    public static void main(String[] args) {
        String A = "x^y/(a*z)+b";
        System.out.println(solve(A));
    }
}
