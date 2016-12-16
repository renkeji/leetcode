package solutions;

import junit.framework.TestCase;

public class Q459Test extends TestCase {

    public void testRepeatedSubstringPattern() throws Exception {
        Q459 solution = new Q459();
        String str = "abab";
        assertTrue(solution.repeatedSubstringPattern(str));

        str = "aba";
        assertFalse(solution.repeatedSubstringPattern(str));

        str = "abcabcabcabc";
        assertTrue(solution.repeatedSubstringPattern(str));

        str = "aaa";
        assertTrue(solution.repeatedSubstringPattern(str));
    }

}