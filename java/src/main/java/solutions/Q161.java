package solutions;

/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 */

public class Q161 extends Solution {

    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        char[] small = sLen < tLen ? s.toCharArray() : t.toCharArray();
        char[] large = sLen < tLen ? t.toCharArray() : s.toCharArray();
        boolean isDiff = false;
        int i = 0, j = 0;
        while (i < small.length && j < large.length) {
            if (small[i++] != large[j++]) {
                if (isDiff) {
                    return false;
                } else {
                    isDiff = true;
                    if (small.length != large.length) {
                        --i;
                    }
                }
            }
        }
        return isDiff ? large.length == j : large.length - j == 1;
    }

}
