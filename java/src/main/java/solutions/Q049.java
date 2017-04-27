package solutions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 *
 * Return:
 *  [
 *      ["ate", "eat","tea"],
 *      ["nat","tan"],
 *      ["bat"]
 *  ]
 */

public class Q049 extends Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length == 0) return ans;
        Map<String, List<String>> hm = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(s);
        }
        ans.addAll(hm.values());
        return ans;
    }
}
