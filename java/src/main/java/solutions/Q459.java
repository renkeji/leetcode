package solutions;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 * Example 1:
 *  Input: "abab"
 *  Output: True
 *  Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 *  Input: "aba"
 *  Output: False
 *
 * Example 3:
 *  Input: "abcabcabcabc"
 *  Output: True
 *  Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

public class Q459 extends Solution {

//    public boolean repeatedSubstringPattern(String str) {
//        if (str == null || str.isEmpty()) {
//            return false;
//        } else {
//            for (int i = 0; i < str.length() / 2; ++i) {
//                String pattern = str.substring(0, i+1);
//                if (isRepeatedPattern(pattern, str.substring(pattern.length()))) {
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
//
//    private boolean isRepeatedPattern(String pattern, String str) {
//        System.out.println(pattern + "\t" + str);
//        return str.isEmpty() || str.startsWith(pattern) && isRepeatedPattern(pattern, str.substring(pattern.length()));
//    }

    public boolean repeatedSubstringPattern(String str) {
        int l = str.length();
        for (int i = l / 2; i >= 1; i--) {
            if (l % i == 0) {
                int m = l / i;
                String subS = str.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                if (sb.toString().equals(str)) return true;
            }
        }
        return false;
    }

}
