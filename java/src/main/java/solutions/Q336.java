package solutions;

import java.util.*;

/**
 * Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1:
 *  Given words = ["bat", "tab", "cat"]
 *  Return [[0, 1], [1, 0]]
 *  The palindromes are ["battab", "tabbat"]
 *
 * Example 2:
 *  Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 *  Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 *  The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */

public class Q336 extends Solution {

    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> hs = new HashSet<>();
        Map<String,Integer> hm = new HashMap<>();

        for (int i = 0; i < words.length; ++i) {
            hm.put(words[i],i);
        }

        for (int i = 0; i < words.length; ++i) {
            String s = words[i];
            for (int k = 0; k <= s.length(); ++k) {
                String prefix = s.substring(0, k);
                String suffix = s.substring(k);
                if (isPal(prefix) && hm.containsKey(reverse(suffix)) && hm.get(reverse(suffix)) != i) {
                    hs.add(Arrays.asList(hm.get(reverse(suffix)), i));
                }
            }
            s = reverse(words[i]);
            for (int k = 0; k <= s.length(); ++k) {
                String prefix = s.substring(0, k);
                String suffix = s.substring(k);
                if (isPal(prefix) && hm.containsKey(suffix) && hm.get(suffix) != i) {
                    hs.add(Arrays.asList(i, hm.get(suffix)));
                }
            }

        }

        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> l : hs) {
            ans.add(l);
        }
        return ans;
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private boolean isPal(String s){
        for (int i = 0, j = s.length()-1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

}
