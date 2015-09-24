package solutions;

import junit.framework.TestCase;

public class Q223Test extends TestCase {

    public void testComputeArea() throws Exception {
        Q223 solution = new Q223();
        int A = -3, B = 0, C = 3, D = 4;
        int E = 0, F = -1, G = 9, H = 2;
        int expected = 45;
        int actual = solution.computeArea(A, B, C, D, E, F, G, H);
        assertEquals(expected, actual);

        A = B = -2;
        C = D = 2;
        E = -3;
        F = 1;
        G = -1;
        H = 3;
        expected = 19;
        actual = solution.computeArea(A, B, C, D, E, F, G, H);
        assertEquals(expected, actual);
    }

}