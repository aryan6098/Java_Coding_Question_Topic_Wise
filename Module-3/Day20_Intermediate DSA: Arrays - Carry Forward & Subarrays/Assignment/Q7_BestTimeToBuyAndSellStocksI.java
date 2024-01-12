/*
 * Q7. Best Time to Buy and Sell Stocks I
Problem Description
Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Return the maximum possible profit.


Problem Constraints
0 <= A.size() <= 700000
1 <= A[i] <= 107

Input Format
The first and the only argument is an array of integers, A.


Output Format
Return an integer, representing the maximum possible profit.


Example Input
Input 1:
A = [1, 2]
Input 2:

A = [1, 4, 5, 2, 4]


Example Output
Output 1:
1

Output 2:
4


Example Explanation
Explanation 1:
Buy the stock on day 0, and sell it on day 1.
Explanation 2:

Buy the stock on day 0, and sell it on day 2.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.crypto.Mac;

public class Q7_BestTimeToBuyAndSellStocksI {

    public static int maxProfit(final List<Integer> A) {
        int maxProfit = 0;
        for(int i = 0; i < A.size(); i++) {
            int max = A.get(i);
            for(int j = i + 1; j < A.size(); j++) {
                if(A.get(j) > max) {
                    max = A.get(j);
                }
            }
              int profit =  max - A.get(i);
              if(profit > maxProfit) {
                maxProfit = profit;
              }
        }
        return maxProfit;
    } 

    public static int solve(final List<Integer> A){
        int profitPrice = 0;
      
        if(A.size()== 0){
            return 0;
        }
          int max =  A.get(A.size()-1);
        for(int  i = A.size()-1; i >= 0; i--){
            if(A.get(i) > max){
                max =A.get(i);
            }
            int profit = max - A.get(i);
            if(profit > profitPrice){
                profitPrice = profit;
            }
        }
        return profitPrice;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList());
        // System.out.println(maxProfit(list));
        System.out.println(solve(list));
    }
}


