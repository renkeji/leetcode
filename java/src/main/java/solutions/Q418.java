package solutions;

/**
 * Given a rows x cols screen and a sentence represented by a list of words, find how many times the given sentence can be fitted on the screen.
 *
 * Note:
 *  1. A word cannot be split into two lines.
 *  2. The order of words in the sentence must remain unchanged.
 *  3. Two consecutive words in a line must be separated by a single space.
 *  4. Total words in the sentence won't exceed 100.
 *  5. Length of each word won't exceed 10.
 *  6. 1 ≤ rows, cols ≤ 20,000.
 *
 * Example 1:
 *
 *  Input:
 *  rows = 2, cols = 8, sentence = ["hello", "world"]
 *
 *  Output:
 *  1
 *
 *  Explanation:
 *  hello---
 *  world---
 *
 *  The character '-' signifies an empty space on the screen.
 *
 * Example 2:
 *
 *  Input:
 *  rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
 *
 *  Output:
 *  2
 *
 *  Explanation:
 *  a-bcd-
 *  e-a---
 *  bcd-e-
 *
 *  The character '-' signifies an empty space on the screen.
 *
 * Example 3:
 *
 *  Input:
 *  rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
 *
 *  Output:
 *  1
 *
 *  Explanation:
 *  I-had
 *  apple
 *  pie-I
 *  had--
 *
 *  The character '-' signifies an empty space on the screen.
 */

public class Q418 extends Solution {

//    public int wordsTyping(String[] sentence, int rows, int cols) {
//        String s = String.join(" ", sentence) + " ";
//        int start = 0, len = s.length();
//        for (int i = 0; i < rows; ++i) {
//            start += cols;
//            if (s.charAt(start % len) == ' ') {
//                start++;
//            } else {
//                while (start > 0 && s.charAt((start-1) % len) != ' ') {
//                    start--;
//                }
//            }
//        }
//        return start / len;
//    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, len = s.length();
        int[] dp = new int[len];
        for (int i = 1; i < len; ++i) {
            dp[i] = s.charAt(i) == ' ' ? 1 : dp[i-1] - 1;
        }
        for (int i = 0; i < rows; ++i) {
            start += cols;
            start += dp[start % len];
        }
        return start / len;
    }

}
