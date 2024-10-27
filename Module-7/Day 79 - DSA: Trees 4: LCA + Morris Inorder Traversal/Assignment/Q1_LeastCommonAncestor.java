/*
 * Q1. Least Common Ancestor
Problem Description

Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.


Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.




Problem Constraints

1 <= size of tree <= 100000

1 <= B, C <= 109



Input Format

First argument is head of tree A.

Second argument is integer B.

Third argument is integer C.



Output Format

Return the LCA.



Example Input

Input 1:

 
      1
     /  \
    2    3
B = 2
C = 3
Input 2:

      1
     /  \
    2    3
   / \
  4   5
B = 4
C = 5


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Explanation 1:

 LCA is 1.
Explanation 2:

 LCA is 2.
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

public class Q1_LeastCommonAncestor {

    public static boolean search(TreeNode A, int B, ArrayList<Integer> ans) {
        if (A == null) {
            return false;
        }
        if (A.val == B) {
            ans.add(A.val);
            return true;
        }
        if (search(A.left, B, ans) == true) {
            ans.add(A.val);
            return true;
        }
        if (search(A.right, B, ans) == true) {
            ans.add(A.val);
            return true;
        }
        return false;
    }

    public static void reverseList(ArrayList<Integer> A) {
        int i = 0;
        int j = A.size() - 1;
        while (i <= j) {
            int temp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, temp);
            i++;
            j--;

        }
    }
    public static int lca(TreeNode A, int B, int C) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        boolean foundB = search(A, B, list1);
        boolean foundC = search(A, C, list2);
        // If either B or C is not found in the tree, return -1 (or handle accordingly)
        if (!foundB || !foundC) {
            return -1; 
        }

        // Reverse the lists to get the paths from root to B and C
        int i = 0;
        reverseList(list1);
        reverseList(list2);

        while (i < list1.size() && i < list2.size() && list1.get(i).equals(list2.get(i))) {
            i++;
        }
        return list1.get(i - 1);
    }

    public static void printTree(TreeNode A) {
        if (A == null) {
            return;
        }
        printTree(A.left);
        printTree(A.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        // root.left.left = new TreeNode(-1);
        // root.left.right = new TreeNode(3);
        // root.right.left = new TreeNode(7);
        // root.right.right = new TreeNode(15);
        // root.right.left.right = new TreeNode(9);
        // root.right.left.left = new TreeNode(6);
       System.out.println(lca(root, 4, 5));
    }
}
