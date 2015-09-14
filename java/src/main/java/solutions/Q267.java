package solutions;

import java.util.ArrayList;
import java.util.List;

public class Q267 extends Solution {

    private String getSingleChars(String s, int[] counts) {
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        String singles = "";
        for (int i = 0; i < counts.length; ++i) {
            if (counts[i] % 2 == 1) {
                counts[i]--;
                singles += (char)i;
            }
        }
        return singles;
    }

    private char getNextChar(int[] counts, int index) {
        while (index < counts.length) {
            if (counts[index] > 0) {
                return (char)index;
            } else {
                ++index;
            }
        }
        return '\0';
    }

    private void generatePalindromes(String str, int[] counts, int index, int limit, char single, List<String> ans) {
        if (index == limit) {
            String reverse = new StringBuilder(str).reverse().toString();
            if (single != '\0') {
                str += single;
            }
            str += reverse;
            ans.add(str);
        } else {
            char curr = getNextChar(counts, 0);
            while (curr != '\0') {
                str += curr;
                counts[curr] -= 2;
                generatePalindromes(str, counts, index+1, limit, single, ans);
                str = str.substring(0, str.length()-1);
                counts[curr] += 2;
                curr = getNextChar(counts, (int)curr + 1);
            }
        }
    }

    public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return ans;
        }
        int[] counts = new int[128];
        String singles = getSingleChars(s, counts);
        if (singles.length() <= 1) {
            char single = singles.length() == 1 ? singles.charAt(0) : '\0';
            generatePalindromes("", counts, 0, s.length() / 2, single, ans);
        }
        return ans;
    }

}
