package solutions;

import solutions.datastructures.Interval;

import java.util.*;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * For example,
 *      Given [[0, 30],[5, 10],[15, 20]],
 *      return 2.
 */

public class Q251 extends Solution {

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Map<Integer, Integer> sm = new TreeMap<>();
        for (Interval i : intervals) {
            if (!sm.containsKey(i.start)) {
                sm.put(i.start, 0);
            }
            sm.put(i.start, sm.get(i.start) + 1);
            if (!sm.containsKey(i.end)) {
                sm.put(i.end, 0);
            }
            sm.put(i.end, sm.get(i.end) - 1);
        }
        int rooms = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : sm.entrySet()) {
            rooms += entry.getValue();
            max = Math.max(max, rooms);
        }
        return max;
    }

}
