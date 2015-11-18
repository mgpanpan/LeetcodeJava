import java.util.Random;

/**
 * Created by pmg on 2015/11/18.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */

public class RemoveDuplicatesSortedList
{
    private static class ListNode
    {
        Comparable val;
        ListNode next;
        ListNode(Comparable val)
        {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * @param head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            ListNode x = p.next;
            while (x != null && x.val == p.val) x = x.next;
            p.next = x;
            p = p.next;
        }
        return head;
    }

}
