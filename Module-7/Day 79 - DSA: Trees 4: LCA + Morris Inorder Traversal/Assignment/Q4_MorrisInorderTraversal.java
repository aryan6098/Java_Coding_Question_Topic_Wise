/*
 * Problem Description

Given a binary tree, return the inorder traversal of its nodes' values.

NOTE: Using recursion and stack are not allowed.





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
public class Q4_MorrisInorderTraversal {
    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        TreeNode curr = A;
        while (curr != null) {
            if(curr.left == null) {
                arrayList.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                if(temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                }
                if(temp.right == curr) {
                    temp.right = null;
                    arrayList.add(curr.val);
                    curr  = curr.right;
                }
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(solve(root));
    }
}
