package solutions;

/**
 * Additive number is a positive integer whose digits can form additive sequence.
 *
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent
 * number in the sequence must be the sum of the preceding two.
 *
 * For example:
 *
 *  "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 *  1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *
 *  "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 *  1 + 99 = 100, 99 + 100 = 199
 *
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 *
 * Given a string represents an integer, write a function to determine if it's an additive number.
 *
 * Follow up:
 *  How would you handle overflow for very large input integers?
 */

public class Q306 extends Solution {

    public boolean isAdditiveNumber(String num) {
        if (num != null && num.length() >= 3) {
            for (int i = 1; i < num.length() - 1; ++i) {
                long num1 = Long.parseLong(num.substring(0, i));
                if (num1 > 0 && num.startsWith("0")) {
                    return false;
                }
                for (int j = i + 1; j < num.length(); ++j) {
                    long num2 = Long.parseLong(num.substring(i, j));
                    if (num2 > 0 && num.charAt(i) == '0') {
                        break;
                    }
                    if (isAdditiveNumber(num.substring(j), num1, num2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isAdditiveNumber(String num, long num1, long num2) {
        if (num.isEmpty()) {
            return true;
        } else {
            for (int i = 1; i <= num.length(); ++i) {
                long sum = Long.parseLong(num.substring(0, i));
                if (sum > 0 && num.startsWith("0")) {
                    return false;
                }
                if (num1 + num2 == sum) {
                    return isAdditiveNumber(num.substring(i), num2, sum);
                }
            }
            return false;
        }
    }

}
