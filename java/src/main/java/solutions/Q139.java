package solutions;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 *  s = "leetcode",
 *  dict = ["leet", "code"].
 *
 *  Return true because "leetcode" can be segmented as "leet code".
 */

public class Q139 extends Solution {

    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for (int i = 0; i < len; ++i) {
            for (int j = i; j >= 0; --j) {
                if (dp[j] && dict.contains(s.substring(j, i+1))) {
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

}
