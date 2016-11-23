package solutions;

import junit.framework.TestCase;
import org.junit.Assert;

public class Q370Test extends TestCase {

    public void testGetModifiedArray() throws Exception {
        Q370 solution = new Q370();
        int[][] updates = {
            {1,  3,  2},
            {2,  4,  3},
            {0,  2, -2},
        };
        int length = 5;
        int[] actual = solution.getModifiedArray(length, updates);
        int[] expected = {-2, 0, 3, 5, 3};
        Assert.assertArrayEquals(actual, expected);
    }

}