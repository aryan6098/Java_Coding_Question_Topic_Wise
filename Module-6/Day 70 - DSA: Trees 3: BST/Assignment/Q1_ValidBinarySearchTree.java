/*
 * Q1. Valid Binary Search Tree
Problem Description
You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.


Problem Constraints
1 <= Number of nodes in binary tree <= 105

0 <= node values <= 232-1


Input Format
First and only argument is head of the binary tree A.



Output Format
Return 0 if false and 1 if true.



Example Input
Input 1:

 
   1
  /  \
 2    3
Input 2:

 
  2
 / \
1   3


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 2 is not less than 1 but is in left subtree of 1.
Explanation 2:

Satisfies all conditions.
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
public class Q1_ValidBinarySearchTree {
    public static int prevValue = Integer.MIN_VALUE;

    public static boolean inOrder(TreeNode A) {
        if(A == null) {
            return true;
        }
        boolean ans = inOrder(A.left);
        if(ans == false) {
            return false;
        }
        if(A.val <= prevValue) {
            return false;
        }
        else if(A.val > prevValue) {
            prevValue = A.val;
        }
        return inOrder(A.right);
    }
    public static int isValidBST(TreeNode A) {
        return inOrder(A) == true ? 1 : 0; 
     

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
       System.out.println( isValidBST(root));  // 1
    }
}
