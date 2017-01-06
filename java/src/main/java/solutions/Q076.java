package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * For example,
 *  S = "ADOBECODEBANC"
 *  T = "ABC"
 *  Minimum window is "BANC".
 *
 * Note:
 *  If there is no such window in S that covers all characters in T, return the empty string "".
 *  If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

public class Q076 extends Solution {

    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || s.length() < t.length()) return "";
        Map<Character, Integer> hm = new HashMap<>();
        for (char c : t.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        int i = 0, count = t.length();
        String min = s;
        for (int j = 0; j < s.length(); j++) {
            char jChar = s.charAt(j);
            if (!hm.containsKey(jChar)) continue;
            if (hm.get(jChar) > 0) count--;
            hm.put(jChar, hm.get(jChar) - 1);
            if (count == 0) {
                char iChar = s.charAt(i);
                while (i < j && (!hm.containsKey(iChar) || hm.get(iChar) < 0)) {
                    if (hm.containsKey(iChar))
                        hm.put(iChar, hm.get(iChar) + 1);
                    iChar = s.charAt(++i);
                }
                min = min.length() <= j - i + 1 ? min : s.substring(i, j + 1);
            }
        }
        return (count == 0) ? min : "";
    }

}
