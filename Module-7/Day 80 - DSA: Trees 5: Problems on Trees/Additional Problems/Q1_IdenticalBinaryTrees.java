/*
 * Q1. Identical Binary Trees

 */

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

public class Q1_IdenticalBinaryTrees {

    public static int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if (B == null || A == null) {
            return 0;
        }
        if (A.val != B.val) {
            return 0;
        }
        if (A == B) {
            return 1;
        }
       
         int leftCheck = isSameTree(A.left, B.left);
         int rightCheck = isSameTree(A.right, B.right);
         return leftCheck & rightCheck;
    }

    public static void main(String[] args) {

    TreeNode A = new TreeNode(1);
    A.left = new TreeNode(2);
    A.right = new TreeNode(3);
    
    TreeNode B = new TreeNode(1);
    B.left = new TreeNode(2);
    B.right = new TreeNode(3);
    
    // Check if trees A and B are identical
    int result = isSameTree(A, B);
    System.out.println(result); 

    }
}
