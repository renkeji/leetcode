package solutions;

/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 *  isMatch("aa","a") → false
 *  isMatch("aa","aa") → true
 *  isMatch("aaa","aa") → false
 *  isMatch("aa", "a*") → true
 *  isMatch("aa", ".*") → true
 *  isMatch("ab", ".*") → true
 *  isMatch("aab", "c*a*b") → true
 */

public class Q010 extends Solution {

    // DP solution O(n^2) time and space complexities
    public boolean isMatch(String s, String p) {
        int height = s.length(), width = p.length();
        boolean[][] dp = new boolean[height+1][width+1];
        dp[0][0] = true;
        for (int i = 1; i <= width; ++i) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i = 1; i <= height; ++i) {
            for (int j = 1; j <= width; ++j) {
                char sChar = s.charAt(i-1);
                char pChar = p.charAt(j-1);
                if (sChar == pChar || pChar == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pChar == '*') {
                    if (sChar != p.charAt(j-2) && p.charAt(j-2) != '.') {
                        dp[i][j] = dp[i][j-2];
                    } else {
                        dp[i][j] =  dp[i][j-2] | dp[i-1][j];
                    }
                }
            }
        }
        return dp[height][width];
    }

//    public boolean isMatch(String s, String p) {
//        if (p.isEmpty()) {
//            return s.isEmpty();
//        } else if (p.length() == 1) {
//            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
//        } else if (p.charAt(1) != '*') {
//            if (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
//                return isMatch(s.substring(1), p.substring(1));
//            }
//        } else {
//            for (int i = -1; i < s.length(); ++i) {
//                if (i < 0 || (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
//                    if (isMatch(s.substring(i+1), p.substring(2))) {
//                        return true;
//                    }
//                } else {
//                    return false;
//                }
//            }
//        }
//        return false;
//    }

}
