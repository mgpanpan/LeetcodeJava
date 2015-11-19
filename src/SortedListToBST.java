/**
 * Created by pmg on 2015/11/18.
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * Example
 *                2
 * 1->2->3  =>   / \
 *              1   3
 *
 */

public class SortedListToBST
{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    // method 1 : O(nlgn)
    // /**
    //  * @param head: The first node of linked list.
    //  * @return: a tree node
    //  */
    // public static TreeNode sortedListToBST(ListNode head) {
    //     if (head == null) return null;
    //     if (head.next == null) return new TreeNode(head.val);
    //     ListNode middle = findMiddle(head);
    //     TreeNode root = new TreeNode(middle.next.val);
    //     ListNode right = middle.next.next;
    //     middle.next = null;
    //     root.left = sortedListToBST(head);
    //     root.right = sortedListToBST(right);
    //     return root;
    // }
//
    // /**
    //  *
    //  * @param head
    //  * @return middle points to index N / 2 - 1
    //  * index start from 0
    //  * assume the length of the input list is at least 2.
    //  */
    // private static ListNode findMiddle(ListNode head) {
    //     if (head == null) return null;
    //     ListNode dummy = new ListNode(-1);
    //     dummy.next = head;
    //     ListNode fast = head, slow = dummy;
    //     while (fast != null && fast.next != null) {
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     return slow;
    // }

    // method 2 O(n)
    private static ListNode current;

    private static int lengthOfList(ListNode head) {
        int cnt = 0;
        for (; head != null; head = head.next, cnt++) ;
        return cnt;
    }

    public static TreeNode sortedListToBST(ListNode head) {
        current = head;
        int length = lengthOfList(head);
        return sortedListToBSTHelper(length);
    }

    private static TreeNode sortedListToBSTHelper(int length) {
        if (length <= 0) return null;
        TreeNode left = sortedListToBSTHelper(length / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(length - length / 2 - 1);
        root.left = left;
        root.right = right;
        return root;
    }

}
