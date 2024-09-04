/*
 * Q2. Balanced Paranthesis

 */

import java.util.ArrayList;

public class Q2_BalancedParanthesis {

    public static int solve(String A) {
        ArrayList<Character> stack = new ArrayList<>();
        boolean isBal = true;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if ((c == ')' || c == '}' || c == ']')) {
                if (stack.isEmpty()) {
                    return 0;
                }

                char top = stack.remove(stack.size() - 1);
                if ((c == '}' && top != '{') ||
                        (c == ')' && top != '(') ||
                        (c == ']' && top != '[')) {
                    return 0;
                }

            } else if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            }

        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        String str = "{([])}";
        System.out.println(solve(str));
    }
}
