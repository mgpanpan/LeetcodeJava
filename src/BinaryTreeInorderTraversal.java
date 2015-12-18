import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by pmg on 2015/12/18.
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 */

public class BinaryTreeInorderTraversal
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
     * @return: Inorder in ArrayList which contains node values.
     */
    // method 1, recursion
    /*
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> q = new ArrayList<Integer>();
        inorder(root, q);
        return q;
    }

    private static void inorder(TreeNode root, ArrayList<Integer> q) {
        if (root == null) return;
        inorder(root.left, q);
        q.add(root.val);
        inorder(root.right, q);
    }
    */

    // method2, non-recursive 类似BSTIterator中的method 2
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> q = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        pushLeftTrace(root, stack);

        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            q.add(currNode.val);
            pushLeftTrace(currNode.right, stack);
        }

        return q;
    }

    private static void pushLeftTrace(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
