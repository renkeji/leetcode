package solutions;

import junit.framework.TestCase;

public class Q274Test extends TestCase {

    public void testHIndex() throws Exception {
        Q274 solution = new Q274();

        int[] t1 = {3, 0, 6, 1, 5};
        int s1 = solution.hIndex(t1);
        assertEquals(3, s1);

        int[] t2 = {100};
        int s2 = solution.hIndex(t2);
        assertEquals(1, s2);
    }
}