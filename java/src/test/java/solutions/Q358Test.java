package solutions;

import junit.framework.TestCase;

public class Q358Test extends TestCase {

    public void testRearrangeString() throws Exception {
        Q358 solution = new Q358();
        String str = "aabbcc";
        int k = 3;
        String actual = solution.rearrangeString(str, k);
        String expected = "abcabc";
        assertEquals(expected, actual);

        str = "aaabc";
        k = 3;
        actual = solution.rearrangeString(str, k);
        expected = "";
        assertEquals(expected, actual);

        str = "aaadbbcc";
        k = 2;
        actual = solution.rearrangeString(str, k);
        expected = "abacabcd";
        assertEquals(expected, actual);
    }

}