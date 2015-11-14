/**
 * Created by pmg on 2015/11/14.
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Example
 * "A man, a plan, a canal: Panama" is a palindrome.
 *
 * "race a car" is not a palindrome.
 *
 * Note
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Challenge
 * O(n) time without extra memory.
 *
 */

public class ValidPalindrome
{
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public static boolean isPalindrome(String s) {
        if (s == null) return true;
        if (s.length() == 0) return true;
        int i = -1, j = s.length();
        s = s.toLowerCase();
        while (true) {
            while (i < s.length() - 1 && !Character.isLetterOrDigit(s.charAt(++i))) ;
            while (j > 0 && !Character.isLetterOrDigit(s.charAt(--j))) ;
            if (i >= j) return true;
            if (s.charAt(i) != s.charAt(j)) return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome(""));
    }
}
