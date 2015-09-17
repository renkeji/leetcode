package solutions;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q163Test extends TestCase {

    public void testFindMissingRanges() throws Exception {
        Q163 solution = new Q163();
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        List<String> expected = new ArrayList<>(Arrays.asList("2", "4->49", "51->74", "76->99"));
        List<String> actual = solution.findMissingRanges(nums, lower, upper);
        assertEquals(expected, actual);

        nums = new int[] {3, 50, 99};
        lower = 0;
        upper = 99;
        expected = new ArrayList<>(Arrays.asList("0->2", "4->49", "51->98"));
        actual = solution.findMissingRanges(nums, lower, upper);
        assertEquals(expected, actual);

        nums = new int[] {};
        lower = 1;
        upper = 1;
        expected = new ArrayList<>(Arrays.asList("1"));
        actual = solution.findMissingRanges(nums, lower, upper);
        assertEquals(expected, actual);

        nums = new int[] {-1};
        lower = -2;
        upper = -1;
        expected = new ArrayList<>(Arrays.asList("-2"));
        actual = solution.findMissingRanges(nums, lower, upper);
        assertEquals(expected, actual);
    }

}