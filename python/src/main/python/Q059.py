from src.main.python.Solution import Solution

# Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
#
# For example,
#   Given n = 3,
#
#   You should return the following matrix:
#   [
#     [ 1, 2, 3 ],
#     [ 8, 9, 4 ],
#     [ 7, 6, 5 ]
#   ]


class Q059(Solution):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        def generate_matrix(num, n, k, ans):
            if n <= 0:
                return
            elif n == 1:
                ans[k][k] = num
                return
            else:
                for j in range(n-1):
                    ans[k][k+j] = num
                    num += 1
                for i in range(n-1):
                    ans[k+i][k+n-1] = num
                    num += 1
                for j in range(n-1):
                    ans[k+n-1][k+n-1-j] = num
                    num += 1
                for i in range(n-1):
                    ans[k+n-1-i][k] = num
                    num += 1
                generate_matrix(num, n-2, k+1, ans)

        ans = [[0 for j in range(n)] for i in range(n)]
        generate_matrix(1, n, 0, ans)
        return ans
