from src.main.python.Solution import Solution

# Given a collection of intervals, merge all overlapping intervals.
#
# For example,
# Given [1,3],[2,6],[8,10],[15,18],
# return [1,6],[8,10],[15,18].


class Q056(Solution):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        ans = []
        if intervals:
            intervals.sort(key=lambda i: i.start)
            copy = intervals[0]
            for i in intervals:
                if i.start <= copy.end and copy.start <= i.end:
                    copy.start = min(copy.start, i.start)
                    copy.end = max(copy.end, i.end)
                elif copy.end < i.start:
                    ans.append(copy)
                    copy = i
            ans.append(copy)
        return ans
