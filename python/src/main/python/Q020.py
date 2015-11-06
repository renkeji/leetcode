from src.main.python.Solution import Solution

# Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
#
# The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


class Q020(Solution):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        if s:
            for char in s:
                if char == '(' or char == '[' or char == '{':
                    stack.append(char)
                else:
                    if char == ')' and (not stack or stack[-1] != '('):
                        return False
                    elif char == ']' and (not stack or stack[-1] != '['):
                        return False
                    elif char == '}' and (not stack or stack[-1] != '{'):
                        return False
                    else:
                        stack.pop()
        return not stack
