/*
 * Q2. Countries with population less than K

Problem Description
You are given a Hashmap<String, int> H and an integer K as a function input.

The hashmap stores the name of some countries and the corresponding population.

Return the number of countries with a population less than K.

Problem Constraints
1 <= Length of H <= 105


Input Format
First argument is the hashmap H.

Second argument K is an integer.


Output Format
Return an integer denoting the number of countries with population less than K

Example Input
Input 1:
H = [{"India", 12}, {"Pakistan", 8}, {"China" , 9}]
K = 10
Input 2:
H = [{"USA", 6}, {"Canada", 4}]
K = 6


Example Output
Output 1:
2
Output 2:
1

Example Explanation
For Input 1:
The countries with population less than 10 are Pakistan and China.
For Input 2:
The country with population less than 6 is Canada.

 */
import java.util.HashMap;

public class Q2_CountriesWithPopulationLessThanK {

    public static int population(HashMap<String, Integer> H, int K){
        int count=0;
        for(String val: H.keySet()){
            if(H.get(val)<K){
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("India", 12);
        hashMap.put("Pakistan", 8);
        hashMap.put("China" , 9);
        System.out.println(population(hashMap, 10));
    }
}
