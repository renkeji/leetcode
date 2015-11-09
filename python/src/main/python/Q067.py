from src.main.python.Solution import Solution

# Given two binary strings, return their sum (also a binary string).
#
# For example,
#   a = "11"
#   b = "1"
#   Return "100".


class Q067(Solution):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        ans = ""
        if a and b:
            num1 = a if len(a) >= len(b) else b
            num2 = a if len(a) < len(b) else b
            num2 = "0" * (len(num1)-len(num2)) + num2
            sum, carry = 0, 0
            for i in range(len(num1)-1, -1, -1):
                sum = (carry + int(num1[i]) + int(num2[i])) % 2
                carry = (carry + int(num1[i]) + int(num2[i])) // 2
                ans = str(sum) + ans
            ans = ans if not carry else str(carry) + ans
        return ans
