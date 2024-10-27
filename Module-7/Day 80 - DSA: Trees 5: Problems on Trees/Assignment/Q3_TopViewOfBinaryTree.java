/*
 * Q3. Top View of Binary tree
Problem Description

Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.





The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.

Return the nodes in any order.




Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format

First and only argument is head of the binary tree A.



Output Format

Return an array, representing the top view of the binary tree.



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

 [1, 2, 4, 8, 3, 7]
Output 2:

 [1, 2, 3]


Example Explanation

Explanation 1:

Top view is described.
Explanation 2:

Top view is described.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

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

class NodeInfo {
    TreeNode node;
    int vertical;

    NodeInfo(TreeNode node, int vertical) {
        this.node = node;
        this.vertical = vertical;
    }
}
public class Q3_TopViewOfBinaryTree {
    
    public static ArrayList<Integer> topView(TreeNode A) {
        if(A == null){
            return new ArrayList<>();
        }
        TreeMap<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(A, 0));
        while (!queue.isEmpty()) {
            NodeInfo curInfo = queue.poll();
            TreeNode currNode = curInfo.node;
            int vertical = curInfo.vertical;

            if(!topViewMap.containsKey(vertical)) {
                topViewMap.put(vertical, currNode.val);
            }
            if(currNode.right != null) {
                queue.add(new NodeInfo(currNode.right, vertical + 1));
            }
            if(currNode.left != null ) {
                queue.add(new NodeInfo(currNode.left, vertical - 1));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(Integer key : topViewMap.values()){
           result.add(key)
        }
        return result;
    }
    public static void main(String[] args) {
        Q3_TopViewOfBinaryTree obj = new Q3_TopViewOfBinaryTree();
        TreeNode root1 = new TreeNode(6);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(9);

        ArrayList<Integer> topViewResult1 = obj.topView(root1);
        System.out.println("Top View Example 1: " + topViewResult1);
        
    }
}
