/*
 * Q2. Kth Smallest Element In BST
Problem Description

Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.



Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format

First and only argument is head of the binary tree A.



Output Format

Return an integer, representing the Bth element.



Example Input

Input 1:

 
            2
          /   \
         1    3
B = 2
Input 2:

 
            3
           /
          2
         /
        1
B = 1



Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

2nd element is 2.
Explanation 2:

1st element is 1. */

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

public class Q2_KthSmallestElementInBST {
    static int count = 0;
    static int ans = Integer.MIN_VALUE;

    // first method
    public static void genrateInorderArrayList(TreeNode A, ArrayList<Integer> ans) {
        if (A == null) {
            return;
        }

        genrateInorderArrayList(A.left, ans);
        ans.add(A.val);
        genrateInorderArrayList(A.right, ans);
    }

    // Second Method
    public static void genrateInorder(TreeNode A, int B) {
        if (A == null) {
            return;
        }
        if (ans == Integer.MIN_VALUE) {
            genrateInorder(A.left, B);

        }
        count = count + 1;
        if (count == B) {
            ans = A.val;
            return;
        }
        if (ans == Integer.MIN_VALUE) {
            genrateInorder(A.right, B);
        }
    }

    public static int kthsmallest(TreeNode A, int B) {
        // ArrayList<Integer> ans = new ArrayList<>();
        // genrateInorderArrayList(A, ans);
        // System.out.println(ans);
        // return ans.get(B - 1);
        count = 0;
        ans = Integer.MIN_VALUE;
        genrateInorder(A, B);
        return ans;
    }

    public static void printTree(TreeNode A) {
        if (A == null) {
            return;
        }
        printTree(A.left);
        System.out.print(A.val + " ");
        printTree(A.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left = new TreeNode(1);
        System.out.println(kthsmallest(root, 1));
        // System.out.println("ANS: " + ans);
        // printTree(root);
    }
}
