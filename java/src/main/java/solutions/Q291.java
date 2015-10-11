package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 *
 * Examples:
 *  1. pattern = "abab", str = "redblueredblue" should return true.
 *  2. pattern = "aaaa", str = "asdasdasdasd" should return true.
 *  3. pattern = "aabb", str = "xyzabcxzyabc" should return false.
 */

public class Q291 extends Solution {

    public boolean wordPatternMatch(String pattern, String str) {
        assert pattern != null;
        assert str != null;
        return wordPatternMatch(pattern, str, new HashMap<Character, String>());
    }

    private boolean wordPatternMatch(String p, String s, Map<Character, String> hm) {
        if (p.isEmpty() && s.isEmpty()) {
            return true;
        } else if (!p.isEmpty() && !s.isEmpty()) {
            char key = p.charAt(0);
            String value = hm.get(key);
            if (value != null) {
                return s.startsWith(value) &&
                    wordPatternMatch(p.substring(1), s.substring(value.length()), hm);
            } else {
                for (int i = 1; i <= s.length(); ++i) {
                    value = s.substring(0, i);
                    if (!hm.containsValue(value)) {
                        hm.put(key, value);
                        if (wordPatternMatch(p.substring(1), s.substring(value.length()), hm)) {
                            return true;
                        }
                        hm.remove(key);
                    }
                }
                return false;
            }
        }
        return false;
    }

}
