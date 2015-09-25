package solutions;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class Q286Test extends TestCase {

    public void testWallsAndGates() throws Exception {
        Q286 solution = new Q286();
        int[][] rooms = {
            {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
            {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
            {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        int[][] expected = {
            {3, -1, 0, 1},
            {2, 2, 1, -1},
            {1, -1, 2, -1},
            {0, -1, 3, 4}
        };
        solution.wallsAndGates(rooms);
        assertArrayEquals(expected, rooms);
    }

}