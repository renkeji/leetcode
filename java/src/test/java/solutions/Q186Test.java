package solutions;

import junit.framework.TestCase;

public class Q186Test extends TestCase {

    public void testReverseWords() throws Exception {
        Q186 solution = new Q186();
        char[] s = "the sky is blue".toCharArray();
        String expected = "blue is sky the";
        solution.reverseWords(s);
        String actual = new String(s);
        assertEquals(expected, actual);
    }

}