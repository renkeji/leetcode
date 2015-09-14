package solutions;

import junit.framework.TestCase;

public class Q261Test extends TestCase {

    public void testValidTree() throws Exception {
        Q261 solution = new Q261();

        int n1 = 5;
        int[][] e1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        boolean s1 = solution.validTree(n1, e1);
        assertTrue(s1);

        int n2 = 5;
        int[][] e2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        boolean s2 = solution.validTree(n2, e2);
        assertFalse(s2);

        int n3 = 4;
        int[][] e3 = {{0, 1}, {2, 3}};
        boolean s3 = solution.validTree(n3, e3);
        assertFalse(s3);
    }

}