/*
 * Q3. Path Sum
Problem Description
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.



Problem Constraints
1 <= number of nodes <= 105

-100000 <= B, value of nodes <= 100000



Input Format
First argument is a root node of the binary tree, A.

Second argument is an integer B denoting the sum.



Output Format
Return 1, if there exist root-to-leaf path such that adding up all the values along the path equals the given sum. Else, return 0.



Example Input
Input 1:

 Tree:    5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1

 B = 22
Input 2:

 Tree:    5
         / \
        4   8
       /   / \
     -11 -13  4

 B = -1


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
Explanation 2:

 There is no path which has sum -1.

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

public class Q3_PathSum {

    public static int hasPathSum(TreeNode A, int B) {
        if(A == null) {
            return 0;  // If node is null, no path exists
        }

        B = B - A.val; // Subtract the current node's value from the target sum

        // If we reach a leaf node, check if the remaining sum is 0
        if(A.left == null && A.right == null) {
            return B == 0 ? 1 : 0;  // Return 1 if sum is 0, otherwise return 0
        }

        // Recursively check left and right subtrees and return 1 if either has a valid path
        if(hasPathSum(A.left, B) == 1 || hasPathSum(A.right, B) == 1) {
            return 1;
        }
        return 0;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(root, 22));   // Expected output: 1
    }
}
