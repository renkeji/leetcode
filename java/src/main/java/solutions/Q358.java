package solutions;

import java.util.Arrays;

/**
 * Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.
 *
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
 *
 * Example 1:
 *  str = "aabbcc", k = 3
 *  Result: "abcabc"
 *  The same letters are at least distance 3 from each other.
 *
 * Example 2:
 *  str = "aaabc", k = 3
 *  Answer: ""
 *  It is not possible to rearrange the string.
 *
 * Example 3:
 *  str = "aaadbbcc", k = 2
 *  Answer: "abacabcd"
 *  Another possible answer is: "abcabcda"
 *  The same letters are at least distance 2 from each other.
 */

public class Q358 extends Solution {

    public String rearrangeString(String str, int k) {
        StringBuilder sb = new StringBuilder();
        int[] counts = countLetters(str);
        int[] dist = new int[26];
        for (int i = 0; i < str.length(); ++i) {
            char ch = getChar(counts, dist, k);
            if (ch == ' ') return "";
            sb.append(ch);
        }
        return sb.toString();
    }

    private int[] countLetters(String str) {
        int[] counts = new int[26];
        for (char c : str.toCharArray()) {
            counts[c-'a']++;
        }
        return counts;
    }

    private char getChar(int[] counts, int[] dist, int k) {
        int max = 0;
        char maxChar = ' ';
        for (int i = 0; i < counts.length; ++i) {
            if (--dist[i] <= 0) {
                if (max < counts[i]) {
                    max = counts[i];
                    maxChar = (char)('a' + i);
                }
            }
        }
        if (maxChar != ' ') {
            dist[maxChar-'a'] = k;
            counts[maxChar-'a']--;
        }
        return maxChar;
    }

}
