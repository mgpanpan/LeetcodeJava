import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by pmg on 2015/11/22.
 *
 * Merge k sorted linked lists and return it as one sorted list.
 *
 * Analyze and describe its complexity.
 *
 * Example
 * Given lists:
 *
 * [
 *   2->4->null,
 *   null,
 *   -1->null
 * ],
 * return -1->2->4->null.
 *
 */
public class MergekSortedList
{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    // method 1 : up to down divide-and-conquer
    /*
    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty()) return null;
        return mergeKListsHelper(lists, 0, lists.size() - 1);
    }

    private static ListNode mergeKListsHelper(List<ListNode> lists, int lo, int hi) {
        if (hi == lo) return lists.get(lo);
        else if (hi - lo == 1) return mergeTwoLists(lists.get(lo), lists.get(lo + 1));
        else {
            int mid = lo + (hi - lo) / 2;
            ListNode left = mergeKListsHelper(lists, lo, mid);
            ListNode right = mergeKListsHelper(lists, mid+1, hi);
            return mergeTwoLists(left, right);
        }
    }

*/
    // method 2 : bottom to up divide-and-conquer
    /*
    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty()) return null;
        while (lists.size() > 1) {
            List<ListNode> tmp = new ArrayList<ListNode>();
            for (int i = 0; i < lists.size(); i += 2)
                if (i + 1 < lists.size()) tmp.add(mergeTwoLists(lists.get(i), lists.get(i + 1)));
                else tmp.add(lists.get(i));
            lists = tmp;
        }
        return lists.get(0);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode pointer = new ListNode(0);
        ListNode p = pointer;
        for (; l1 != null && l2 != null; p = p.next)
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
        p.next = (l1 == null) ? l2 : l1;
        return pointer.next;
    }
*/
    // method 3 : using a priority queue

    private static class Cell implements Comparable<Cell>
    {
        int row;
        int val;
        public Cell(int row, int val) {
            this.row = row; this.val = val;
        }

        public int compareTo(Cell that) {
            return this.val - that.val;
        }
    }

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty()) return null;
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(lists.size());

        for (int i = 0; i < lists.size(); i++)
            if (lists.get(i) != null)
                pq.offer(new Cell(i, lists.get(i).val));

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            Cell min = pq.poll();
            p.next = lists.get(min.row);
            p = p.next;
            lists.set(min.row, lists.get(min.row).next);
            if (lists.get(min.row) != null) pq.offer(new Cell(min.row, lists.get(min.row).val));
        }
        return dummy.next;
    }
}
