package solutions;

import junit.framework.TestCase;

public class Q255Test extends TestCase {

    public void testVerifyPreorder() throws Exception {
        Q255 solution = new Q255();

        int[] t1 = {5, 3, 2, 1, 4, 8, 7, 10};
        boolean s1 = solution.verifyPreorder(t1);
        assertTrue(s1);

        int[] t2 = {2, 3, 1};
        boolean s2 = solution.verifyPreorder(t2);
        assertFalse(s2);
    }
}