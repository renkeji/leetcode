package solutions;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *  1 -> A
 *  2 -> B
 *  3 -> C
 *  ...
 *  26 -> Z
 *  27 -> AA
 *  28 -> AB
 */

public class Q168 extends Solution {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int letter = (n - 1) % 26;
            sb.append((char)('A' + letter));
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }

}
