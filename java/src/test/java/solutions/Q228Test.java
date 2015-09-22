package solutions;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q228Test extends TestCase {

    public void testSummaryRanges() throws Exception {
        Q228 solution = new Q228();
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> expected = new ArrayList<>(Arrays.asList("0->2", "4->5", "7"));
        List<String> actual = solution.summaryRanges(nums);
        assertEquals(expected, actual);
    }

}