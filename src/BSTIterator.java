import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by pmg on 2015/12/18.
 *
 * Design an iterator over a binary search tree with the following rules:
 *
 * Elements are visited in ascending order (i.e. an in-order traversal)
 * next() and hasNext() queries run in O(1) time in average.
 *
 * Example
 * For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]
 *
 *    10
 *  /    \
 * 1      11
 *  \       \
 *   6       12
 *
 * Challenge
 * Extra memory usage O(h), h is the height of the tree.
 *
 * Super Star: Extra memory usage O(1)
 *
 */

public class BSTIterator
{
    private class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    // method 1 : O(n) extra space, n is the number of nodes
    /*
    private LinkedList<TreeNode> q = new LinkedList<TreeNode>();

    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        q.offer(root);
        inorder(root.right);
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return !q.isEmpty();
    }

    //@return: return next node
    public TreeNode next() {
        return q.poll();
    }
*/
    // method 2 : O(h) extra space, h is the height of the tree
    private Stack<TreeNode> stack;
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        pushLeftTrace(root);
    }

    private void pushLeftTrace(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    //@return: return next node
    public TreeNode next() {
        TreeNode next = stack.pop();
        pushLeftTrace(next.right);
        return next;
    }

}
