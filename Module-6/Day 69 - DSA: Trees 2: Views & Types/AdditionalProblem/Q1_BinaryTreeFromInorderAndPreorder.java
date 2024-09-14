/*
 * Q1. Binary Tree From Inorder And Preorder
Problem Description
Given preorder and inorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is an integer array A denoting the preorder traversal of the tree.

Second argument is an integer array B denoting the inorder traversal of the tree.



Output Format
Return the root node of the binary tree.



Example Input
Input 1:

 A = [1, 2, 3]
 B = [2, 1, 3]
Input 2:

 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]


Example Output
Output 1:

   1
  / \
 2   3
Output 2:

   1  
  / \
 6   2
    /
   3


Example Explanation
Explanation 1:

 Create the binary tree and return the root node of the tree.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

public class Q1_BinaryTreeFromInorderAndPreorder {

    public static TreeNode tree(ArrayList<Integer> preOrder, int preStart, int inStart, int end,
            HashMap<Integer, Integer> hashMap) {
        if (inStart > end) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder.get(preStart));
        int rootIndex = hashMap.get(root.val);
        int leftSubTreeSize = rootIndex - inStart;
        root.left = tree(preOrder, preStart + 1, inStart, rootIndex - 1, hashMap);
        root.right = tree(preOrder, preStart + leftSubTreeSize + 1, rootIndex + 1, end, hashMap);
        return root;

    }

    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A == null || B == null || A.size() != B.size()) {
            return null;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < B.size(); i++) {
            hashMap.put(B.get(i), i);
        }
        return tree(A, 0, 0, B.size() - 1, hashMap);
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);

        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {

        ArrayList<Integer> preOrder = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> inOrder = new ArrayList<>(Arrays.asList(2, 1, 3));

       TreeNode root =  buildTree(preOrder, inOrder);
        printTree(root);
    }
}
