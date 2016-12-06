package solutions;

import junit.framework.TestCase;

public class Q389Test extends TestCase {

    public void testFindTheDifference() throws Exception {
        Q389 solution = new Q389();
        String s = "abcd", t = "abcde";
        char actual = solution.findTheDifference(s, t);
        assertEquals('e', actual);
    }

}