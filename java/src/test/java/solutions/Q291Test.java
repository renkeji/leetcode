package solutions;

import junit.framework.TestCase;

public class Q291Test extends TestCase {

    public void testWordPatternMatch() throws Exception {
        Q291 solution = new Q291();
        String pattern = "abab";
        String str = "redblueredblue";
        assertTrue(solution.wordPatternMatch(pattern, str));

        pattern = "aaaa";
        str = "asdasdasdasd";
        assertTrue(solution.wordPatternMatch(pattern, str));

        pattern = "aabb";
        str = "xyzabcxzyabc";
        assertFalse(solution.wordPatternMatch(pattern, str));
    }

}