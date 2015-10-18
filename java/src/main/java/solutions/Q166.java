package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * For example,
 *  Given numerator = 1, denominator = 2, return "0.5".
 *  Given numerator = 2, denominator = 1, return "2".
 *  Given numerator = 2, denominator = 3, return "0.(6)".
 */

public class Q166 extends Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        assert denominator != 0;
        long num = Math.abs((long)numerator), denom = Math.abs((long)denominator);
        String ans = "";
        if (num % denom == 0) {
            ans = String.valueOf(num / denom);
        } else {
            long q = num / denom;
            num = (num - denom * q) * 10;
            StringBuilder sb = new StringBuilder(q + ".");
            Map<Long, Integer> hm = new HashMap<>();
            while (num != 0 && !hm.containsKey(num)) {
                while (num < denom) {
                    hm.put(num, sb.length());
                    sb.append(0);
                    num *= 10;
                }
                q = num / denom;
                hm.put(num, sb.length());
                sb.append(q);
                num = (num - denom * q) * 10;
            }
            if (hm.containsKey(num)) {
                int startIndex = hm.get(num);
                sb.insert(startIndex, '(');
                sb.append(')');
            }
            ans = sb.toString();
        }
        if ( (numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0) ) {
            ans = "-" + ans;
        }
        return ans;
    }

}
