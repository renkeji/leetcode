package solutions;

import junit.framework.TestCase;

public class Q290Test extends TestCase {

    public void testWordPattern() throws Exception {
        Q290 solution = new Q290();
        String pattern = "abba";
        String str = "dog cat cat dog";
        assertTrue(solution.wordPattern(pattern, str));

        pattern = "abba";
        str = "dog cat cat fish";
        assertFalse(solution.wordPattern(pattern, str));

        pattern = "aaaa";
        str = "dog cat cat dog";
        assertFalse(solution.wordPattern(pattern, str));

        pattern = "abba";
        str = "dog dog dog dog";
        assertFalse(solution.wordPattern(pattern, str));
    }

}