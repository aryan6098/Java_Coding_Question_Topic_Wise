/*
 * Q2. Binary Tree From Inorder And Postorder
Problem Description
Given the inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.


Problem Constraints
1 <= number of nodes <= 105

Input Format
First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.


Output Format
Return the root node of the binary tree.


Example Input
Input 1:

 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:

 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]


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

import java.lang.reflect.Array;
import java.util.ArrayList;
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

public class Q2_BinaryTreeFromInorderAndPostorder {

    /*
     * 
     * first method
     * Original Approach: Each call to getIndex takes O(n), leading to O(n2)
     * complexity in the worst case when building the tree.
     * 
     */
    public static int getIndex(int val, ArrayList<Integer> arrayList, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arrayList.get(i) == val) {
                return i;
            }
        }
        return -1;
    }

    public static TreeNode tree(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder, int start, int end, int pos) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder.get(pos));
        int rootIndex = getIndex(root.val, inOrder, start, end);
        root.right = tree(inOrder, postOrder, rootIndex + 1, end, pos - 1);
        root.left = tree(inOrder, postOrder, start, rootIndex - 1, pos - (end - rootIndex) - 1);
        return root;
    }

    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A == null || B == null || A.size() != B.size()) {
            return null;
        }
        return tree(A, B, 0, A.size() - 1, A.size() - 1);

    }

    // second method

    public static TreeNode treeFormation(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder, int start, int end,
            int pos, HashMap<Integer, Integer> hashMap) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder.get(pos));
        int rootIndex = hashMap.get(root.val);
        root.right = treeFormation(inOrder, postOrder, rootIndex + 1, end, pos - 1, hashMap);
        root.left = treeFormation(inOrder, postOrder, start, rootIndex - 1, pos - (end - rootIndex) - 1, hashMap);
        return root;
    }

    public static TreeNode buildTreeSecondMethod(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() != B.size() || A == null || B == null) {
            return null;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            hashMap.put(A.get(i), i);
        }

        return treeFormation(A, B, 0, A.size() - 1, A.size() - 1, hashMap);
    }

    public static TreeNode treeFormation(int[] inorder, int[] postorder, int start, int end, int pos, HashMap<Integer, Integer> hashMap) {
        if(start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pos]);
        int rootIndex = hashMap.get(root.val);
        root.right = treeFormation(inorder, postorder, rootIndex + 1, end, pos - 1, hashMap);
        root.left = treeFormation(inorder, postorder, start, rootIndex - 1, pos - (end - rootIndex) - 1, hashMap);
        return root;
    }

    public static TreeNode buildTreeArray(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length) {
            return null;
        }

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            hashmap.put(inorder[i], i);
        }
        return treeFormation(inorder, postorder, 0, inorder.length - 1, postorder.length - 1, hashmap);
            
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
        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrder.add(2);
        inOrder.add(1);
        inOrder.add(3);

        ArrayList<Integer> postOrder = new ArrayList<>();
        postOrder.add(2);
        postOrder.add(3);
        postOrder.add(1);

        // TreeNode root = buildTree(inOrder, postOrder);
        // TreeNode root = buildTreeSecondMethod(inOrder, postOrder);

        int[] inorder = {2, 1, 3};
        int[] postorder = {2, 3, 1};
        TreeNode root = buildTreeArray(inorder, postorder);
        printTree(root);
    }
}
