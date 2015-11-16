/**
 * Created by pmg on 2015/11/13.

 * Given two binary strings, return their sum (also a binary string).
 *
 * Example
 * a = 11
 * b = 1
 * Return 100
 *
 * Solution : 利用Java String的 + 运算符
 */

public class AddBinary
{
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public static String addBinary(String a, String b) {
        int aIdx = a.length() - 1, bIdx = b.length() - 1;
        String result = "";
        int carry = 0;
        while (aIdx >= 0 || bIdx >= 0)
            if (aIdx < 0) {
                result = (numOf(b, bIdx) ^ carry) + result;
                carry = numOf(b, bIdx--) & carry;
            } else if (bIdx < 0) {
                result = (numOf(a, aIdx) ^ carry) + result;
                carry = numOf(a, aIdx--) & carry;
            } else {
                result = (numOf(a, aIdx) ^ numOf(b, bIdx) ^ carry) + result;
                carry = numOf(a, aIdx) & numOf(b, bIdx) | numOf(b, bIdx) & carry | numOf(a, aIdx) & carry;
                aIdx--; bIdx--;
            }
        if (carry == 1) result = "1" + result;
        return result;
    }

    private static int numOf(String num, int position) {
        return num.charAt(position) - '0';
    }

    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(addBinary(a, b));

    }
}
