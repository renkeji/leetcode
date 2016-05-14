package solutions;

import junit.framework.TestCase;

public class Q227Test extends TestCase {

    public void testCalculate() throws Exception {
        Q227 solution = new Q227();
        String s = "3+4*5-7";
        int actual = solution.calculate(s);
        assertEquals(16, actual);
        s = "3-4*5-7";
        actual = solution.calculate(s);
        assertEquals(-24, actual);
        s = "20/2/5";
        actual = solution.calculate(s);
        assertEquals(2, actual);
    }

}