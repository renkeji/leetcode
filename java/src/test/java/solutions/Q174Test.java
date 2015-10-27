package solutions;

import junit.framework.TestCase;

public class Q174Test extends TestCase {

    public void testCalculateMinimumHP() throws Exception {
        Q174 solution = new Q174();
        int[][] dungeon = new int[][] {
            {-2, -3, 3},
            {-5, -10, 1},
            {10, 30, -5}
        };
        int expected = 7;
        int actual = solution.calculateMinimumHP(dungeon);
        assertEquals(expected, actual);

        dungeon = new int[][] {
            {0, -5},
            {0, 0}
        };
        expected = 1;
        actual = solution.calculateMinimumHP(dungeon);
        assertEquals(expected, actual);

        dungeon = new int[][] {
            {0, 0, 0},
            {1, 1, -1}
        };
        expected = 1;
        actual = solution.calculateMinimumHP(dungeon);
        assertEquals(expected, actual);
    }

}