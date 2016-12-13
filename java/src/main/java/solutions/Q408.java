package solutions;

/**
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
 *
 * A string such as "word" contains only the following valid abbreviations:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 * Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".
 *
 * Note:
 *  Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
 *
 * Example 1:
 *
 *  Given s = "internationalization", abbr = "i12iz4n":
 *  Return true.
 *
 * Example 2:
 *
 *  Given s = "apple", abbr = "a2e":
 *  Return false.
 */

public class Q408 extends Solution {

    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null) {
            return false;
        } else {
            int i = 0, j = 0;
            while (i < abbr.length()) {
                if (j >= word.length()) {
                    return false;
                } else {
                    if (Character.isDigit(abbr.charAt(i))) {
                        if (abbr.charAt(i) == '0') return false;
                        int k = 0;
                        while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
                            int num = abbr.charAt(i++) - '0';
                            k = k == 0 ? num : k * 10 + num;
                        }
                        j += k;
                    } else {
                        if (word.charAt(j++) != abbr.charAt(i++)) {
                            return false;
                        }
                    }
                }
            }
            return j == word.length() && i == abbr.length();
        }
    }

}
