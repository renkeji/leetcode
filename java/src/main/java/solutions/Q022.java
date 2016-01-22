package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *  "((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class Q022 extends Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n > 0) {
            generateParenthesis(n, n, "", ans);
        }
        return ans;
    }

    private void generateParenthesis(int left, int right, String s, List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(s);
        } else {
            if (left > 0) {
                generateParenthesis(left-1, right, s+"(", ans);
            }
            if (right > left) {
                generateParenthesis(left, right-1, s+")", ans);
            }
        }
    }

}
