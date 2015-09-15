package solutions;

import junit.framework.TestCase;
import solutions.datastructures.Interval;

public class Q253Test extends TestCase {

    public void testMinMeetingRooms() throws Exception {
        Q253 solution = new Q253();

        Interval[] intervals = new Interval[]{new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        int rooms = solution.minMeetingRooms(intervals);
        assertEquals(2, rooms);

        intervals = new Interval[]{new Interval(1, 5), new Interval(8, 9), new Interval(8, 9)};
        rooms = solution.minMeetingRooms(intervals);
        assertEquals(2, rooms);
    }

}