package solutions;

import junit.framework.TestCase;
import org.junit.Assert;

public class Q360Test extends TestCase {

    public void testSortTransformedArray() throws Exception {
        Q360 solution = new Q360();
        int[] nums = {-4, -2, 2, 4};
        int[] actual = solution.sortTransformedArray(nums, 1, 3, 5);
        int[] expected = new int[]{3, 9, 15, 33};
        Assert.assertArrayEquals(actual, expected);

        actual = solution.sortTransformedArray(nums, -1, 3, 5);
        expected = new int[]{-23, -5, 1, 7};
        Assert.assertArrayEquals(actual, expected);
    }

}