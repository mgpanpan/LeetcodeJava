/**
 * Created by pmg on 2015/11/10.
 * Given an integer array, heapify it into a min-heap array.
 *
 * For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1]
 * is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 *
 * Example
 * Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.
 *
 * Challenge
 * O(n) time complexity
 *
 * Clarification
 *
 * What is heap?
 *
 * Heap is a data structure, which usually have three methods: push, pop and
 * top. where "push" add a new element the heap, "pop" delete the minimum/maximum
 * element in the heap, "top" return the minimum/maximum element.
 *
 * What is heapify?
 * Convert an unordered integer array into a heap array. If it is min-heap, for each
 * element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].
 *
 * What if there is a lot of solutions?
 * Return any of them.
 *
 * Solution : sink based.
 */

public class Heapify
{
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        for (int i = A.length/2; i >= 0; i--)
            sink(A, i);
    }

    private void sink(int[] A, int i) {
        int k;
        while ((k = i * 2 + 1) < A.length) {
            if (k < A.length - 1 && A[k+1] < A[k]) k++;
            if (A[k] < A[i]) { exch(A, i, k); i = k; }
            else break;
        }
    }
    private void exch(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
