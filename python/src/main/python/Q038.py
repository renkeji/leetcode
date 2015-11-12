from src.main.python.Solution import Solution

# The count-and-say sequence is the sequence of integers beginning as follows:
# 1, 11, 21, 1211, 111221, ...
#
# 1 is read off as "one 1" or 11.
# 11 is read off as "two 1s" or 21.
# 21 is read off as "one 2, then one 1" or 1211.
# Given an integer n, generate the nth sequence.
#
# Note: The sequence of integers will be represented as a string.


class Q038(Solution):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        def count_and_say(s):
            char, count = s[0], 0
            ans = ""
            for c in s:
                if c == char:
                    count += 1
                else:
                    ans += str(count) + char
                    char, count = c, 1
            ans += str(count) + char
            return ans

        ans = ""
        if n >= 1:
            ans = "1"
            for i in range(2, n+1):
                ans = count_and_say(ans)
        return ans
