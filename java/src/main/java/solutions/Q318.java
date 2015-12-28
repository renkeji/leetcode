package solutions;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not
 * share common letters. You may assume that each word will contain only lower case letters.
 * If no such two words exist, return 0.
 *
 * Example 1:
 *  Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 *  Return 16
 *  The two words can be "abcw", "xtfn".
 *
 * Example 2:
 *  Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 *  Return 4
 *  The two words can be "ab", "cd".
 *
 * Example 3:
 *  Given ["a", "aa", "aaa", "aaaa"]
 *  Return 0
 *  No such pair of words.
 */

public class Q318 extends Solution {

    public int maxProduct(String[] words) {
        int max = 0;
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            masks[i] = getMask(words[i]);
        }
        for (int i = 0; i < words.length; ++i) {
            int maxLen = 0;
            for (int j = i+1; j < words.length; ++j) {
                if ((masks[i] & masks[j]) == 0) {
                    maxLen = Math.max(maxLen, words[j].length());
                }
            }
            max = Math.max(max, words[i].length() * maxLen);
        }
        return max;
    }

    private int getMask(String word) {
        int mask = 0;
        for (char c : word.toCharArray()) {
            mask |= 1 << (c - 'a');
        }
        return mask;
    }

}
