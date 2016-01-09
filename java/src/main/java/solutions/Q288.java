package solutions;

import java.util.*;

/**
 * An abbreviate of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 *
 * a) it                      --> it    (no abbreviate)
 *
 *      1
 * b) d|o|g                   --> d1g
 *
 *               1    1  1
 *      1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 *
 *               1
 *      1---5----0
 * d) l|ocalizatio|n          --> l10n
 *
 * Assume you have a dictionary and given a word, find whether its abbreviate is unique in the dictionary.
 * A word's abbreviate is unique if no other word from the dictionary has the same abbreviate.
 *
 * Example:
 *  Given dictionary = [ "deer", "door", "cake", "card" ]
 *  isUnique("dear") -> false
 *  isUnique("cart") -> true
 *  isUnique("cane") -> false
 *  isUnique("make") -> true
 */

public class Q288 extends Solution {

    public class ValidWordAbbr {

        private Map<String, Integer> hm;
        private Set<String> words;

        public ValidWordAbbr(String[] dictionary) {
            words = new HashSet<>(Arrays.asList(dictionary));
            hm = new HashMap<>();
            for (String word : words) {
                String abbr = abbreviate(word);
                if (!hm.containsKey(abbr)) {
                    hm.put(abbr, 0);
                }
                hm.put(abbr, hm.get(abbr) + 1);
            }
        }

        public boolean isUnique(String word) {
            String abbr = abbreviate(word);
            if (!words.contains(word)) {
                return !hm.containsKey(abbr);
            } else {
                return hm.get(abbr) == 1;
            }
        }

        private String abbreviate(String word) {
            if (word == null || word.length() <= 2) {
                return word;
            } else {
                return word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
            }
        }

    }

}
