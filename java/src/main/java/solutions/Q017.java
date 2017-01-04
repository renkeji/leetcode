package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note: Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

public class Q017 extends Solution {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits != null && !digits.isEmpty()) {
            letterCombinations(digits.toCharArray(), 0, new StringBuilder(), 0, ans);
        }
        return ans;
    }

    private void letterCombinations(char[] chars, int index, StringBuilder sb, int sbLen, List<String> ans) {
        if (index == chars.length) {
            ans.add(sb.toString());
        } else {
            char[] letters = mapDigit(chars[index]).toCharArray();
            for (char letter : letters) {
                sb.append(letter);
                letterCombinations(chars, index+1, sb, sbLen+1, ans);
                sb.setLength(sbLen);
            }
        }
    }

    private String mapDigit(char digit) {
        switch(digit) {
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default: return "";
        }
    }

}
