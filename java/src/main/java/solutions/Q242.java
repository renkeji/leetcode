package solutions;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 *  s = "anagram", t = "nagaram", return true.
 *  s = "rat", t = "car", return false.
 *
 * Note:
 *  You may assume the string contains only lowercase alphabets.
 */

public class Q242 extends Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for (int i : table) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
