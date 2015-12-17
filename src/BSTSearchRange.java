import java.util.ArrayList;

/**
 * Created by pmg on 2015/12/17.
 *
 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in
 * range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.
 *
 * Example
 * If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
 *
 *     20
 *    /  \
 *   8   22
 *  / \
 * 4   12
 *
 */

public class BSTSearchRange
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
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public static ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        searchRange(root, k1, k2, list);
        return list;
    }

    private static void searchRange(TreeNode root, int k1, int k2, ArrayList<Integer> list) {
        if (root == null) return;
        if (root.val >= k1) searchRange(root.left, k1, k2, list);
        if (root.val >= k1 && root.val <= k2) list.add(root.val);
        if (root.val <= k2) searchRange(root.right, k1, k2, list);
    }
}
