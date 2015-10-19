package solutions;

import junit.framework.TestCase;

public class Q168Test extends TestCase {

    public void testConvertToTitle() throws Exception {
        Q168 solution = new Q168();
        int n = 1;
        String expected = "A";
        String actual = solution.convertToTitle(n);
        assertEquals(expected, actual);

        n = 26;
        expected = "Z";
        actual = solution.convertToTitle(n);
        assertEquals(expected, actual);

        n = 27;
        expected = "AA";
        actual = solution.convertToTitle(n);
        assertEquals(expected, actual);
    }

}