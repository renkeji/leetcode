package solutions;

import junit.framework.TestCase;

public class Q269Test extends TestCase {

    public void testAlienOrder() throws Exception {
        Q269 solution = new Q269();
        String[] words = new String[] {"wrt", "wrf", "er", "ett", "rftt"};
        String expected = "wertf";
        String actual = solution.alienOrder(words);
        assertEquals(expected, actual);

        words = new String[] {"aac", "aabb", "aaba"};
        expected = "cba";
        actual = solution.alienOrder(words);
        assertEquals(expected, actual);
    }

}