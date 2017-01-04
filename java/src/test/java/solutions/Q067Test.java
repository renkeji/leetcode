package solutions;

import junit.framework.TestCase;

public class Q067Test extends TestCase {

    public void testAddBinary() throws Exception {
        Q067 solution = new Q067();
        String a = "1";
        String b = "1";
        String actual = solution.addBinary(a, b);
        assertEquals("10", actual);
    }

}