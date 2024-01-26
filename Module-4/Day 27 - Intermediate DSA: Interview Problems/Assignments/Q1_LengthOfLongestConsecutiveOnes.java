/*
 * Q1. Length of longest consecutive ones
Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.


Input Format

The only argument given is string A.
Output Format

Return the length of the longest consecutive 1’s that can be achieved.
Constraints

1 <= length of string <= 1000000
A contains only characters 0 and 1.
For Example

Input 1:
    A = "111000"
Output 1:
    3

Input 2:
    A = "111011101"
Output 2:
    7
 */
public class Q1_LengthOfLongestConsecutiveOnes {

    public static int solve(String A) {
        char str[] = A.toCharArray();
        int count = 0;
        int ans = 0;

        for(int i = 0; i < A.length(); i++) {
            if(str[i]== '1'){
                count++;
            }
        }
        if(count==0) {
            return 0;
        }
        else if(count==A.length()){
            return A.length();
        }

        for(int i = 0; i < str.length;i++){
            if(str[i]== '0') {
                int l = 0;
                for(int j = i - 1; j>=0;j--){
                    if(str[j]=='1'){
                        l++;
                    }
                    else {
                        break;
                    }
                }
                int r = 0;
                for(int j = i + 1; j < str.length; j++) {
                    if(str[j] == '1'){
                        r++;
                    }
                    else {
                        break;
                    }
                }

                if(l+r==count) {
                    ans = Math.max(ans, l+r);
                }
                else { 
                    ans = Math.max(ans, l+r+1);
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        String str = "00000011111111";
        System.out.println(solve(str));
    }
    
}
