
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class HeightOfTree {

    public static int findHeight(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int leftHeight = findHeight(A.left);
        int rightHeight = findHeight(A.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        System.out.println(findHeight(root));
    }
}
