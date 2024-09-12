
/*
 * Q4. Right View of Binary tree
Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an array, representing the right view of the binary tree.



Example Input
Input 1:

 
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 
Input 2:

 
            1
           /  \
          2    3
           \
            4
             \
              5


Example Output
Output 1:

 [1, 3, 7, 8]
Output 2:

 [1, 3, 4, 5]


Example Explanation
Explanation 1:

Right view is described.
Explanation 2:

Right view is described.

 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class Q4_RightViewOfBinaryTree {

    // first Method
    public static ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> rightVewResult = new ArrayList<>();
        queue.add(A);
        TreeNode node;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == levelSize - 1) {
                    rightVewResult.add(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return rightVewResult;
    }

    // second method
    public static ArrayList<Integer> solve1(TreeNode A) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(A == null){
            return arrayList;
        }
        queue.add(A);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode cuTreeNode = queue.peek();
            if(cuTreeNode != null) {
                arrayList.add(cuTreeNode.val);
                while (queue.peek() != null) {
                    if(cuTreeNode.right != null) {
                        queue.add(cuTreeNode.right);
                    }
                    if(cuTreeNode.left != null){
                        queue.add(cuTreeNode.left);
                    }
                    queue.remove();
                    cuTreeNode = queue.peek();
                }
                queue.add(null);
            }
            queue.remove();
        }
        return arrayList;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(6);
        System.out.println(solve1(node));
    }
}
