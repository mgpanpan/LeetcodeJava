import java.util.Random;

/**
 * Created by pmg on 2015/11/12.
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Challenge
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 */
public class SwapNodesInPairs
{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode p = head;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (p != null && p.next != null) {
            ListNode tmp = p.next.next;
            pre.next = p.next;
            pre.next.next = p;
            p = tmp;
            pre = pre.next.next;
        }
        pre.next = p;
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
        int N = 9;
        ListNode[] elems = new ListNode[N];
        Random r = new Random();
        for (int i = 0; i < N; i++)
            elems[i] = new ListNode(r.nextInt(10));
        ListNode lst = composeList(elems);
        show(lst);
        ListNode lst2 = swapPairs(lst);
        show(lst2);
    }
}

