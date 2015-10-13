package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * For example,
 *  Given "egg", "add", return true.
 *  Given "foo", "bar", return false.
 *  Given "paper", "title", return true.
 */

public class Q205 extends Solution {

    public boolean isIsomorphic(String s, String t) {
        assert s != null && t != null;
        assert s.length() == t.length();

        Map<Character, Character> hm = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if ( (hm.containsKey(charS) && hm.get(charS) != charT)
                || (!hm.containsKey(charS) && hm.containsValue(charT)) ) {
                return false;
            } else if (!hm.containsKey(charS)) {
                hm.put(charS, charT);
            }
        }
        return true;
    }

}
