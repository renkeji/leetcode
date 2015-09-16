package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Find all strobogrammatic numbers that are of length = n.
 *
 * For example,
 *      Given n = 2, return ["11","69","88","96"].
 */

public class Q247 extends Solution {

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

    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(n, n);
    }

}
