from src.main.python.Solution import Solution

# Given an index k, return the kth row of the Pascal's triangle.
#
# For example, given k = 3,
# Return [1,3,3,1].
#
# Note:
# Could you optimize your algorithm to use only O(k) extra space?


class Q119(Solution):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        ans = []
        if rowIndex >= 0:
            rowIndex += 1
            c = 1
            for i in range(1, rowIndex):
                ans.append(c)
                c = c*(rowIndex-i)//i
            ans.append(c)
        return ans
