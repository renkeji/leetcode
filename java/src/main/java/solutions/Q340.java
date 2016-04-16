package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 *
 * For example, Given s = “eceba” and k = 2,
 *
 * T is "ece" which its length is 3.
 */

public class Q340 extends Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.isEmpty() || k == 0) {
            return 0;
        }
        Map<Character, Integer> hm = new HashMap<>();
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        while (j < s.length()) {
            if (!hm.containsKey(s.charAt(j))) {
                if (hm.size() == k) {
                    max = Math.max(max, j - i);
                    while (i < j && hm.get(s.charAt(i)) != 1) {
                        hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);
                        ++i;
                    }
                    hm.remove(s.charAt(i));
                    ++i;
                }
                hm.put(s.charAt(j), 0);
            }
            hm.put(s.charAt(j), hm.get(s.charAt(j)) + 1);
            ++j;
        }
        return Math.max(max, j - i);
    }

}
