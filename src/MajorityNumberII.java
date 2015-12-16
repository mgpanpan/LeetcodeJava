import java.util.ArrayList;

/**
 * Created by pmg on 2015/12/16.
 *
 * Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.
 * Find it.
 *
 * Example
 * Given [1, 2, 1, 2, 1, 3, 3], return 1.
 *
 * Note
 * There is only one majority number in the array. （假设输入数组满足此条件）
 *
 * Challenge
 * O(n) time and O(1) extra space.
 *
 */
public class MajorityNumberII
{
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int candidate1 = 0, candidate2 = 0;
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums)
            if (candidate1 == num) {
                cnt1++;
            } else if (candidate2 == num) {
                cnt2++;
            } else if (cnt1 == 0) {
                cnt1 = 1;
                candidate1 = num;
            } else if (cnt2 == 0) {
                cnt2 = 1;
                candidate2 = num;
            } else {
                cnt1--; cnt2--;
            }

        cnt1 = 0; cnt2 = 0;
        for (int num : nums)
            if (candidate1 == num) cnt1++;
            else if (candidate2 == num) cnt2++;

        return cnt1 > cnt2 ? candidate1 : candidate2;
    }
}
