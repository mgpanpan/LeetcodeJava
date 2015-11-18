/**
 * Created by pmg on 2015/11/18.
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 */

public class RemoveDuplicatesSortedListII
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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        boolean duplicate = false;

        while (p.next != null) {
            ListNode x = p.next.next;
            while (x != null && x.val == p.next.val) {
                x = x.next;
                duplicate = true;
            }
            if (duplicate) p.next = x;
            else p = p.next;
            duplicate = false;    // reset
        }

        return dummy.next;
    }

}
