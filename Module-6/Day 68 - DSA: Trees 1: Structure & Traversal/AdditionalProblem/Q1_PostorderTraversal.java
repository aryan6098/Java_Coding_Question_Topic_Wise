/*
 * Q1. Postorder Traversal
Problem Description
Given a binary tree, return the Postorder traversal of its nodes values.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the Postorder traversal of the given binary tree.



Example Input
Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [3, 2, 1]
Output 2:

 [6, 3, 2, 1]


Example Explanation
Explanation 1:

 The Preoder Traversal of the given tree is [3, 2, 1].
Explanation 2:

 The Preoder Traversal of the given tree is [6, 3, 2, 1].

 */

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        int val = x;
        left = right = null;
    }
}

public class Q1_PostorderTraversal {
    public static void postorderTraversalHelper(TreeNode A ,ArrayList<Integer> res) {
        if(A == null) {
            return;
        }
        postorderTraversalHelper(A.left, res);
        postorderTraversalHelper(A.right, res);
        res.add(A.val)
    }
    public static ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result =  new ArrayList<>();
        postorderTraversalHelper(A, result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(postorderTraversal(root));
    }
}
