package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Examples:
 *  1. pattern = "abba", str = "dog cat cat dog" should return true.
 *  2. pattern = "abba", str = "dog cat cat fish" should return false.
 *  3. pattern = "aaaa", str = "dog cat cat dog" should return false.
 *  4. pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * Notes:
 *  You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */

public class Q290 extends Solution {

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> hm = new HashMap<>();
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); ++i) {
            char key = pattern.charAt(i);
            String value = strs[i];
            if ( (hm.containsKey(key) && !value.equals(hm.get(key)))
                || (!hm.containsKey(key) && hm.containsValue(value)) ) {
                return false;
            } else if (!hm.containsKey(key)) {
                hm.put(key, strs[i]);
            }
        }
        return true;
    }

}
