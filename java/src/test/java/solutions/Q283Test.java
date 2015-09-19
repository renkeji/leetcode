package solutions;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class Q283Test extends TestCase {

    private Q283 solution;

    @Override
    public void setUp() {
        solution = new Q283();
    }

    public void testMoveZeroes() throws Exception {
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        int[] expected = {1, 3, 12, 0, 0};
        assertArrayEquals(expected, nums);
    }

    public void testMoveZerosToFront() throws Exception {
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZerosToFront(nums);
        int[] expected = {0, 0, 1, 3, 12};
        assertArrayEquals(expected, nums);
    }

}