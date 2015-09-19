package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 *
 * For example,
 *  Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
 *
 * Note:
 *  Because the range might be a large number, the low and high numbers are represented as string.
 */

public class Q248 extends Solution {

    private int compareStringNumbers(String source, String target) {
        if (source.length() > target.length()) {
            return 1;   // greater than
        } else if (source.length() < target.length()) {
            return -1;  // less then
        } else {
            for (int i = 0; i < source.length(); ++i) {
                if (source.charAt(i) > target.charAt(i)) {
                    return 1;
                } else if (source.charAt(i) < target.charAt(i)) {
                    return -1;
                }
            }
            return 0;
        }
    }

    private List<String> findStrobogrammatic(int n, int m) {
        List<String> ans = new ArrayList<>();
        if (m == 0) {
            ans.add("");
        } else if (m == 1) {
            ans.addAll(Arrays.asList("0", "1", "8"));
        } else if (m > 1) {
            List<String> sub = findStrobogrammatic(n, m - 2);
            for (String s : sub) {
                ans.add("1" + s + "1");
                ans.add("6" + s + "9");
                ans.add("8" + s + "8");
                ans.add("9" + s + "6");
                if (n != m) {
                    ans.add("0" + s + "0");
                }
            }
        }
        return ans;
    }

    public int strobogrammaticInRange(String low, String high) {
        int lowLen = low.length();
        int highLen = high.length();
        int count = 0;
        for (int i = lowLen; i <= highLen; ++i) {
            List<String> strings = findStrobogrammatic(i, i);
            for (String s: strings) {
                if (compareStringNumbers(s, low) != -1 && compareStringNumbers(high, s) != -1) {
                    ++count;
                }
            }
        }
        return count;
    }

}
