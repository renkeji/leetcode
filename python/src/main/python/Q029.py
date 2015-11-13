from src.main.python.Solution import Solution

# Divide two integers without using multiplication, division and mod operator.
#
# If it is overflow, return MAX_INT.


class Q029(Solution):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        ans = 0
        if dividend:
            max_int, min_int = (1 << 31) - 1, -(1 << 31)
            is_negative = dividend < 0 < divisor or divisor < 0 < dividend
            big, small = abs(dividend), abs(divisor)
            temp, midres = small, 1

            while temp < big:
                temp <<= 1
                midres <<= 1

            while temp >= small:
                while big >= temp:
                    big -= temp
                    ans += midres
                temp >>= 1
                midres >>= 1

            ans = -ans if is_negative else ans
            ans = ans if min_int <= ans <= max_int else min_int if ans < min_int else max_int
        return ans
