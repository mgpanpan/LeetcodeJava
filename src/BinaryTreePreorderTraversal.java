import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by pmg on 2015/12/18.
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */
public class BinaryTreePreorderTraversal
{
    private static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    /*
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> q = new ArrayList<Integer>();
        preorder(root, q);
        return q;
    }

    private static void preorder(TreeNode root, ArrayList<Integer> q) {
        if (root == null) return;
        q.add(root.val);
        preorder(root.left, q);
        preorder(root.right, q);
    }
    */

    // method 2, non-recursive
    /*
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> q = new ArrayList<Integer>();
        Stack<TreeNode> rightPart = new Stack<TreeNode>();

        leftTraversal(root, q, rightPart);
        while (!rightPart.isEmpty()) {
            TreeNode tn = rightPart.pop();
            leftTraversal(tn, q, rightPart);
        }

        return q;
    }

    private static void leftTraversal(TreeNode root, ArrayList<Integer> q, Stack<TreeNode> rightPart) {
        while (root != null) {
            q.add(root.val);
            rightPart.push(root.right);
            root = root.left;
        }
    }
*/
    // method3 non-recursive 比method 2 更直观
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> q = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) return q;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            q.add(curr.val);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }

        return q;
    }

}
