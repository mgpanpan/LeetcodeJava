/**
 * Created by pmg on 2015/12/16.
 *
 * Given a root of Binary Search Tree with unique value for each node.  Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.
 *
 * Example
 * Given binary search tree:
 *
 *           5
 *
 *        /    \
 *
 *     3          6
 *
 *  /    \
 *
 * 2       4
 *
 * Remove 3, you can either return:
 *
 *           5
 *
 *        /    \
 *
 *     2          6
 *
 *       \
 *
 *          4
 *
 * or :
 *
 *           5
 *
 *        /    \
 *
 *     4          6
 *
 *  /
 *
 * 2
 *
 */

public class BSTRemoveNode
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
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public static TreeNode removeNode(TreeNode root, int value) {
        if (root == null) return null;
        if (value < root.val) root.left = removeNode(root.left, value);
        else if (value > root.val) root.right = removeNode(root.right, value);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode newRoot = new TreeNode(treeMin(root.right));
            newRoot.left = root.left;
            newRoot.right = removeMin(root.right);
            root = newRoot;
        }
        return root;
    }

    // assume : root is not null
    private static int treeMin(TreeNode root) {
        if (root.left == null) return root.val;
        else return treeMin(root.left);
    }

    private static TreeNode removeMin(TreeNode root) {
        if (root == null) return null;
        if (root.left == null) return root.right;
        else root.left = removeMin(root.left);
        return root;
    }
}
