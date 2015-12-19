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

    // method 2
    /*
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> q = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) return q;
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {  // traversal down
                if (curr.left != null)
                    stack.push(curr.left);
                else if (curr.right != null)
                    stack.push(curr.right);
                else {  // a leaf node
                    q.add(stack.pop().val);
                }
            } else if (prev == curr.left) {  // traversal up from left
                if (curr.right != null) stack.push(curr.right);
                else q.add(stack.pop().val);
            } else if (prev == curr.right) {  // traversal up from right
                q.add(stack.pop().val);
            }
            prev = curr;
        }

        return q;
    }
*/

    // method 3, using two stacks
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> q = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> reversed = new Stack<Integer>();

        if (root == null) return q;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            reversed.push(curr.val);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }

        while (!reversed.isEmpty())
            q.add(reversed.pop());

        return q;
    }


}
