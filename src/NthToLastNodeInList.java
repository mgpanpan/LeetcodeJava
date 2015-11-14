import java.util.Random;

/**
 * Created by pmg on 2015/11/14.
 *
 * Find the nth to last element of a singly linked list.
 *
 * The minimum number of nodes in list is n.
 *
 * Example
 * Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
 *
 */
public class NthToLastNodeInList
{
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list.
     */
    public static ListNode nthToLast(ListNode head, int n) {
        ListNode fast = head, slow = head;
        int count = 0;
        while (fast != null) {
            if (count >= n)
                slow = slow.next;
            fast = fast.next;
            count++;
        }
        return slow;
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
        System.out.println(nthToLast(lst1, 2).val);
    }

}
