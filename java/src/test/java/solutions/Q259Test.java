package solutions;

import junit.framework.TestCase;

public class Q259Test extends TestCase {

    public void testThreeSumSmaller() throws Exception {
        Q259 solution = new Q259();
        int[] nums1 = {-2, 0, 1, 3};
        int target1 = 2;
        int s1 = solution.threeSumSmaller(nums1, target1);
        assertEquals(2, s1);

        int[] nums2 = {0, 0, 0};
        int target2 = 0;
        int s2 = solution.threeSumSmaller(nums2, target2);
        assertEquals(0, s2);

        int[] nums3 = {1, 1, -2};
        int target3 = 1;
        int s3 = solution.threeSumSmaller(nums3, target3);
        assertEquals(1, s3);
    }
}