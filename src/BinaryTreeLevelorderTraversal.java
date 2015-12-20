import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pmg on 2015/12/19.
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
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
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * Challenge
 * Challenge 1: Using only 1 queue to implement it.
 * Challenge 2: Use DFS algorithm to do it.
 *
 */

public class BinaryTreeLevelorderTraversal
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
     * @return: Level order a list of lists of integer
     */
    // method 1, bfs
    /*
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int level = 0;
        ArrayList<Integer> nextLevelNodeCnt = new ArrayList<Integer>();    // nodes number in *next* level
        int cnt = 0;

        if (root == null) return result;

        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        result.add(new ArrayList<Integer>());
        nextLevelNodeCnt.add(1);
        nextLevelNodeCnt.add(0);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (result.size() == level) result.add(new ArrayList<Integer>());
            result.get(level).add(curr.val);
            cnt++;
            if (curr.left != null)  { q.offer(curr.left); nextLevelNodeCnt.set(level+1, nextLevelNodeCnt.get(level+1)+1); }
            if (curr.right != null) { q.offer(curr.right); nextLevelNodeCnt.set(level+1, nextLevelNodeCnt.get(level+1)+1); }
            if (cnt == nextLevelNodeCnt.get(level)) {
                cnt = 0;
                level++;

                nextLevelNodeCnt.add(0);
            }
        }

        return result;
    }
    */

    // method 1, bfs, 和上面的解法同样的思想，简化了代码
    /*
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
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
            result.add(level);
        }

        return result;
    }
*/
    // method 2, dfs
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int height = height(root);

        for (int i = 0; i < height; i++)
            result.add(new ArrayList<Integer>());

        dfs(root, 0, height, result);

        return result;
    }

    private static void dfs(TreeNode root, int levelNumber, int height, ArrayList<ArrayList<Integer>> result) {
        if (root == null || levelNumber > height) return;
        result.get(levelNumber).add(root.val);
        dfs(root.left, levelNumber + 1, height, result);
        dfs(root.right, levelNumber + 1, height, result);
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
