package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 *
 * Example:
 *  Given word = "word", return the following list (order does not matter):
 *  ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */

public class Q320 extends Solution {

//    public List<String> generateAbbreviations(String word) {
//        List<String> res = new ArrayList<>();
//        generateAbbreviations("", 0, word, res);
//        return res;
//    }
//
//    private void generateAbbreviations(String curr, int start, String word, List<String> res) {
//        if (start <= word.length()) {
//            res.add(curr + word.substring(start));
//            for (int i = start > 0 ? start + 1 : 0; i < word.length(); ++i) {
//                for (int j = 1; j <= word.length(); ++j) {
//                    generateAbbreviations(curr + word.substring(start, i) + j, i + j, word, res);
//                }
//            }
//        }
//    }

    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        dfs(ans, new StringBuilder(), word.toCharArray(), 0, 0);
        return ans;
    }

    private void dfs(List<String> ans, StringBuilder sb, char[] c, int i, int num) {
        int len = sb.length();
        if (i == c.length) {
            if (num != 0) {
                sb.append(num);
            }
            ans.add(sb.toString());
        } else {
            dfs(ans, sb, c, i + 1, num + 1);    // abbr c[i]
            if (num != 0) {
                sb.append(num);                 // not abbr c[i]
            }
            dfs(ans, sb.append(c[i]), c, i + 1, 0);
        }
        sb.setLength(len);
    }

}
