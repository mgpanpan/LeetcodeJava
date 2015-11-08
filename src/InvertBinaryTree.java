/**
 * Created by pmg on 2015/11/8.
 */
public class InvertBinaryTree
{
    public static class TreeNode
    {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val)
        {
            this.val = val;
            this.left = this.right = null;
        }
    }
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public static void invertBinaryTree(TreeNode root) {
        root = invertSubTree(root);
    }

    private static TreeNode invertSubTree(TreeNode root) {
        if (root == null) return null;
        TreeNode rightInverted = invertSubTree(root.right);
        TreeNode leftInverted = invertSubTree(root.left);
        root.left = rightInverted;
        root.right = leftInverted;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        invertBinaryTree(root);
    }
}
