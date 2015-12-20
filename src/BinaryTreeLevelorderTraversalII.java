import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by pmg on 2015/12/20.
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * Example
 * Given binary tree {3,9,20,#,#,15,7},
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its bottom-up level order traversal as:
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 */

public class BinaryTreeLevelorderTraversalII
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
     * @return: buttom-up level order a list of lists of integer
     */

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Stack<ArrayList<Integer>> tmp = new Stack<ArrayList<Integer>>();

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        if (root == null) return result;
        q.offer(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            tmp.push(level);
        }

        while (!tmp.isEmpty())
            result.add(tmp.pop());

        return result;
    }
}
