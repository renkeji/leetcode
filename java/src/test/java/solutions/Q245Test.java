package solutions;

import junit.framework.TestCase;

public class Q245Test extends TestCase {

    public void testShortestWordDistance() throws Exception {
        Q245 solution = new Q245();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        String word1 = "coding";
        String word2 = "practice";
        int ans = solution.shortestWordDistance(words, word1, word2);
        assertEquals(3, ans);

        word1 = "makes";
        word2 = "coding";
        ans = solution.shortestWordDistance(words, word1, word2);
        assertEquals(1, ans);

        word1 = "makes";
        word2 = "makes";
        ans = solution.shortestWordDistance(words, word1, word2);
        assertEquals(3, ans);
    }

}