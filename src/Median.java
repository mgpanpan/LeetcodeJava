/**
 * Created by pmg on 2015/11/11.
 * Given a unsorted array with integers, find the median of it.
 * A median is the middle number of the array after it is sorted.
 * If there are even numbers in the array, return the N/2-th number after sorted.
 *
 * Example
 *  Given [4, 5, 1, 2, 3], return 3
 *  Given [7, 9, 4, 5], return 5
 *
 * Challenge
 *   O(n) time.
 */

public class Median
{
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public static int median(int[] nums) {
        int mIndex = (nums.length - 1) / 2;
        int lo = 0, hi = nums.length - 1;
        while (true) {
            int k = partition(nums, lo, hi);
            if (mIndex < k) hi = k - 1;
            else if (mIndex > k) lo = k + 1;
            else return nums[k];
        }
    }

    private static int partition(int[] nums, int lo, int hi) {
        int i = lo + 1, j = i;
        int val = nums[lo];
        for (; j <= hi; j++)
            if (nums[j] < val) exch(nums, i++, j);
        exch(nums, --i, lo);
        return i;
    }

    private static void exch(int[] nums, int i, int j) {
        int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 3, 2};
        int[] b = {7, 9, 4, 5};
        System.out.println(Median.median(a));
        System.out.println(Median.median(b));
    }
}
