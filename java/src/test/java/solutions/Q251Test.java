package solutions;

import junit.framework.TestCase;
import solutions.datastructures.Interval;

public class Q251Test extends TestCase {

    public void testMinMeetingRooms() throws Exception {
        Q251 solution = new Q251();

        Interval[] intervals = new Interval[]{new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        int rooms = solution.minMeetingRooms(intervals);
        assertEquals(2, rooms);

        intervals = new Interval[]{new Interval(1, 5), new Interval(8, 9), new Interval(8, 9)};
        rooms = solution.minMeetingRooms(intervals);
        assertEquals(2, rooms);
    }

}