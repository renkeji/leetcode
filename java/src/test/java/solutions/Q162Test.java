package solutions;

import junit.framework.TestCase;

public class Q162Test extends TestCase {

    public void testFindPeakElement() throws Exception {
        Q162 solution = new Q162();
        int[] nums = new int[]{1};
        int actual = solution.findPeakElement(nums);
        assertEquals(0, actual);
        nums = new int[]{Integer.MIN_VALUE};
        actual = solution.findPeakElement(nums);
        assertEquals(0, actual);
    }

}