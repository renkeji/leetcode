package solutions;

import junit.framework.TestCase;

public class Q179Test extends TestCase {

    public void testLargestNumber() throws Exception {
        Q179 solution = new Q179();
        int[] nums = new int[]{3, 30, 34, 5, 9};
        String expected = "9534330";
        String actual = solution.largestNumber(nums);
        assertEquals(expected, actual);

        nums = new int[]{824,938,1399,5607,6973,5703,9609,4398,8247};
        expected = "9609938824824769735703560743981399";
        actual = solution.largestNumber(nums);
        assertEquals(expected, actual);
    }

}