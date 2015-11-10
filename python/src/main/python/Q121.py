from src.main.python.Solution import Solution

# Say you have an array for which the ith element is the price of a given stock on day i.
#
# If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
# design an algorithm to find the maximum profit.


class Q121(Solution):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        max_p = 0
        if prices:
            buy = prices[0]
            for sell in prices:
                if sell >= buy:
                    max_p = max(max_p, sell - buy)
                else:
                    buy = sell
        return max_p