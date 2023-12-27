/*
 * Q4. Vowels vs Consonants
Problem Description
Write a program to input T strings (S) from user and print count of vowels and consonants in it.

Problem Constraints
1 <= T <= 100

1 <= S.size() <= 1000

Input Format
First line is T which means number of test cases.

Each next T lines contain a lowercase string S.

Output Format
T lines each containing two space separated integers representing cont of vowels and consonants in input string.

Example Input
Input 1:

2
interviewbit
scaler

Example Output
Output 1:

5 7
2 4
 */

import java.util.Scanner;

public class Q4_VowelsvsConsonants {

    public static void countVowelsAndConsonants(String str){
        int countVowels = 0;
        int countConsonants = 0;
        for(int i=0;i<str.length();i++){
            char lowercase  = Character.toLowerCase(str.charAt(i));
            if(lowercase =='a' || lowercase =='e'  || lowercase =='i' || lowercase =='o' || lowercase =='u')
            {
                countVowels ++;
            }
            else {
                countConsonants++;
            }
        }
        System.out.println(countVowels+ " "+ countConsonants);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(n>0){
            String str = sc.nextLine();
            countVowelsAndConsonants(str);
            n--;
        }
    }
    
}
