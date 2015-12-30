package solutions;

import junit.framework.TestCase;

public class Q316Test extends TestCase {

    public void testRemoveDuplicateLetters() throws Exception {
        Q316 solution = new Q316();
        String s = "bcabc";
        String actual = solution.removeDuplicateLetters(s);
        String expected = "abc";
        assertEquals(expected, actual);

        s = "cbacdcbc";
        actual = solution.removeDuplicateLetters(s);
        expected = "acdb";
        assertEquals(expected, actual);
    }

}