package solutions;

import junit.framework.TestCase;

public class Q159Test extends TestCase {

    public void testLengthOfLongestSubstringTwoDistinct() throws Exception {
        Q159 solution = new Q159();
        String s = "eceba";
        int ans = solution.lengthOfLongestSubstringTwoDistinct(s);
        assertEquals(3, ans);
    }
}