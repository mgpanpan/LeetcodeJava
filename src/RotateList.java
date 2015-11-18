import java.util.Random;

/**
 * Created by pmg on 2015/11/17.
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example
 * Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.
 *
 */

public class RotateList
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int cnt = 0;
        ListNode p = head;
        for (; p.next != null; p = p.next, cnt++) ;
        cnt++;
        p.next = head;
        k = cnt - k % cnt;

        p = head;
        for (int i = 0; i < k - 1; i++)
            p = p.next;
        ListNode result = p.next;
        p.next = null;

        return result;
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
        show(rotateRight(lst1, 9));
    }
}
