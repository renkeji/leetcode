from src.main.python.Solution import Solution

# Say you have an array for which the ith element is the price of a given stock on day i.
#
# Design an algorithm to find the maximum profit. You may complete at most two transactions.
#
# Note:
#   You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


class Q123(Solution):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        max_p = 0
        if prices:
            profits = [0] * len(prices)
            buy, sell = prices[0], prices[-1]
            diff1, diff2 = 0, 0
            for i in range(len(prices)):
                if prices[i] > buy:
                    diff1 = max(diff1, prices[i] - buy)
                else:
                    buy = prices[i]

                if prices[-i-1] < sell:
                    diff2 = max(diff2, sell - prices[-i-1])
                else:
                    sell = prices[-i-1]

                profits[i] += diff1
                profits[-i-1] += diff2
            max_p = max(profits)
        return max_p
