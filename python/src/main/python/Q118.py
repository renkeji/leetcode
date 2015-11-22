from src.main.python.Solution import Solution

# Given numRows, generate the first numRows of Pascal's triangle.
#
# For example, given numRows = 5,
#   Return
#
#   [
#         [1],
#        [1,1],
#       [1,2,1],
#      [1,3,3,1],
#     [1,4,6,4,1]
#   ]


class Q118(Solution):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        ans = []
        if numRows > 0:
            prev, curr = [], []
            for i in range(1, numRows+1):
                for j in range(i):
                    if j == 0 or j == i-1:
                        curr.append(1)
                    else:
                        curr.append(prev[j-1] + prev[j])
                ans.append(curr)
                prev = curr
                curr = []
        return ans
