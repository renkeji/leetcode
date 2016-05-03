package solutions;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *  Given s = "hello", return "holle".
 *
 * Example 2:
 *  Given s = "leetcode", return "leotcede".
 */

public class Q345 extends Solution {

    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        } else {
            char[] chars = s.toCharArray();
            int i = 0, j = chars.length - 1;
            while (i < j) {
                while (i < j && !isVowel(chars[i])) {
                    ++i;
                }
                while (i < j && !isVowel(chars[j])) {
                    --j;
                }
                if (i < j) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    ++i;
                    --j;
                }
            }
            return new String(chars);
        }
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a': case 'A': return true;
            case 'e': case 'E': return true;
            case 'i': case 'I': return true;
            case 'o': case 'O': return true;
            case 'u': case 'U': return true;
            default: return false;
        }
    }

}