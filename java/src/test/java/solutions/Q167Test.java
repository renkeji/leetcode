package solutions;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class Q167Test extends TestCase {

    public void testTwoSum() throws Exception {
        Q167 solution = new Q167();
        int[] numbers = {2, 7, 11, 15};
        int[] expected = {1, 2};
        int[] actual = solution.twoSum(numbers, 9);
        assertArrayEquals(expected, actual);
    }

}