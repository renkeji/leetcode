package solutions;

import java.util.*;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * For example,
 *  Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 *  Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 */

public class Q187 extends Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return Collections.emptyList();
        }
        Set<String> ans = new HashSet<>();
        Set<String> hs = new HashSet<>();
        for (int left = 0, right = 10; right <= s.length(); ++left, ++right) {
            String curr = s.substring(left, right);
            if (hs.contains(curr) && !ans.contains(curr)) {
                hs.remove(curr);
                ans.add(curr);
            } else if (!hs.contains(curr)) {
                hs.add(curr);
            }
        }
        return new ArrayList<>(ans);
    }

}
