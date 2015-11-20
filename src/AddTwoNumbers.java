import java.util.Random;

/**
 * Created by pmg on 2015/11/12.
 * You have two numbers represented by a linked list, where each node contains
 * a single digit. The digits are stored in reverse order, such that the 1's
 * digit is at the head of the list. Write a function that adds the two numbers
 * and returns the sum as a linked list.
 *
 * Example
 * Given 7->1->6 + 5->9->2. That is, 617 + 295.
 *
 * Return 2->1->9. That is 912.
 *
 * Given 3->1->5 and 5->9->2, return 8->0->8.
 *
 */

public class AddTwoNumbers
{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public static ListNode addLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        int sum;
        while (l1 != null || l2 != null) {
            sum = 0;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }
            sum += carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
        }
        if (carry > 0) { p.next = new ListNode(carry); p = p.next; }
        p.next = null;
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
        int N = 4;
        ListNode[] elems = new ListNode[N];
        Random r = new Random();
        for (int i = 0; i < N; i++)
            elems[i] = new ListNode(r.nextInt(10));
        ListNode lst1 = composeList(elems);
        for (int i = 0; i < N; i++)
            elems[i] = new ListNode(r.nextInt(10));
        ListNode lst2 = composeList(elems);
        show(lst1);
        show(lst2);
        ListNode lst_sum = addLists(lst1, lst2);
        show(lst_sum);
    }
}
