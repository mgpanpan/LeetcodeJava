import java.util.Random;

/**
 * Created by pmg on 2015/11/25.
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * Example
 *
 * Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
 *
 */

public class ReorderList
{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public static void reorderList(ListNode head) {
        if (head == null) return;
        ListNode middle = findMiddle(head);
        ListNode rightHalf = reverse(middle.next);
        middle.next = null;
        while (head != null && rightHalf != null) {
            ListNode tmp1 = head.next;
            head.next = rightHalf;
            ListNode tmp2 = rightHalf.next;
            rightHalf.next = tmp1;
            rightHalf = tmp2;
            head = tmp1;
        }
    }

    /**
     *
     * @param head
     * @return middle points to index (N - 1) / 2, index starts from zero
     */
    private static ListNode findMiddle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    private static ListNode reverse(ListNode head) {
        ListNode p = head;
        if (p == null) return null;
        ListNode p_next = p.next;
        p.next = null;
        while (p_next != null) {
            ListNode p_next_next = p_next.next;
            p_next.next = p;
            p = p_next;
            p_next = p_next_next;
        }
        return p;
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
        int N = 9;
        ListNode[] elems = new ListNode[N];
        Random r = new Random();
        for (int i = 0; i < N; i++)
            elems[i] = new ListNode(r.nextInt(10));
        ListNode lst1 = composeList(elems);
        show(lst1);
        reorderList(lst1);
        show(lst1);
    }
}
