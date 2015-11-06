from src.main.python.Solution import Solution

# Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
#
# For example, given n = 3, a solution set is:
#
# "((()))", "(()())", "(())()", "()(())", "()()()"


class Q022(Solution):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        def generate_parenthesis(left, right, path, ans):
            if not left and not right:
                ans.append(path)
            else:
                if left > 0:
                    generate_parenthesis(left-1, right, path+'(', ans)
                if right > left:
                    generate_parenthesis(left, right-1, path+')', ans)

        ans = []
        if n > 0:
            generate_parenthesis(n, n, "", ans)
        return ans
