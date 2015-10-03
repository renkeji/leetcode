package solutions;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class Q189Test extends TestCase {

    public void testRotate() throws Exception {
        Q189 solution = new Q189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        int[] expected = {5, 6, 7, 1, 2, 3, 4};
        assertArrayEquals(expected, nums);
    }

}