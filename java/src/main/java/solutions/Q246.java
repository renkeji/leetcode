package solutions;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */

public class Q246 extends Solution {

    public boolean isStrobogrammatic(String num) {
        if (num == null || num.isEmpty()) {
            return true;
        } else {
            for (int i = 0, j = num.length() - 1; i <= j; ++i, --j) {
                char left = num.charAt(i);
                char right = num.charAt(j);
                if (left == '6' && right != '9') {
                    return false;
                } else if (left == '9' && right != '6') {
                    return false;
                } else if (left == '1' && right != '1') {
                    return false;
                } else if (left == '0' && right != '0') {
                    return false;
                } else if (left == '8' && right != '8') {
                    return false;
                } else if (left == '2' || left == '3' || left == '4' || left == '5' || left == '7') {
                    return false;
                }
            }
            return true;
        }
    }

}
