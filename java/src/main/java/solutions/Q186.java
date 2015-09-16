package solutions;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 *
 * For example,
 *  Given s = "the sky is blue",
 *  return "blue is sky the".
 *
 * Could you do it in-place without allocating extra space?
 */

public class Q186 extends Solution {

    public void reverseWords(char[] s) {
        if (s == null) {
            return;
        }
        // reverse the whole string
        for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        // reverse each token
        int i = 0;
        while (i < s.length) {
            int j = i + 1;
            while (j != s.length && s[j] != ' ') {
                ++j;
            }
            for (int m = i, n = j - 1; m < n; ++m, --n) {
                char temp = s[m];
                s[m] = s[n];
                s[n] = temp;
            }
            i = j + 1;
        }
    }

}
