package solutions;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class Q239Test extends TestCase {

    public void testMaxSlidingWindow() throws Exception {
        Q239 solution = new Q239();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k =3;
        int[] expected = {3, 3, 5, 5, 6, 7};
        int[] actual = solution.maxSlidingWindow(nums, k);
        assertArrayEquals(expected, actual);

        nums = new int[]{1, 3, 1, 2, 0, 5};
        k = 3;
        expected = new int[]{3, 3, 2, 5};
        actual = solution.maxSlidingWindow(nums, k);
        assertArrayEquals(expected, actual);
    }

}