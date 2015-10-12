package solutions;

import junit.framework.TestCase;

public class Q202Test extends TestCase {

    public void testIsHappy() throws Exception {
        Q202 solution = new Q202();
        int n = 19;
        assertTrue(solution.isHappy(n));
    }

}