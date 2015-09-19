package solutions;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class Q260Test extends TestCase {

    public void testSingleNumber() throws Exception {
        Q260 solution = new Q260();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] expected = {3, 5};
        int[] actual = solution.singleNumber(nums);
        assertArrayEquals(expected, actual);
    }

}