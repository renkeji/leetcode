package solutions;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * For example,
 *  "code" -> False, "aab" -> True, "carerac" -> True.
 */

public class Q266 extends Solution {

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int[] counts = new int[128];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        boolean hasSingle = false;
        for (int i : counts) {
            if (i % 2 == 1) {
                if (!hasSingle) {
                    hasSingle = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
