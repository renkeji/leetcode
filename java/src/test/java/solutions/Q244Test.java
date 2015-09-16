package solutions;

import junit.framework.TestCase;

public class Q244Test extends TestCase {

    public void testShortestDistance() throws Exception {
        Q243 solution = new Q243();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        String word1 = "coding";
        String word2 = "practice";
        int ans = solution.shortestDistance(words, word1, word2);
        assertEquals(3, ans);

        word1 = "makes";
        word2 = "coding";
        ans = solution.shortestDistance(words, word1, word2);
        assertEquals(1, ans);
    }

}