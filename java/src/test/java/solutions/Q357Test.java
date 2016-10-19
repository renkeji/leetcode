package solutions;

import junit.framework.TestCase;

public class Q357Test extends TestCase {

    public void testCountNumbersWithUniqueDigits() throws Exception {
        Q357 solution = new Q357();
        int n = 2;
        int actual = solution.countNumbersWithUniqueDigits(n);
        assertEquals(91, actual);

        n = 0;
        actual = solution.countNumbersWithUniqueDigits(n);
        assertEquals(1, actual);

        n = 1;
        actual = solution.countNumbersWithUniqueDigits(n);
        assertEquals(10, actual);

        n = 3;
        actual = solution.countNumbersWithUniqueDigits(n);
        assertEquals(739, actual);
    }

}