import java.util.Random;

/**
 * Created by pmg on 2015/11/14.
 * Implement a function to check if a linked list is a palindrome.
 *
 * Example
 * Given 1->2->1, return true
 *
 * Challenge
 * Could you do it in O(n) time and O(1) space?
 *
 */

public class PalindromeLinkedList
{
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param head a ListNode
     * @return a boolean
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode middle = findMiddle(head);
        ListNode rightHalf = reverse(middle.next);
        ListNode p1 = head, p2 = rightHalf;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next; p2 = p2.next;
        }
        return true;
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
        int N = 3;
        ListNode[] elems = new ListNode[N];
        Random r = new Random();
        for (int i = 0; i < N; i++)
            elems[i] = new ListNode(r.nextInt(10));
        ListNode lst1 = composeList(elems);
        show(lst1);
        System.out.println(isPalindrome(lst1));
    }

}
