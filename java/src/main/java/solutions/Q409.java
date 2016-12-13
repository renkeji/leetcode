package solutions;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 *  Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 *  Input:
 *  "abccccdd"
 *
 *  Output:
 *  7
 *
 *  Explanation:
 *  One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

public class Q409 extends Solution {

    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        } else {
            int[] table = new int['z' - 'A' + 1];
            for (char c : s.toCharArray()) {
                table[c-'A']++;
            }
            boolean hasSingleChar = false;
            int ans = 0;
            for (int i : table) {
                if (i % 2 == 0) {
                    ans += i;
                } else {
                    hasSingleChar = true;
                    ans += (i - 1);
                }
            }
            return hasSingleChar ? ans + 1 : ans;
        }
    }

}
