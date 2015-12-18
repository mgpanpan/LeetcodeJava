import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by pmg on 2015/12/18.
 */
public class BinaryTreePostorderTraversal
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
     * @return: Postorder in ArrayList which contains node values.
     */
    /*
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> q = new ArrayList<Integer>();
        postorder(root, q);
        return q;
    }

    private static void postorder(TreeNode root, ArrayList<Integer> q) {
        if (root == null) return;
        postorder(root.left, q);
        postorder(root.right, q);
        q.add(root.val);
    }
*/

    // method 2, non-recursion not pass!!

    /*
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> q = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) return q;
        stack.push(root);
        if (root.right != null) stack.push(root.right);
        if (root.left != null) stack.push(root.left);
        while (!stack.isEmpty()) {
            TreeNode tn
        }

        return q;
    }
     */

}
