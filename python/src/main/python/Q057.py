from src.main.python.Solution import Solution
from src.main.python.datastructures.Interval import Interval

# Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
#
# You may assume that the intervals were initially sorted according to their start times.
#
# Example 1:
#   Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
#
# Example 2:
#   Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
#
#   This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


class Q057(Solution):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        ans = []
        if newInterval:
            copy = newInterval
            for interval in intervals:
                if copy.start <= interval.end and interval.start <= copy.end:
                    copy.start = min(copy.start, interval.start)
                    copy.end = max(copy.end, interval.end)
                elif copy.end < interval.start:
                    ans.append(copy)
                    copy = interval
                else:
                    ans.append(interval)
            ans.append(copy)
        return ans
