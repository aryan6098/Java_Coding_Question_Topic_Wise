/*
 * Q1. Inorder Traversal
Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.


Problem Constraints
1 <= number of nodes <= 105


Input Format
First and only argument is root node of the binary tree, A.


Output Format
Return an integer array denoting the inorder traversal of the given binary tree.


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

 [1, 3, 2]
Output 2:

 [6, 1, 3, 2]


Example Explanation
Explanation 1:

 The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2:

 The Inorder Traversal of the given tree is [6, 1, 3, 2].

 */

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class Q1_InorderTraversal {

    public static void inorderTraversalHelper( TreeNode A, ArrayList<Integer> res)  {
        int sum = 0;
        if(A == null) {
            return;
        }
        inorderTraversalHelper(A.left, res);
        res.add(A.val);
        sum += A.val;
        System.out.println("sum : "+ sum);
        inorderTraversalHelper(A.right, res);
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();

        inorderTraversalHelper(A, res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        ArrayList<Integer> result = inorderTraversal(root);
        System.out.println("Inorder Traversal: " + result);
    }
}
