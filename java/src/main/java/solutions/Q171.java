package solutions;

/**
 * Related to question Excel Sheet Column Title
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *  A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28
 */

public class Q171 extends Solution {

    public int titleToNumber(String s) {
        int n = 0;
        if (s != null && !s.isEmpty()) {
            for (int i = s.length() - 1; i >= 0; --i) {
                n += (s.charAt(i) - 'A' + 1) * (int) Math.pow(26, s.length() - 1 - i);
            }
        }
        return n;
    }

}
