from src.main.python.Solution import Solution

# Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
# parentheses substring.
#
# For "(()", the longest valid parentheses substring is "()", which has length = 2.
#
# Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


class Q032(Solution):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        ans = 0
        if s:
            stack = []
            start = 0
            for i in range(len(s)):
                if s[i] == '(':
                    stack.append(i)
                else:
                    if not stack:     # s[i] == ')'
                        start = i + 1
                    else:
                        stack.pop()
                        if not stack:
                            ans = max(ans, i-start+1)
                        else:
                            ans = max(ans, i-stack[-1])
        return ans
