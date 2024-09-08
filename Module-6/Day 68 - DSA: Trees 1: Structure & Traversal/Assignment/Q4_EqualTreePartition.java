/*
 * Q4. Equal Tree Partition
Problem Description
Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.



Problem Constraints
1 <= size of tree <= 100000

0 <= value of node <= 109



Input Format
First and only argument is head of tree A.



Output Format
Return 1 if the tree can be partitioned into two trees of equal sum else return 0.



Example Input
Input 1:

 
                5
               /  \
              3    7
             / \  / \
            4  6  5  6
Input 2:

 
                1
               / \
              2   10
                  / \
                 20  2

Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Remove edge between 5(root node) and 7: 
        Tree 1 =                                               Tree 2 =
                        5                                                     7
                       /                                                     / \
                      3                                                     5   6    
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18
Explanation 2:

 The given Tree cannot be partitioned.

 */

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left = right = null;
    }
 }
public class Q4_EqualTreePartition {
   static boolean found = false;
    static int totalSum;
    public static int sum(TreeNode A) {
        if(A == null) {
            return 0;
        }
         int s1 = sum(A.left);
         int s2 = sum(A.right);
        int subTreeSum =  s1 + s2 + A.val;
        return subTreeSum;
    }

    public static boolean hasSubTreeWithHalfSum(TreeNode A) {
        if(A == null) {
            return false;
        }

        int subTree = sum(A);
        if(subTree == totalSum - subTree ) {
            return true;
        }

       return  hasSubTreeWithHalfSum(A.left) || hasSubTreeWithHalfSum(A.right);
       

    }
    public static int solve(TreeNode A) {
        totalSum = sum(A);
        if(totalSum %2 != 0) {
            return 0;
        }
        return hasSubTreeWithHalfSum(A) ? 1 : 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(solve(root));
    }
}
