import java.util.PriorityQueue;

/**
 * Created by pmg on 2015/11/12.
 * Find the kth smallest number in at row and column sorted matrix.
 * Example
 *  Given k = 4 and a matrix:
 *
 *  [
 *    [1 ,5 ,7],
 *    [3 ,7 ,8],
 *    [4 ,8 ,9],
 *  ]
 *
 *  return 5
 *
 *  Challenge
 *    O(k log n), n is the maximal number in width and height
 */

public class KthSmallestInSortedMatrix
{
    public static class Cell implements Comparable<Cell>
    {
        int row;
        int col;
        int val;
        public Cell(int row, int col, int val) {
            this.row = row; this.col = col; this.val = val;
        }

        public int compareTo(Cell that) {
            return this.val - that.val;
        }
    }

    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int h = matrix.length, w = matrix[0].length;
        if (k < 1 || k > w * h) return 0;
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
        for (int i = 0; i < h; i++)
            pq.offer(new Cell(i, 0, matrix[i][0]));
        for (int j = 0; j < k-1; j++) {
            Cell currentMin = pq.poll();
            if (currentMin.col < w-1)
                pq.offer(new Cell(currentMin.row,
                                  currentMin.col+1,
                                  matrix[currentMin.row][currentMin.col+1]));
        }
        return pq.peek().val;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 3, 5}, {2, 4, 6}, {7, 8, 9}};
        System.out.println(kthSmallest(mat, 5));
    }
}
