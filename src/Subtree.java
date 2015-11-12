/**
 * Created by pmg on 2015/11/12.
 */
public class Subtree
{
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public static boolean isSubtree(TreeNode T1, TreeNode T2) {
        return isSubtreeEqual(T1, T2) ||
                T1 != null && isSubtree(T1.left, T2) ||
                T1 != null && isSubtree(T1.right, T2);
    }

    private static boolean isSubtreeEqual(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 == null) return true;
        else if (T1 != null && T2 != null && T1.val == T2.val)
                return isSubtreeEqual(T1.left, T2.left) &&
                        isSubtreeEqual(T1.right, T2.right);
        else return false;
    }
}
