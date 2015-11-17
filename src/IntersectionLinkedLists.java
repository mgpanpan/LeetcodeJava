import java.util.Random;

/**
 * Created by pmg on 2015/11/17.
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * Example
 * The following two linked lists:
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 *
 * begin to intersect at node c1.
 *
 * Note
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 *
 * Challenge
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * jiuzhang 参考答案是通过将这两个链表相连，再检测环实现的
 */

public class IntersectionLinkedLists
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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = lengthOfList(headA);
        int lB = lengthOfList(headB);

        // 使headA总是指向两者间较长的
        if (lA < lB) { ListNode tmp = headA; headA = headB; headB = tmp; }
        for (int i = 0; i < Math.abs(lA - lB); i++)
            headA = headA.next;

        boolean flag = false;    // flag to indicate whether find a
        ListNode intersection = null;
        while (headA != null && headB != null) {
            if (headA == headB && !flag) {
                intersection = headA;
                flag = true;
            } else if (headA != headB) {
                intersection = null;
                flag = false;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return intersection;
    }

    private static int lengthOfList(ListNode head) {
        int cnt = 0;
        for (; head != null; head = head.next, cnt++) ;
        return cnt;
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

    public static void main(String[] args)
    {
        int N = 10;
        ListNode[] elems = new ListNode[N];
        Random r = new Random();
        for (int i = 0; i < N; i++)
            elems[i] = new ListNode(r.nextInt(10));
        ListNode lst = composeList(elems);
        show(lst);
        ListNode lst2 = new ListNode(10);
        lst2.next = lst;
        show((getIntersectionNode(lst, lst2)));
    }
}
