import java.util.ArrayList;

/**
 * Created by pmg on 2015/11/9.
 * Find K-th largest element in an array.
 *
 * Example
 * In array [9,3,2,4,8], the 3rd largest element is 4.
 *
 * In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
 *
 * Note
 * You can swap elements in the array
 *
 * Challenge
 * O(n) time, O(1) extra memory.
 *
 */
public class KthLargestElement
{
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return

    //// A recursive solution
    /*
    public static int kthLargestElement(int k, ArrayList<Integer> numbers) {
        return select(numbers.size() - k, numbers, 0, numbers.size()-1);
    }

    private static int select(int k, ArrayList<Integer> numbers, int lo, int hi) {
        int i = partition(numbers, lo, hi);
        if (k > i) return select(k, numbers, i + 1, hi);
        else if (k < i) return select(k, numbers, lo, i -1);
        else return numbers.get(i);
    }
    */

    public static int kthLargestElement(int k, ArrayList<Integer> numbers) {
        int lo = 0; int hi = numbers.size() - 1;
        int p = numbers.size() - k;   // kth largest == pth smallest
        while (true) {
            int i = partition(numbers, lo, hi);
            if (p > i) lo = i + 1;
            else if (p < i) hi = i - 1;
            else return numbers.get(p);
        }
    }
    private static int partition(ArrayList<Integer> numbers, int lo, int hi) {
        int v = numbers.get(lo);
        int i = lo+1, j = i;
        for (; j <= hi; j++) {
            if (numbers.get(j) < v) exch(numbers, i++, j);
        }
        exch(numbers, lo, --i);
        return i;
    }

    private static void exch(ArrayList<Integer> numbers, int i, int j) {
        int tmp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, tmp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>(5);
        numbers.add(1); numbers.add(2); numbers.add(3); numbers.add(4); numbers.add(5);
        numbers.add(6); numbers.add(8); numbers.add(9); numbers.add(10); numbers.add(7);
        System.out.println(kthLargestElement(10, numbers));
    }
}


