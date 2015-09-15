package solutions;

import junit.framework.TestCase;
import solutions.datastructures.Interval;

public class Q252Test extends TestCase {

    public void testCanAttendMeetings() throws Exception {
        Q252 solution = new Q252();

        Interval[] intervals = new Interval[]{new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        boolean ans = solution.canAttendMeetings(intervals);
        assertFalse(ans);
    }

}