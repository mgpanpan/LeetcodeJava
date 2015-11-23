/**
 * Created by pmg on 2015/11/23.
 * Given a linked list, determine if it has a cycle in it.
 *
 * Example
 * Given -21->10->4->5, tail connects to node index 1, return true
 *
 * Challenge
 * Follow up:
 * Can you solve it without using extra space?
 *
 */

public class LinkedListCycle
{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
