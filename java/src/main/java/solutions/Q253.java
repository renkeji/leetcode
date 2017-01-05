package solutions;

import solutions.datastructures.Interval;

import java.util.*;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * For example,
 *  Given [[0, 30],[5, 10],[15, 20]],
 *  return 2.
 */

public class Q253 extends Solution {

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.end - b.end; }
        });

        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            // don't forget to put the meeting room back
            heap.offer(interval);
        }

        return heap.size();
    }

//    public int minMeetingRooms(Interval[] intervals) {
//        if (intervals == null || intervals.length == 0) {
//            return 0;
//        }
//        Arrays.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//        });
//        Map<Integer, Integer> map = new TreeMap<>();
//        for (Interval i : intervals) {
//            if (!map.containsKey(i.start)) {
//                map.put(i.start, 0);
//            }
//            map.put(i.start, map.get(i.start) + 1);
//            if (!map.containsKey(i.end)) {
//                map.put(i.end, 0);
//            }
//            map.put(i.end, map.get(i.end) - 1);
//        }
//        int rooms = 0;
//        int max = 0;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            rooms += entry.getValue();
//            max = Math.max(max, rooms);
//        }
//        return max;
//    }

}
