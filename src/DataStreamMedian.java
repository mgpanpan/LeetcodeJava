import java.util.PriorityQueue;

/**
 * Created by pmg on 2015/11/11.
 *
 * Numbers keep coming, return the median of numbers at every time a new number added.
 *
 * Example
 * For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].
 *
 * For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].
 *
 * For numbers coming list: [2, 20, 100], return [2, 2, 20].
 *
 * Challenge
 * Total run time in O(nlogn).
 *
 * Clarification
 * What's the definition of Median? - Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.
 *
 */
public class DataStreamMedian
{
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public static int[] medianII(int[] nums) {
        int[] result = new int[nums.length];
        if (nums.length == 0) return result;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        maxHeap.offer(-nums[0]);
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // step1
            if (nums[i] < -maxHeap.peek()) maxHeap.offer(-nums[i]);
            else minHeap.offer(nums[i]);

            // step2
            if (maxHeap.size() - minHeap.size() > 1) minHeap.offer(-maxHeap.poll());
            else if (minHeap.size() - maxHeap.size() > 1) maxHeap.offer(-minHeap.poll());

            // set the value
            if (minHeap.size() == maxHeap.size())
                result[i] = Math.min(minHeap.peek(), -maxHeap.peek());
            else if (minHeap.size() > maxHeap.size())
                result[i] = minHeap.peek();
            else if (minHeap.size() < maxHeap.size())
                result[i] = -maxHeap.peek();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 1, 3, 2, 6, 0};
        int[] result = medianII(nums);
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }


}
