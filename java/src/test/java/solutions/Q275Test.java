package solutions;

import junit.framework.TestCase;

public class Q275Test extends TestCase {

    public void testHIndex() throws Exception {
        Q275 solution = new Q275();

        int[] t1 = {0, 1, 3, 5 ,6};
        int s1 = solution.hIndex(t1);
        assertEquals(3, s1);

        int[] t2 = {0, 0};
        int s2 = solution.hIndex(t2);
        assertEquals(0, s2);
    }

}