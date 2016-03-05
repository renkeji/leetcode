package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 *
 * For example,
 *  Given s = "eceba",
 *  T is "ece" which its length is 3.
 */

public class Q159 extends Solution {

//    public int lengthOfLongestSubstringTwoDistinct(String s) {
//        if (s == null || s.isEmpty()) {
//            return 0;
//        }
//        Map<Character, Integer> hm = new HashMap<>();
//        int i = 0, j = 0;
//        int max = Integer.MIN_VALUE;
//        while (j < s.length()) {
//            if (!hm.containsKey(s.charAt(j))) {
//                if (hm.size() == 2) {
//                    max = Math.max(max, j - i);
//                    while (i < j && hm.get(s.charAt(i)) != 1) {
//                        hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);
//                        ++i;
//                    }
//                    hm.remove(s.charAt(i));
//                    ++i;
//                }
//                hm.put(s.charAt(j), 0);
//            }
//            hm.put(s.charAt(j), hm.get(s.charAt(j)) + 1);
//            ++j;
//        }
//        return Math.max(max, j - i);
//    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        if (s != null && !s.isEmpty()) {
            char first = ' ', second = ' ';
            int firstCnt = 0, secondCnt = 0;
            int i = 0, j = 0;
            int len = s.length();
            char[] charArray = s.toCharArray();
            while (j < len) {
                char ch = charArray[j];
                if (first == ' ' || ch == first) {
                    first = ch;
                    firstCnt++;
                } else if (second == ' ' || ch == second) {
                    second = ch;
                    secondCnt++;
                } else {
                    max = Math.max(max, j - i);
                    while (i < j) {
                        char c = charArray[i++];
                        if (c == first) {
                            if (--firstCnt == 0) {
                                first = ch;
                                firstCnt = 1;
                                break;
                            }
                        } else {
                            if (--secondCnt == 0) {
                                second = ch;
                                secondCnt = 1;
                                break;
                            }
                        }
                    }
                }
                ++j;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }

}
