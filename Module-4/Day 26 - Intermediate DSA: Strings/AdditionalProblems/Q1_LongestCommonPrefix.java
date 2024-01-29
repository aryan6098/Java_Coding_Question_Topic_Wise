/*
 * Q1. Longest Common Prefix
 */
public class Q1_LongestCommonPrefix {
    public static String longestCommonPrefix(String[] A) {
        if (A == null || A.length == 0) {
            return "";
        }

        String firstString = A[0];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < firstString.length(); i++) {
            char currentChar = firstString.charAt(i);

            for (int j = 1; j < A.length; j++) {
                if (i >= A[j].length() || A[j].charAt(i) != currentChar) {
                    return result.toString();
                }
            }

            result.append(currentChar);
        }

        return result.toString();
    }
    public static void main(String[] args) {
        String[] A = {"abcdefgh"};
        System.out.println(longestCommonPrefix(A));
    }
}
