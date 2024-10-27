/*
 * Q2. Vertical Order traversal

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
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
    int depth;

    NodeInfo(TreeNode node, int vertical, int depth) {
        this.node = node;
        this.vertical = vertical;
        this.depth = depth;
    }
}

public class Q2_VerticalOrderTraversal {
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        if(A == null) {
            return new ArrayList<>();
        }
        TreeMap<Integer, ArrayList<Integer>> verticalMap = new TreeMap<>();
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(A, 0, 0));
        while (!queue.isEmpty()) {
            NodeInfo curInfo = queue.poll();
            TreeNode currNode = curInfo.node;
            int vertical = curInfo.vertical;
            int depth = curInfo.depth;
            if(!verticalMap.containsKey(vertical)){
                verticalMap.put(vertical, new ArrayList<>());
            }
            verticalMap.get(vertical).add(currNode.val);
            if(currNode.left != null) {
                queue.add(new NodeInfo(currNode.left, vertical - 1, depth + 1));
            }
            if(currNode.right != null) {
                queue.add(new NodeInfo(currNode.right, vertical + 1, depth + 1));
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry: verticalMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;

    }

    public static void main(String[] args) {
        Q2_VerticalOrderTraversal solution = new Q2_VerticalOrderTraversal();

        TreeNode root1 = new TreeNode(6);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(9);
        ArrayList<ArrayList<Integer>> result1 = solution.verticalOrderTraversal(root1);
        System.out.println("Example 1: " + result1);

    }
}
