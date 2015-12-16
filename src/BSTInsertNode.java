/**
 * Created by pmg on 2015/12/16.
 *
 * Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.
 *
 * Example
 * Given binary search tree as follow, after Insert node 6, the tree should be:
 *
 *   2             2
 *  / \           / \
 * 1   4   -->   1   4
 *    /             / \
 *   3             3   6
 *
 * Challenge
 * Can you do it without recursion?
 *
 */

public class BSTInsertNode
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
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public static TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) root = new TreeNode(node.val);
        else if (node.val < root.val) root.left = insertNode(root.left, node);
        else root.right = insertNode(root.right, node);
        return root;
    }
}
