package solutions;

import solutions.utils.Utils;

import java.util.*;

/**
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 *      "abc" -> "bcd" -> ... -> "xyz"
 *
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Return:
 *      [
 *          ["abc","bcd","xyz"],
 *          ["az","ba"],
 *          ["acef"],
 *          ["a","z"]
 *      ]
 *
 * Note: For the return value, each inner list's elements must follow the lexicographic order.
 */

public class Q249 extends Solution {

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(strings);
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        while (!list.isEmpty()) {
            List<String> one = new ArrayList<>();
            List<String> remove = new ArrayList<>();
            String curr = list.get(0);
            one.add(curr);
            for (int i = 1; i < list.size(); ++i) {
                String pair = list.get(i);
                if (isShiftedPair(curr, pair)) {
                    one.add(pair);
                    remove.add(pair);
                }
            }
            remove.add(curr);
            list.removeAll(remove);
            ans.add(one);
        }
        return ans;
    }

    private boolean isShiftedPair(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        } else if (source.length() == 1) {
            return true;
        } else {
            int diff = -1;
            for (int i = 0; i < source.length(); ++i) {
                int s = source.charAt(i) - 'a';
                int t = target.charAt(i) - 'a';
                if (t < s) {
                    t += 26;
                }
                if (diff == -1) {
                    diff = t - s;
                } else if (t - s != diff) {
                    return false;
                }
            }
            return true;
        }
    }

}
