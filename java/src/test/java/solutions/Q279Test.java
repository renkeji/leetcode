package solutions;

import junit.framework.TestCase;

public class Q279Test extends TestCase {

    private Q279 solution;

    public void setUp() {
        solution = new Q279();
    }

    public void testNumSquares() throws Exception {
        int n1 = 12;
        int s1 = solution.numSquares(n1);
        assertEquals(3, s1);

        int n2 = 13;
        int s2 = solution.numSquares(n2);
        assertEquals(2, s2);
    }
}