public class IsPalindromes {

    public static void isPalindromeMethod1(String str) {
        char[] originalString = str.toCharArray();
        int st = 0;
        int end = str.length() - 1;
        while (st <= end) {
            char temp = str.charAt(st);
            originalString[st] = str.charAt(end);
            originalString[end] = temp;
            st++;
            end--;
        }
        if (str.equals(String.valueOf(originalString))) {
            System.out.println("palindrome");
        } else {
            System.out.println("Not palindrome");
        }
    }

    public static void isPalindromeMethod2(String str) {
        int st = 0;
        int end = str.length() - 1;
        boolean flag = true;
        while (st < end) {
            if (str.charAt(st)==(str.charAt(end))) {
                st++;
                end--;
                continue;
            } 
            else {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("palindrome");
        } else {
            System.out.println("Not palindrome");
        }
    }

    

    public static boolean isPalindromeMethodWithPointer(String str, int stIndex, int endIndex){
        int st = stIndex;
        int end = endIndex;
        boolean flag = true;
        while (st < end) {
            if (str.charAt(st)!=(str.charAt(end))) {
                flag = false;
                break;
            }
            st++;
            end--;
        }
        if (flag) {
            return true;
        } else {
           return false;
        }
    }

    public static void longestSubstring(String str) {
        int maxLength = 0;
        for(int i = 0; i < str.length();i++){
            for(int j = i; j < str.length(); j++) {
                if(isPalindromeMethodWithPointer(str, i, j) == true) {
                    int length = j - i + 1;
                    if(maxLength < length) {
                        maxLength = length;
                    }
                   }
            }
        }
        System.out.println("longest substring Palindrome: " + maxLength);
    }

    public static void main(String[] args) {
        String str = "ananbnap";
        // isPalindromeMethod1(str);
        // isPalindromeMethod2(str);
        // isPalindromeMethodWithPointer(str, 2, 6);
        String substr = "adaebcdfdcbetggte";
        longestSubstring(substr);

    }
}