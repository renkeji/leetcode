package solutions;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 *  s = "catsanddog",
 *  dict = ["cat", "cats", "and", "sand", "dog"].
 *  A solution is ["cats and dog", "cat sand dog"].
 */

public class Q140 extends Solution {

    public List<String> wordBreak(String s, Set<String> dict) {
        return wordBreak(s, dict, new HashMap<String, List<String>>());
    }

    private List<String> wordBreak(String s, Set<String> dict, Map<String, List<String>> cache) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        } else {
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= s.length(); ++i) {
                String left = s.substring(0, i);
                String right = s.substring(i);
                if (dict.contains(left)) {
                    if (right.isEmpty()) {
                        list.add(left);
                    } else {
                        List<String> subs = null;
                        if (cache.containsKey(right)) {
                            subs = cache.get(right);
                        } else {
                            subs = wordBreak(right, dict, cache);
                        }
                        if (!subs.isEmpty()) {
                            for (String sub : subs) {
                                list.add(left + " " + sub);
                            }
                        }
                    }
                }
            }
            cache.put(s, list);
            return list;
        }
    }

}
