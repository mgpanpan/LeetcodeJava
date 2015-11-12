/**
 * Created by pmg on 2015/11/12.
 *
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 *
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 *
 * Example
 * If nums = [3,2,2,1] and k=2, a valid answer is 1.
 *
 * Note
 * You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
 *
 * If all elements in nums are smaller than k, then return nums.length
 *
 * Challenge
 * Can you partition the array in-place and in O(n)?
 *
 */
public class PartitionArray
{
    /**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public static int partitionArray(int[] nums, int k) {
        int i = 0;
        for (int j = 0; j < nums.length; j++)
            if (nums[j] < k) exch(nums, i++, j);
        return i;
    }

    private static void exch(int[] nums, int i, int j) {
        int tmp; tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 1};
        System.out.println(partitionArray(nums, 2));
    }
}
