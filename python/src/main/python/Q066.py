from src.main.python.Solution import Solution

# Given a non-negative number represented as an array of digits, plus one to the number.
#
# The digits are stored such that the most significant digit is at the head of the list.


class Q066(Solution):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        ans = []
        if digits:
            carry = 1
            for d in digits[::-1]:
                s = (d + carry) % 10
                ans.append(s)
                carry = (d + carry) // 10
            if carry:
                ans.append(1)
        return ans[::-1]
