import java.util.Random;

/**
 * Created by pmg on 2015/11/13.
 *
 * Reverse a linked list.
 *
 * Example
 * For linked list 1->2->3, the reversed linked list is 3->2->1
 *
 * Challenge
 * Reverse it in-place and in one-pass
 *
 */
public class ReverseLinkedList
{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public static ListNode reverse(ListNode head) {
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
        int N = 10;
        ListNode[] elems = new ListNode[N];
        Random r = new Random();
        for (int i = 0; i < N; i++)
            elems[i] = new ListNode(r.nextInt(10));
        ListNode lst1 = composeList(elems);
        show(lst1);
        ListNode lst_reversed = reverse(lst1);
        show(lst_reversed);
    }
}
