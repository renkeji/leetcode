package solutions;

import junit.framework.TestCase;

public class Q394Test extends TestCase {

    public void testDecodeString() throws Exception {
        Q394 solution = new Q394();
        String s = "3[a]2[bc]";
        String actual = solution.decodeString(s);
        String expected = "aaabcbc";
        assertEquals(expected, actual);

        s = "3[a2[c]]";
        actual = solution.decodeString(s);
        expected = "accaccacc";
        assertEquals(expected, actual);

        s = "2[abc]3[cd]ef";
        actual = solution.decodeString(s);
        expected = "abcabccdcdcdef";
        assertEquals(expected, actual);
    }

}