package solutions;

import junit.framework.TestCase;

public class Q246Test extends TestCase {

    public void testIsStrobogrammatic() throws Exception {
        Q246 solution = new Q246();

        String num = "69";
        boolean ans = solution.isStrobogrammatic(num);
        assertTrue(ans);

        num = "818";
        ans = solution.isStrobogrammatic(num);
        assertTrue(ans);

        num = "88";
        ans = solution.isStrobogrammatic(num);
        assertTrue(ans);
    }

}