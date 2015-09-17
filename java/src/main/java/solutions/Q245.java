package solutions;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 *
 * For example,
 *  Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *  Given word1 = “makes”, word2 = “coding”, return 1.
 *  Given word1 = "makes", word2 = "makes", return 3.
 *
 * Note:
 *  You may assume word1 and word2 are both in the list.
 */

public class Q245 extends Solution {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        int word1Index = -1;
        int word2Index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; ++i) {
            if (word1.equals(word2) && words[i].equals(word1)) {
                if (word1Index <= word2Index) {
                    word1Index = i;
                } else {
                    word2Index = i;
                }
            } else if (words[i].equals(word1)) {
                word1Index = i;
            } else if (words[i].equals(word2)) {
                word2Index = i;
            }
            if (word1Index != -1 && word2Index != -1) {
                min = Math.min(min, Math.abs(word1Index - word2Index));
            }
        }
        return min;
    }

}
