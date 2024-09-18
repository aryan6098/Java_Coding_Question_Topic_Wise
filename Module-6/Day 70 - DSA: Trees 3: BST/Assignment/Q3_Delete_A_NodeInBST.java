/*
 * Q3. Delete a node in BST
Problem Description
Given a Binary Search Tree(BST) A. If there is a node with value B present in the tree delete it and return the tree.

Note - If there are multiple options, always replace a node by its in-order predecessor


Problem Constraints
2 <= No. of nodes in BST <= 105
1 <= value of nodes <= 109
Each node has a unique value


Input Format
The first argument is the root node of a Binary Search Tree A.
The second argument is the value B.


Output Format
Delete the given node if found and return the root of the BST.


Example Input
Input 1:

            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     B = 10

Input 2:

            8
           / \
          6  21
         / \
        1   7

     B = 6



Example Output
Output 1:

            15
          /    \
        12      20
        / \    /  \
       8  14  16  27

Output 2:

            8
           / \
          1  21
           \
            7


Example Explanation
Explanation 1:

Node with value 10 is deleted 
Explanation 2:

Node with value 6 is deleted 
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
public class Q3_Delete_A_NodeInBST {

    public static int findMaxInLeftSideTree(TreeNode A) {
       
        TreeNode temp = A;
        while(temp.left != null) {
            temp = temp.left;
        }
        return temp.val;
    }

    public static TreeNode solve(TreeNode A, int B) {
        if(A == null) {
            return null;
        }
        if(A.val > B) {
            A.left = solve(A.left, B);
        }
        else if(A.val < B) {
            A.right = solve(A.right, B);
        }
        else {
            if(A.left == null || A.right == null){
                return null;
            } 
            if(A.left != null && A.right == null) {
                return A.left;
            }
            if(A.right != null && A.left == null) {
               return A.right;
            }
            else {
                int max = findMaxInLeftSideTree(A.left);
                System.out.println("max"+ max);
                A.val = max;
               A.left =  solve(A.left, max);
            }
        }
        return A;
    }

    public static void printTree(TreeNode A) {
        if(A == null) {
            return;
        }
        printTree(A.left);
        System.out.print(A.val+" ");
        printTree(A.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(21);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        solve(root, 6);
        printTree(root);
    }
    
}
