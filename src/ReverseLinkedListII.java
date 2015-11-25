import java.util.Random;

/**
 * Created by pmg on 2015/11/24.
 *
 * Reverse a linked list from position m to n.
 *
 * Example
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 *
 * Note
 * Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 *
 * Challenge
 * Reverse it in-place and in one-pass
 *
 */

public class ReverseLinkedListII
{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public static ListNode reverseBetween(ListNode head, int m , int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pPre = dummy;
        ListNode p = pPre.next;
        ListNode headBak = null, p_next = null, p_next_next = null;
        int i = 1;
        while (p != null) {
            if (i < m) {
                pPre = pPre.next;
                p = p.next;
            }
            if (i == m) {
                headBak = p;
                p_next = p.next;
            }
            if (i >= m && i < n) {
                p_next_next = p_next.next;
                p_next.next = p;
                p = p_next;
                p_next = p_next_next;
            }
            else if (i == n) {
                pPre.next = p;
                headBak.next = p_next_next;
                return dummy.next;
            }
            i++;
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
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < N; i++)
            elems[i] = new ListNode(a[i]);
        ListNode lst1 = composeList(elems);
        show(lst1);
        ListNode result = reverseBetween(lst1, 2, 8);
        show(result);
    }
}
