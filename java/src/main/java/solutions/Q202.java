package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 *  1^2 + 9^2 = 82
 *  8^2 + 2^2 = 68
 *  6^2 + 8^2 = 100
 *  1^2 + 0^2 + 0^2 = 1
 */

public class Q202 extends Solution {

    public boolean isHappy(int n) {
        String s = String.valueOf(n);
        Set<String> hs = new HashSet<>();
        while (!"1".equals(s) && !hs.contains(s)) {
            hs.add(s);
            int sum = 0;
            for (char c : s.toCharArray()) {
                sum += (int) Math.pow(c - '0', 2);
            }
            s = String.valueOf(sum);
        }
        return "1".equals(s);
    }

}
