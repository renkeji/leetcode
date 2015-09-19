package solutions;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * For example:
 *  Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 *
 * Follow up:
 *  Could you do it without any loop/recursion in O(1) runtime?
 */

public class Q258 extends Solution {

    // Trivial solution
//    public int addDigits(int num) {
//        String n = String.valueOf(num);
//        while (n.length() > 1) {
//            int sum = 0;
//            for (int i = 0; i < n.length(); ++i) {
//                sum += (n.charAt(i) - '0');
//            }
//            n = String.valueOf(sum);
//        }
//        return Integer.parseInt(n);
//    }

    /**
     * @see <a href="https://en.wikipedia.org/wiki/Digital_root">Digital root</a>
     */
    public int addDigits(int num) {
        return num - 9 * (int)Math.floor((num - 1) / 9);
    }
}
