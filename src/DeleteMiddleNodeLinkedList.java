import java.util.Random;

/**
 * Created by pmg on 2015/11/16.
 * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 *
 * Have you met this question in a real interview? Yes
 * Example
 * Given 1->2->3->4, and node 3. return 1->2->4
 *
 */

public class DeleteMiddleNodeLinkedList
{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public static void deleteNode(ListNode node) {
        // copy the contents of the nodes , O(1) time
        // but fails when node is the last elements in the list.
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
