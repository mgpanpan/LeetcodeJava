/**
 * Created by pmg on 2015/11/12.
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2->null and x = 3,
 * return 1->2->2->4->3->5->null.
 *
 */

import java.util.Random;

public class PartitionList
{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode lessNodes = new ListNode(-1);
        ListNode largerNodes = new ListNode(-1);
        ListNode l1 = lessNodes, l2 = largerNodes;
        while (head != null) {
            if (head.val <= x) {
                l1.next = head;
                l1 = l1.next;
            } else {
                l2.next = head;
                l2 = l2.next;
            }
            head = head.next;
        }
        l2.next = null;
        l1.next = largerNodes.next;
        return lessNodes.next;
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
        ListNode lst2 = partition(lst, 5);
        show(lst2);
    }
}
