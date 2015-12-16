import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by pmg on 2015/11/26.
 *
 * Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.
 * Find it.
 *
 * Example
 * Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.
 *
 * Note
 * There is only one majority number in the array.
 *
 * Challenge
 * O(n) time and O(k) extra space
 *
 */

public class MajorityNumberIII
{
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public static int majorityNumber(ArrayList<Integer> nums, int k) {
        HashMap<Integer, Integer> candidates = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!candidates.containsKey(num))
                candidates.put(num, 1);
            else
                candidates.put(num, candidates.get(num)+1);
            if (candidates.size() == k) removeKey(candidates);
        }

        // recalculate the count.
        for (int key : candidates.keySet())
            candidates.put(key, 0);

        for (int num : nums)
            if (candidates.containsKey(num))
                candidates.put(num, candidates.get(num)+1);

        int candidate = 0, max = -Integer.MIN_VALUE;
        for (int key : candidates.keySet())
            if (candidates.get(key) > max) {
                candidate = key;
                max = candidates.get(key);
            }

        return candidate;
    }

    private static void removeKey(HashMap<Integer, Integer> hash) {
        LinkedList<Integer> removeList = new LinkedList<Integer>();
        for (int key : hash.keySet()) {
            hash.put(key, hash.get(key) - 1);
            if (hash.get(key) == 0) removeList.add(key);
        }
        for (int key : removeList)
            hash.remove(key);
    }
}
