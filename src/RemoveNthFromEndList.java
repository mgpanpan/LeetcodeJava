import java.util.Random;

/**
 * Created by pmg on 2015/11/14.
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * Example
 * Given linked list: 1->2->3->4->5->null, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5->null.
 *
 * Note
 * The minimum number of nodes in list is n.
 *
 * Challenge
 * O(n) time
 *
 */

public class RemoveNthFromEndList
{
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        int count = 0;
        while (fast != null) {
            if (count >= n)
                slow = slow.next;
            fast = fast.next;
            count++;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    private static ListNode composeList(ListNode[] elems)
    {
        for (int i = 0; i < elems.length - 1; i++)
            elems[i].next = elems[i+1];
        return elems[0];
    }

    private static void show(ListNode lst)
    {
        for (; lst != null; lst = lst.next)
            System.out.print(lst.val + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int N = 1;
        ListNode[] elems = new ListNode[N];
        Random r = new Random();
        for (int i = 0; i < N; i++)
            elems[i] = new ListNode(r.nextInt(10));
        ListNode lst1 = composeList(elems);
        show(lst1);
        show(removeNthFromEnd(lst1, 1));
    }
}
