import java.util.Random;

/**
 * Created by pmg on 2015/11/8.
 * Remove all elements from a linked list of integers that have value val.
 * Example
 *   Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
 */

public class RemoveLinkedListElements
{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (head != null) {
            if (head.val == val) p.next = head.next;
            else p = p.next;
            head = head.next;
        }
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
        int N = 10;
        ListNode[] elems = new ListNode[N];
        Random r = new Random();
        for (int i = 0; i < N; i++)
            elems[i] = new ListNode(r.nextInt(10));
        ListNode lst = composeList(elems);
        show(lst);
        ListNode lst2 = removeElements(lst, 5);
        show(lst2);
    }

}
