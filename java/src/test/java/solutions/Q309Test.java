package solutions;

import junit.framework.TestCase;

public class Q309Test extends TestCase {

    public void testMaxProfit() throws Exception {
        Q309 solution = new Q309();
        int[] prices = {1, 2, 3, 0, 2};
        int expected = 3;
        int actual = solution.maxProfit(prices);
        assertEquals(expected, actual);
    }

}