package solutions;

import java.util.*;

/**
 * This is a follow up of Shortest Word Distance.
 * The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters.
 * How would you optimize it?
 *
 * Design a class which receives a list of words in the constructor,
 * and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 *
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *  Given word1 = "coding", word2 = "practice", return 3.
 *  Given word1 = "makes", word2 = "coding", return 1.
 *
 * Note:
 *  You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

public class Q244 extends Solution {

    public class WordDistance {

        private Map<String, List<Integer>> map;

        public WordDistance(String[] words) {
            map = new HashMap<>();
            ListIterator<String> it = Arrays.asList(words).listIterator();
            while (it.hasNext()) {
                int index = it.nextIndex();
                String next = it.next();
                if (!map.containsKey(next)) {
                    map.put(next, new ArrayList<Integer>());
                }
                map.get(next).add(index);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);

            int i1 = 0, i2 = 0;
            int s1 = list1.size(), s2 = list2.size();
            int min = Math.abs(list1.get(i1) - list2.get(i2));
            while (i1 < s1 || i2 < s2) {
                if (i1 == s1) { // i2 != s2
                    while (i2 != s2) {
                        min = Math.min(min, Math.abs(list1.get(i1-1) - list2.get(i2++)));
                    }
                } else if (i2 == s2) {  // i1 != s1
                    while (i1 != s1) {
                        min = Math.min(min, Math.abs(list1.get(i1++) - list2.get(i2-1)));
                    }
                } else if (list1.get(i1) < list2.get(i2)) {    // i1 != s1 && i2 != s2
                    while (i1 != s1 && list1.get(i1) < list2.get(i2)) {
                        min = Math.min(min, Math.abs(list1.get(i1++) - list2.get(i2)));
                    }
                } else {
                    while (i2 != s2 && list1.get(i1) > list2.get(i2)) {
                        min = Math.min(min, Math.abs(list1.get(i1) - list2.get(i2++)));
                    }
                }
            }
            return min;
        }

    }

}
