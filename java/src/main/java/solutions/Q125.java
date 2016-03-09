package solutions;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * For example,
 *  "A man, a plan, a canal: Panama" is a palindrome.
 *  "race a car" is not a palindrome.
 *
 * Note:
 *  Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 */

public class Q125 extends Solution {

    private boolean isAlphanumeric(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0, j = chars.length - 1;
        while (i <= j) {
            while (i <= j && !isAlphanumeric(chars[i]))
                ++i;
            while (i <= j && !isAlphanumeric(chars[j]))
                --j;
            if (i > j) return true;
            if (chars[i++] != chars[j--]) return false;
        }
        return true;
    }

}
