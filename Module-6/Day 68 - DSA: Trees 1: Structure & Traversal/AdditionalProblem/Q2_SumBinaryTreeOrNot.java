/*
 * Q2. Sum binary tree or not
Problem Description
Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.

Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.

An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

Return 1 if it sum-binary tree else return 0.



Problem Constraints
1 <= length of the array <= 100000

0 <= node values <= 50



Input Format
The only argument given is the root node of tree A.



Output Format
Return 1 if it is sum-binary tree else return 0.



Example Input
Input 1:

       26
     /    \
    10     3
   /  \     \
  4   6      3
Input 2:

       26
     /    \
    10     3
   /  \     \
  4   6      4


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 All leaf nodes are considered as SumTree. 
 Value of Node 10 = 4 + 6.
 Value of Node 3 = 0 + 3 
 Value of Node 26 = (10 + 4 + 6) + 6 
Explanation 2:

 Sum of left subtree and right subtree is 27 which is not equal to the value of root node which is 26.
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

public class Q2_SumBinaryTreeOrNot {

    public static int getSum(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int leftSum = getSum(A.left);
        int rightSum = getSum(A.right);
        return leftSum + rightSum + A.val;
    }

    public static int solve(TreeNode A) {
        if (A == null) {
            return 0;
        }
        if (A.left == null || A.right == null) {
            return 1;
        }
        int leftSum = getSum(A.left);
        int rightSum = getSum(A.right);
        if (A.val - (leftSum + rightSum) == 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode rNode = new TreeNode(26);
        rNode.left = new TreeNode(10);
        rNode.right = new TreeNode(3);
        rNode.left.left = new TreeNode(4);
        rNode.left.right = new TreeNode(6);
        rNode.right.right = new TreeNode(3);
        System.out.println(solve(rNode));
    }
}
