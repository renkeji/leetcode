package solutions;

/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 */

public class Q161 extends Solution {

    public boolean isOneEditDistance(String s, String t) {
        String small = s.length() < t.length() ? s : t;
        String large = s.length() < t.length() ? t : s;
        boolean isDiff = false;
        int i = 0, j = 0;
        while (i < small.length() && j < large.length()) {
            if (small.charAt(i) != large.charAt(j)) {
                if (isDiff) {
                    return false;
                } else {
                    isDiff = true;
                    if (small.length() == large.length()) {
                        ++i;
                    }
                }
            } else {
                ++i;
            }
            ++j;
        }
        return isDiff ? large.length() - j == 0 : large.length() - j == 1;
    }

}
