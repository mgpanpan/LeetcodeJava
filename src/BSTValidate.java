/**
 * Created by pmg on 2015/12/17.
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 */

public class BSTValidate
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
     * @return: True if the binary tree is BST, or false
     */
    // ======== method1
    // public static boolean isValidBST(TreeNode root) {
    //     if (root == null) return true;
    //     if (root.left == null && root.right == null) return true;
    //     else if (root.left == null)
    //         return root.val < minTree(root.right) && isValidBST(root.right);
    //     else if (root.right == null)
    //         return root.val > maxTree(root.left) && isValidBST(root.left);
    //     else
    //         return root.val > maxTree(root.left) && root.val < minTree(root.right) &&
    //                 isValidBST(root.left) && isValidBST(root.right);
    // }
    //
    // // assume root is not null
    // private static int minTree(TreeNode root) {
    //     if (root.left == null) return root.val;
    //     else return minTree(root.left);
    // }
    //
    // // assume root is not null
    // private static int maxTree(TreeNode root) {
    //     if (root.right == null) return root.val;
    //     else return maxTree(root.right);
    // }

    // ======== method2
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isValidBST(TreeNode root, int thresholdLow, int thresholdHigh) {
        if (root == null) return true;
        // 注意corner case： 节点的值为Integer.MIN_VALUE或Integer.MAX_VALUE时
        return (root.val > thresholdLow && root.val < thresholdHigh || root.val == Integer.MIN_VALUE || root.val == Integer.MAX_VALUE) &&
                isValidBST(root.left, thresholdLow, root.val) && isValidBST(root.right, root.val, thresholdHigh);
    }
}
