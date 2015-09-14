package solutions;

import junit.framework.TestCase;

public class Q263Test extends TestCase {

    public void testIsUgly() throws Exception {
        Q263 solution = new Q263();

        int t1 = 6;
        boolean s1 = solution.isUgly(t1);
        assertTrue(s1);

        int t2 = 8;
        boolean s2 = solution.isUgly(t2);
        assertTrue(s2);

        int t3 = 14;
        boolean s3 = solution.isUgly(t3);
        assertFalse(s3);
    }

}