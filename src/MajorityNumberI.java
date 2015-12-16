import java.util.ArrayList;

/**
 * Created by pmg on 2015/12/14.
 * Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.
 *
 * Example
 * Given [1, 1, 1, 1, 2, 2, 2], return 1
 *
 * Challenge
 * O(n) time and O(1) extra space
 *
 */

public class MajorityNumberI
{
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int majIdx = 0, count = 1;
        for (int i = 1; i < nums.size(); i++)
            if (count == 0) {
                majIdx = i;
                count = 1;
            }
            else if (nums.get(i).equals(nums.get(majIdx)))
                count++;
            else count--;
        // the question does not specify the output when majority number not exists,
        // so simply return it.
        return nums.get(majIdx);
    }
}
