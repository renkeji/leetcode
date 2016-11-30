package solutions;

import solutions.datastructures.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 *  Given [1,3],[2,6],[8,10],[15,18],
 *  return [1,6],[8,10],[15,18].
 */

public class Q056 extends Solution {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            return ans;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        Interval copy = intervals.get(0);
        for (Interval each : intervals) {
            if (copy.start <= each.end && each.start <= copy.end) {
                copy.start = Math.min(copy.start, each.start);
                copy.end = Math.max(copy.end, each.end);
            } else {
                ans.add(copy);
                copy = each;
            }
        }
        ans.add(copy);
        return ans;
    }

}
