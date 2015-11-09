/**
 * Created by pmg on 2015/11/9.
 * Find the Nth number in Fibonacci sequence.
 *
 * A Fibonacci sequence is defined as follow:
 *
 * The first two numbers are 0 and 1.
 * The i th number is the sum of i-1 th number and i-2 th number.
 * The first ten numbers in Fibonacci sequence is:
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 *
 * Given 1, return 0
 *
 * Given 2, return 1
 *
 * Given 10, return 34
 *
 * Using non-recursive method, if using the definition equation, the timing
 * test can not be passed.
 */

public class Fibonacci
{
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public static int fibonacci(int n) {
        int k = 1;
        int result = 0, tmp = 1;
        // n >= 1
        while (k < n) {
            int tmp2 = result + tmp;
            result = tmp;
            tmp = tmp2;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 10;
        for (int i = 1; i <= N; i++)
            System.out.print(fibonacci(i) + ", ");
    }
}
